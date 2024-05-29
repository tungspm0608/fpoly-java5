package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.respository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class BanHang {
    SanPhamRespo sanPhamRespo = new SanPhamRespo();
    SPCTRespo spctRespo = new SPCTRespo();
    KhachHangRespo khachHangRespo = new KhachHangRespo();
    HoaDonRespo hoaDonRespo = new HoaDonRespo();
    HDCTRespo hdctRespo = new HDCTRespo();
    KichThuocRespo kichThuocRespo = new KichThuocRespo();
    MauSacRespo mauSacRespo = new MauSacRespo();

    private List<HoaDonChiTiet> buyList = new ArrayList<>();
    private KhachHang kh = new KhachHang();
    private String search = "";
    private Integer currentPage = 1;

    @GetMapping("ban-hang")
    public String viewBanHang(Model model,
                              @RequestParam(name = "idsp",required = false) Integer idsp,
                              @RequestParam(name = "soLuong",required = false) Integer soLuong) {
        model.addAttribute("currentPage",this.currentPage);
        List<SanPhamChiTiet> listAfterSearch = spctRespo.search(search,spctRespo.findAll());
        model.addAttribute("lastPage",spctRespo.getLastPage(listAfterSearch));
        model.addAttribute("search",search);
        model.addAttribute("spcts", spctRespo.getByPage(this.currentPage,listAfterSearch));

        model.addAttribute("sanphams", sanPhamRespo.findAll());
        model.addAttribute("mausacs", mauSacRespo.findAll());
        model.addAttribute("kichthuocs", kichThuocRespo.findAll());

        model.addAttribute("khachhang", this.kh);
        model.addAttribute("tongtien", this.tongTien());

        // Check xem co phai dang them san pham khong
        if (idsp != null && soLuong == null) {
            //Neu san pham da co trong danh sach thi cong them 1
            if (findbyIdSp(idsp,buyList) != null) {
                HoaDonChiTiet hdct = findbyIdSp(idsp,buyList);
                hdct.setSoLuong(hdct.getSoLuong()+1);
            } else {
                //Neu chua co thi them san pham vao buyList
                buyList.add(new HoaDonChiTiet(-1,-1,idsp,1,hdctRespo.findById(idsp).getDonGia(),0));
            }
        }

        //Check xem co phai la dang them so luong khong
        if (soLuong != null) {
            SanPhamChiTiet spct = spctRespo.findById(idsp);
            if (soLuong == 0) {
                buyList.remove(findbyIdSp(idsp,buyList));
            } else if (soLuong > spct.getSoLuong()) {
                findbyIdSp(idsp,buyList).setSoLuong(spct.getSoLuong());
                model.addAttribute("errSoLuong","khong du so luong");
            }
            else {
                findbyIdSp(idsp,buyList).setSoLuong(soLuong);
            }
        }

        model.addAttribute("hdcts", buyList);
        return "ban-hang";
    }

    @PostMapping("/ban-hang/khach-hang")
    public String banHang(@RequestParam(name = "sdt",required = false) String sdt) {
        this.kh = khachHangRespo.findBySDT(sdt);
        return "redirect:/ban-hang";
    }

    @PostMapping("/ban-hang/search")
    public String search(@RequestParam(name = "search", defaultValue = "") String search) {
        this.search = search;
        this.currentPage = 1;
        return "redirect:/ban-hang";
    }
    @PostMapping("/ban-hang/getPage")
    public String getPage(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage) {
        this.currentPage = currentPage;
        return "redirect:/ban-hang";
    }

    public HoaDonChiTiet findbyIdSp( Integer idsp, List<HoaDonChiTiet> list) {
        for (HoaDonChiTiet hdct: list) {
            if (hdct.getIdSPCT() == idsp) {
                return hdct;
            }
        }
        return null;
    }

    public Double tongTien () {
        Double tongtien = 0.0;
        for (HoaDonChiTiet hdct: this.buyList) {
            tongtien += hdct.getDonGia()*hdct.getSoLuong();
        }
        return tongtien;
    }

    @PostMapping("/ban-hang")
    public String banHang(HttpServletRequest req) {
        if (buyList.size() == 0 || this.kh.getId() == null) {
            return "redirect:/ban-hang";
        }

        // set Hoa don
        NhanVien nv = (NhanVien) req.getSession().getAttribute("nhanvien");
        Integer idNv = nv.getId();
        Integer idHd = hoaDonRespo.findAll().size()+1;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date now = new Date();
        String ngayMuaHang = simpleDateFormat.format(now);

        //them vao hd
        hoaDonRespo.add(new HoaDon(idHd,idNv,this.kh.getId(),ngayMuaHang,0));

        //set hoa don chi tiet
        for (HoaDonChiTiet hdct: buyList) {
            hdct.setIdHd(idHd);
        }

        //them vao hdct
        hdctRespo.addList(buyList);

        //sua so luong sau khi mua
        for (HoaDonChiTiet hdct: buyList) {
            SanPhamChiTiet spct = spctRespo.findById(hdct.getIdSPCT());
            spct.setSoLuong(spct.getSoLuong() - hdct.getSoLuong());
        }

        //set lai cho lan mua tiep
        buyList.clear();
        return "redirect:/hoa-don/index";
//        return "redirect:/ban-hang";
    }
}
