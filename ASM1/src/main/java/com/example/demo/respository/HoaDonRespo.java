package com.example.demo.respository;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.HoaDon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HoaDonRespo {
    public static List<HoaDon> ds  = new ArrayList<>();
    static {
        ds.add(new HoaDon(1,1, 1, "2024-05-18", 1));
        ds.add(new HoaDon(2,2, 2, "2024-05-19", 1));
        ds.add(new HoaDon(3,3, 3, "2024-05-20", 1));
    }

    public HoaDonRespo() {
    }

    public void add(HoaDon hd) {
        this.ds.add(hd);
    }
    public List<HoaDon> findAll(){
        return ds;
    }

    public Double getLastPage(List<HoaDon> ds) {
        return Math.ceil((double) ds.size()/(double) 5);
    }

    public List<HoaDon> getByPage(int page,List<HoaDon> ds) {
        List<HoaDon> list1 = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            if (i >= (page-1)*5 && i < page*5 ) {
                list1.add(ds.get(i));
            }
        }
        return list1;
    }

    public List<HoaDon> search(String keyword,List<HoaDon> ds) {
        return ds.stream()
                .filter(tl ->
                        tl.getIdNv().toString().contains(keyword)
                        || tl.getIdKh().toString().contains(keyword)
                ).collect(Collectors.toList());
    }

    public HoaDon findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon hd = this.ds.get(i);
            if (hd.getId() == id){
                return hd;
            }
        }
        return null;
    }
    public void update(HoaDon hd){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDon hd1 = this.ds.get(i);
            if (hd1.getId() == hd.getId()){
                this.ds.set(i,hd);
            }
        }
    }
}
