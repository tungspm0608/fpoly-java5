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
public class HoaDonChiTiet {
    private Integer id;
    private Integer idHd;
    private Integer idSPCT;
    @NotNull(message = "Hãy Nhập Số Lượng")
    private Integer soLuong;
    @NotNull(message = "Hãy Nhập Đơn Giá")
    private Double donGia;
    @NotNull(message = "Hãy Chọn Trạng Thái")
    @Digits(integer = 1,fraction = 0)
    private int trangThai;
}
