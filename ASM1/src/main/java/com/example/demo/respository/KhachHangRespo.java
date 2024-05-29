package com.example.demo.respository;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.KhachHang;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KhachHangRespo {
    private List<KhachHang> ds = new ArrayList<>();
    public KhachHangRespo(){
        ds.add(new KhachHang(1, "Phùng Văn Tùng", "123456789", "KH001", 1));
        ds.add(new KhachHang(2, "Nguyễn Thị Anh", "987654321", "KH002", 1));
        ds.add(new KhachHang(3, "Phùng Nguyễn Lưu", "111222333", "KH003", 1));
        ds.add(new KhachHang(4, "Nguyễn Thị Trang", "444555666", "KH004", 1));
        ds.add(new KhachHang(5, "Lê Văn Cao", "777888999", "KH005", 1));
    }
    public List<KhachHang> findAll(){
        return ds;
    }
    public Double getLastPage(List<KhachHang> ds) {
        return Math.ceil((double) ds.size()/(double) 5);
    }

    public List<KhachHang> getByPage(int page,List<KhachHang> ds) {
        List<KhachHang> list1 = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            if (i >= (page-1)*5 && i < page*5 ) {
                list1.add(ds.get(i));
            }
        }
        return list1;
    }

    public List<KhachHang> search(String keyword,List<KhachHang> ds) {
        return ds.stream()
                .filter(tl ->
                        tl.getId().toString().contains(keyword)
                                || tl.getTen().contains(keyword)
                                || tl.getSdt().contains(keyword)
                                || tl.getMaKh().contains(keyword)
                ).collect(Collectors.toList());
    }

    public void add(KhachHang kh){
        kh.setId(ds.size()+1);
        this.ds.add(kh);
    }
    public void deleteById(int id){
        this.ds.remove(findById(id));
    }
    public KhachHang findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang kh = this.ds.get(i);
            if (kh.getId() == id){
                return kh;
            }
        }
        return null;
    }
    public KhachHang findBySDT(String sdt){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang kh = this.ds.get(i);
            if (kh.getSdt().equalsIgnoreCase(sdt)){
                return kh;
            }
        }
        return null;
    }
    public void update(KhachHang kh){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang kh1 = this.ds.get(i);
            if (kh1.getId() == kh.getId()){
                this.ds.set(i,kh);
            }
        }
    }
}
