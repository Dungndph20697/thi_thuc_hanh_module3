package com.example.thi_module3.dao;

import com.example.thi_module3.model.MatBang;

import java.util.List;

public interface IMatBang {

    List<MatBang> findAll();

    void save(MatBang matBang);

    void delete(String maMB);

    MatBang findByMa(String maMB);

    List<MatBang> findByLoai(int loai);

    List<MatBang> findByTang(int tang);
}
