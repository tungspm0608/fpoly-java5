package com.example.demo.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HoaDon {
    private Integer id;
    private Integer idNv;
    private Integer idKh;
    @NotBlank(message = "Hãy Nhập Ngày Mua Hàng")
    private String ngayMuaHang;
    @NotNull(message = "Hãy Chọn Trạng Thái")
    @Digits(integer = 1,fraction = 0)
    private int trangThai;
}
