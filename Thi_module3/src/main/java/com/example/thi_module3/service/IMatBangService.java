package com.example.thi_module3.service;

import com.example.thi_module3.model.MatBang;

import java.util.List;

public interface IMatBangService {

    List<MatBang> findAll();

    void save(MatBang matBang);

    void delete(String maMB);

    String validateMa(MatBang matBang);

    String fomatDate(String date);

    List<MatBang> findByLoai(int loai);

    List<MatBang> findByTang(int tang);
}
