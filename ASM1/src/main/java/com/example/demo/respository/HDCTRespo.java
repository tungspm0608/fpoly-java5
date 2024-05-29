package com.example.demo.respository;

import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.entity.HoaDonChiTiet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HDCTRespo {
    public static List<HoaDonChiTiet> ds = new ArrayList<>();
    static {
        ds.add(new HoaDonChiTiet(1,1, 1, 10, 100.0, 1));
        ds.add(new HoaDonChiTiet(2,1, 2, 20, 200.0, 1));
        ds.add(new HoaDonChiTiet(3,1, 3, 30, 300.0, 1));
        ds.add(new HoaDonChiTiet(4,2, 4, 40, 400.0, 1));
        ds.add(new HoaDonChiTiet(5,2, 5, 50, 500.0, 1));
        ds.add(new HoaDonChiTiet(6,2, 5, 50, 500.0, 1));
        ds.add(new HoaDonChiTiet(7,3, 5, 50, 500.0, 1));
        ds.add(new HoaDonChiTiet(8,3, 5, 50, 500.0, 1));
        ds.add(new HoaDonChiTiet(9,3, 5, 50, 500.0, 1));

    }
    public List<HoaDonChiTiet> findAll(){
        return ds;
    }

    public Double getLastPage(List<HoaDonChiTiet> ds) {
        return Math.ceil((double) ds.size()/(double) 5);
    }

    public List<HoaDonChiTiet> getByPage(int page,List<HoaDonChiTiet> ds) {
        List<HoaDonChiTiet> list1 = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            if (i >= (page-1)*5 && i < page*5 ) {
                list1.add(ds.get(i));
            }
        }
        return list1;
    }

    public List<HoaDonChiTiet> search(String keyword,List<HoaDonChiTiet> ds) {
        return ds.stream()
                .filter(tl ->
                        tl.getIdSPCT().toString().contains(keyword)
                        || tl.getId().toString().contains(keyword)
                ).collect(Collectors.toList());
    }

    public HoaDonChiTiet findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonChiTiet hdct = this.ds.get(i);
            if (hdct.getId() == id){
                return hdct;
            }
        }
        return null;
    }
    public void update(HoaDonChiTiet hdct){
        for (int i = 0; i < this.ds.size(); i++) {
            HoaDonChiTiet hdct1 = this.ds.get(i);
            if (hdct1.getId() == hdct.getId()){
                this.ds.set(i,hdct);
            }
        }
    }

    public void add(HoaDonChiTiet hdct) {
        hdct.setId(this.ds.size()+1);
        this.ds.add(hdct);
    }

    public void addList(List<HoaDonChiTiet> list) {
        int stt = this.ds.size() + 1;
        for (HoaDonChiTiet hdct: list) {
            hdct.setId(stt);
            stt += 1;
        }
        this.ds.addAll(list);
    }
}
