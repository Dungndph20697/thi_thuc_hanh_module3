package com.example.thi_module3.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MatBang {
    private String maMB;
    private int trangThai;
    private int loaiMB;
    private int dienTich;
    private BigDecimal giaThue;
    private int soTang;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String moTa;

}
