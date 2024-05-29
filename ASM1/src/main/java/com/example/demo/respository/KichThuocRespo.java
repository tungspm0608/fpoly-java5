package com.example.demo.respository;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.KichThuoc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KichThuocRespo {
    private List<KichThuoc> ds = new ArrayList<>();
    public KichThuocRespo(){
        ds.add(new KichThuoc(1, "KT001", "mini", 1));
        ds.add(new KichThuoc(2, "KT002", "nhỏ", 1));
        ds.add(new KichThuoc(3, "KT003", "trung bình", 1));
        ds.add(new KichThuoc(4, "KT004", "lớn", 1));

    }
    public List<KichThuoc> findAll(){
        return ds;
    }

    public Double getLastPage(List<KichThuoc> ds) {
        return Math.ceil((double) ds.size()/(double) 5);
    }

    public List<KichThuoc> getByPage(int page,List<KichThuoc> ds) {
        List<KichThuoc> list1 = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            if (i >= (page-1)*5 && i < page*5 ) {
                list1.add(ds.get(i));
            }
        }
        return list1;
    }

    public List<KichThuoc> search(String keyword,List<KichThuoc> ds) {
        return ds.stream()
                .filter(tl ->
                        tl.getId().toString().contains(keyword)
                                || tl.getMa().contains(keyword)
                ).collect(Collectors.toList());
    }

    public void create(KichThuoc kt){
        this.ds.add(kt);
    }
    public void deleteById(int id){
        this.ds.remove(findById(id));
    }
    public KichThuoc findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc kt = this.ds.get(i);
            if (kt.getId() == id){
                return kt;
            }
        }
        return null;
    }
    public void update(KichThuoc kt){
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc kt1 = this.ds.get(i);
            if (kt1.getId() == kt.getId()){
                this.ds.set(i,kt);
            }
        }
    }
}
