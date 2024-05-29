package com.example.demo.respository;

import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.NhanVien;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NhanVienRespo {
    private List<NhanVien> ds = new ArrayList<>();
    public static NhanVien nv = null;
    public NhanVienRespo(){
        ds.add(new NhanVien(1,  "NV001","Tùng admin", "dangnhap1", "matkhau1", 1));
        ds.add(new NhanVien(2,  "NV002","Khánh nv", "dangnhap2", "matkhau2", 0));
        ds.add(new NhanVien(3,  "NV003","Lưu nv", "dangnhap3", "matkhau3", 0));
        ds.add(new NhanVien(4,  "NV004","Vũ nv", "dangnhap4", "matkhau4", 0));
        ds.add(new NhanVien(5,  "NV005","Chất nv", "dangnhap5", "matkhau5", 0));
        ds.add(new NhanVien(6,  "NV005","Hương nv", "dangnhap5", "matkhau5", 0));
    }
    public List<NhanVien> findAll(){
        return ds;
    }

    public Double getLastPage(List<NhanVien> ds) {
        return Math.ceil((double) ds.size()/(double) 5);
    }

    public List<NhanVien> getByPage(int page,List<NhanVien> ds) {
        List<NhanVien> list1 = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            if (i >= (page-1)*5 && i < page*5 ) {
                list1.add(ds.get(i));
            }
        }
        return list1;
    }

    public List<NhanVien> search(String keyword,List<NhanVien> ds) {
        return ds.stream()
                .filter(tl ->
                        tl.getId().toString().contains(keyword)
                                || tl.getMaNv().contains(keyword)
                        || tl.getTenDangNhap().contains(keyword)
                ).collect(Collectors.toList());
    }

    public void create(NhanVien nv){
        nv.setId(ds.size()+1);
        this.ds.add(nv);
    }
    public void delete(int id){
       this.ds.remove(findById(id));
    }
    public NhanVien findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nv = this.ds.get(i);
            if (nv.getId() == id){
                return nv;
            }
        }
        return null;
    }
    public void update(NhanVien nv){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nv1 = this.ds.get(i);
            if (nv1.getId() == nv.getId()){
                this.ds.set(i,nv);
            }
        }
    }
    public String dangNhap (String un, String pw) {
        if (un.isBlank()) return "Không đươc để trống tên đăng nhập";
        if (pw.isBlank()) return "Không đươc để trống mật khẩu";
        if (pw.length() < 6) return "Mật khẩu phải lớn hơn 5 kí tự";
        for (NhanVien s: ds) {
            if (s.getTenDangNhap().equals(un)) {
                if (s.getMatKhau().equals(pw)) {
                    nv = s;
                    return null;
                }
                return "Sai mật khẩu";
            }
        }
        return "Tài khoản không tồn tại";
    }
}
