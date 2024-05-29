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
public class KhachHang {
    private Integer id;
    @NotBlank(message = "Hãy Nhập Tên")
    private String ten;
    @NotBlank(message = "Nhập Số Điện Thoại")
    private String sdt;
    @NotBlank(message = "Nhập Mã Khánh Hàng")
    private String maKh;
    @NotNull(message = "Hãy Chọn Trạng Thái")
    @Digits(integer = 1,fraction = 0)
    private int trangThai;
}
