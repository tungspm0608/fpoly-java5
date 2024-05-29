package com.example.demo.entity;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SanPhamChiTiet {
    private Integer id;
    @NotBlank(message = "Hãy Nhập Mã")
    private String ma;
    @NotBlank(message = "Hãy Nhập Kích Thước")
    private String kt;
    @NotBlank(message = "Hãy Nhập Màu Sắc")
    private String ms;
    @NotBlank(message = "Hãy Nhập Sản Phẩm")
    private String sp;
    @NotNull(message = "Hãy Nhập Số Lượng")
    private Integer soLuong;
    @NotNull(message = "Hãy Nhập Đơn Giá")
    @Positive(message = "Đơn Giá phải là số dương")
    private Double donGia;
    @NotNull(message = "Hãy Chọn Trạng Thái")
    @Digits(integer = 1,fraction = 0)
    private int trangThai;
}
