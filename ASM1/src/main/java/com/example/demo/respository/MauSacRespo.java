package com.example.demo.respository;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.MauSac;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MauSacRespo {
    private List<MauSac> ds = new ArrayList<>();
    public MauSacRespo(){
        ds.add(new MauSac(1, "MS001", "bạch kim", 1));
        ds.add(new MauSac(2, "MS002", "ngũ sắc", 1));
        ds.add(new MauSac(3, "MS003", "vàng đen", 1));
        ds.add(new MauSac(4, "MS004", "darklo", 1));
    }
    public List<MauSac> findAll(){
        return ds;
    }

    public Double getLastPage(List<MauSac> ds) {
        return Math.ceil((double) ds.size()/(double) 5);
    }

    public List<MauSac> getByPage(int page,List<MauSac> ds) {
        List<MauSac> list1 = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            if (i >= (page-1)*5 && i < page*5 ) {
                list1.add(ds.get(i));
            }
        }
        return list1;
    }

    public List<MauSac> search(String keyword,List<MauSac> ds) {
        return ds.stream()
                .filter(tl ->
                        tl.getId().toString().contains(keyword)
                                || tl.getMa().contains(keyword)
                        || tl.getTen().contains(keyword)
                ).collect(Collectors.toList());
    }

    public void create(MauSac ms){
        ms.setId(this.ds.size()+1);
        this.ds.add(ms);
    }
    public void deleteById(int id){
        this.ds.remove(findById(id));
    }
    public MauSac findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac ms = this.ds.get(i);
            if (ms.getId() == id){
                return ms;
            }
        }
        return null;
    }
    public void update(MauSac ms){
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac ms1 = this.ds.get(i);
            if (ms1.getId() == ms.getId()){
                this.ds.set(i,ms);
            }
        }
    }
}
