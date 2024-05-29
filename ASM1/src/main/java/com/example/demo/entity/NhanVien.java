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
public class NhanVien {
    private Integer id;
    @NotBlank(message = "Hãy Nhập Mã")
    private String maNv;
    @NotBlank(message = "Hãy Nhập Tên")
    private String ten;
    @NotBlank(message = "Hãy Nhập Tài Khoản")
    private String tenDangNhap;
    @NotBlank(message = "Hãy Nhập Mật Khẩu")
    private String matKhau;
    @NotNull(message = "Hãy Chọn Trạng Thái")
    @Digits(integer = 1,fraction = 0)
    private int trangThai;
}
