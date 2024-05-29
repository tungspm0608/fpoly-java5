package com.example.demo.respository;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.entity.SanPhamChiTiet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SPCTRespo {
    private List<SanPhamChiTiet> ds = new ArrayList<>();
    public SPCTRespo(){
        ds.add(new SanPhamChiTiet(1, "SP001", "KT001", "MS001", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(2, "SP001", "KT001", "MS001", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(3, "SP001", "KT001", "MS001", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(4, "SP001", "KT001", "MS001", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(5, "SP002", "KT002", "MS002", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(6, "SP002", "KT002", "MS002", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(7, "SP002", "KT002", "MS002", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(8, "SP002", "KT002", "MS002", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(9, "SP003", "KT003", "MS003", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(10, "SP003", "KT003", "MS003", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(11, "SP003", "KT003", "MS003", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(12, "SP003", "KT003", "MS003", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(13, "SP004", "KT004", "MS004", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(14, "SP004", "KT004", "MS004", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(15, "SP004", "KT004", "MS004", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(16, "SP004", "KT004", "MS004", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(17, "SP005", "KT002", "MS003", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(18, "SP005", "KT002", "MS003", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(19, "SP005", "KT002", "MS003", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(20, "SP005", "KT002", "MS003", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(21, "SP006", "KT002", "MS001", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(22, "SP006", "KT002", "MS001", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(23, "SP006", "KT002", "MS001", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(24, "SP006", "KT002", "MS001", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(25, "SP007", "KT004", "MS001", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(26, "SP007", "KT004", "MS001", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(27, "SP007", "KT004", "MS001", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(28, "SP007", "KT004", "MS001", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(29, "SP008", "KT001", "MS004", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(30, "SP008", "KT001", "MS004", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(31, "SP008", "KT001", "MS004", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(32, "SP008", "KT001", "MS004", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(33, "SP009", "KT003", "MS001", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(34, "SP009", "KT003", "MS001", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(35, "SP009", "KT003", "MS001", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(36, "SP009", "KT003", "MS001", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(37, "SP010", "KT002", "MS001", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(38, "SP010", "KT002", "MS001", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(39, "SP010", "KT002", "MS001", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(40, "SP010", "KT002", "MS001", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(41, "SP011", "KT001", "MS002", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(42, "SP011", "KT001", "MS002", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(43, "SP011", "KT001", "MS002", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(44, "SP011", "KT001", "MS002", "Sữa lốc", 5, 50.0, 1));

        ds.add(new SanPhamChiTiet(45, "SP012", "KT002", "MS003", "Sữa bột", 10, 100.0, 1));
        ds.add(new SanPhamChiTiet(46, "SP012", "KT002", "MS003", "Sữa lon", 30, 10.0, 1));
        ds.add(new SanPhamChiTiet(47, "SP012", "KT002", "MS003", "Sữa chai", 40, 15.0, 1));
        ds.add(new SanPhamChiTiet(48, "SP012", "KT002", "MS003", "Sữa lốc", 5, 50.0, 1));
    }
    public List<SanPhamChiTiet> findAll(){
        return ds;
    }

    public Double getLastPage(List<SanPhamChiTiet> ds) {
        return Math.ceil((double) ds.size()/(double) 5);
    }

    public List<SanPhamChiTiet> getByPage(int page,List<SanPhamChiTiet> ds) {
        List<SanPhamChiTiet> list1 = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            if (i >= (page-1)*5 && i < page*5 ) {
                list1.add(ds.get(i));
            }
        }
        return list1;
    }

    public List<SanPhamChiTiet> search(String keyword,List<SanPhamChiTiet> ds) {
        return ds.stream()
                .filter(tl ->
                            tl.getId().toString().contains(keyword)
                                    || tl.getMa().contains(keyword)
                ).collect(Collectors.toList());
    }

    public void create(SanPhamChiTiet sp){
        sp.setId(this.ds.size()+1);
       this.ds.add(sp);
    }
    public void deleteById(int id){
        this.ds.remove(findById(id));
    }
    public SanPhamChiTiet findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamChiTiet sp = this.ds.get(i);
            if (sp.getId() == id){
                return sp;
            }
        }
        return null;
    }
    public void update(SanPhamChiTiet sp){
        for (int i = 0; i < this.ds.size(); i++) {
            SanPhamChiTiet sp1 = this.ds.get(i);
            if (sp1.getId() == sp.getId()){
                this.ds.set(i,sp);
            }
        }
    }
}
