package com.example.demo.respository;

import com.example.demo.entity.SanPham;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SanPhamRespo {
    private List<SanPham> ds = new ArrayList<>();
    public  SanPhamRespo(){
        ds.add(new SanPham(1, "SP001", "Sữa Vinamilk", 1));
        ds.add(new SanPham(2, "SP002", "Sữa Th true Milk", 1));
        ds.add(new SanPham(3, "SP003", "Sữa Dutch Lady", 1));
        ds.add(new SanPham(4, "SP004", "Sữa Milo", 1));
        ds.add(new SanPham(5, "SP005", "Sữa Lynx", 1));
        ds.add(new SanPham(6, "SP006", "Sữa Bombman", 1));
        ds.add(new SanPham(7, "SP007", "Sữa dammit2k", 1));
        ds.add(new SanPham(8, "SP008", "Sữa theanh96", 1));
        ds.add(new SanPham(9, "SP009", "Sữa something", 1));
        ds.add(new SanPham(10, "SP010", "Sữa faker", 1));
        ds.add(new SanPham(11, "SP011", "Sữa spike", 1));
        ds.add(new SanPham(12, "SP012", "Sữa lyxuan", 1));
    }
    public List<SanPham> findAll(){
        return ds;
    }

    public Double getLastPage(List<SanPham> ds) {
        return Math.ceil((double) ds.size()/(double) 5);
    }

    public List<SanPham> getByPage(int page,List<SanPham> ds) {
        List<SanPham> list1 = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            if (i >= (page-1)*5 && i < page*5 ) {
                list1.add(ds.get(i));
            }
        }
        return list1;
    }

    public void create(SanPham sp){
        sp.setId(ds.size()+1);
        ds.add(sp);
    }
    public void deleteById(int id){
        this.ds.remove(findById(id));
    }
    public SanPham findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            SanPham sp = this.ds.get(i);
            if (sp.getId() == id){
                return sp;
            }
        }
        return null;
    }

    public List<SanPham> search(String keyword,List<SanPham> ds) {
        return ds.stream()
                .filter(tl ->
                        tl.getTen().toLowerCase(Locale.ROOT).contains(keyword)
                                || tl.getId().toString().contains(keyword)
                                || tl.getMa().contains(keyword)
                ).collect(Collectors.toList());
    }

    public List<SanPham> checkConHang(int trangThai,List<SanPham> ds) {
        if (trangThai == 2) return ds;
        List<SanPham> list1 = new ArrayList<>();
        for (SanPham sp: ds) {
            if (sp.getTrangThai() == trangThai) {
                list1.add(sp);
            }
        }
        return list1;
    }

    public void update(SanPham sp){
        for (int i = 0; i < this.ds.size(); i++) {
            SanPham sp1 = this.ds.get(i);
            if (sp1.getId() == sp.getId()){
                this.ds.set(i,sp    );
            }
        }
    }
}
