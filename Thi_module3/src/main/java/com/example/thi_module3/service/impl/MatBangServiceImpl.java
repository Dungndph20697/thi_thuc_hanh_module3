package com.example.thi_module3.service.impl;

import com.example.thi_module3.dao.IMatBang;
import com.example.thi_module3.dao.impl.MatBangDaoImpl;
import com.example.thi_module3.model.MatBang;
import com.example.thi_module3.service.IMatBangService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MatBangServiceImpl implements IMatBangService {

    private IMatBang matBangDAO;

    public MatBangServiceImpl() {
        matBangDAO = new MatBangDaoImpl();
    }

    @Override
    public List<MatBang> findAll() {
        return matBangDAO.findAll();
    }

    @Override
    public void save(MatBang matBang) {
        matBangDAO.save(matBang);
    }

    @Override
    public void delete(String maMB) {
        matBangDAO.delete(maMB);
    }

    @Override
    public String validateMa(MatBang matBang) {
        boolean checkMa = !matBang.getMaMB().matches("^[A-Z]{3}-[A-Z]{2}-[A-Z]{2}$");
        boolean checkDienTich = matBang.getDienTich() >= 20;
        boolean checkGia = matBang.getGiaThue().compareTo(new BigDecimal("1000000")) > 0;
        String result = "";
        if (checkMa) {
            result = "Mã không đúng định dạng (XXX-XX-XX)";
        }
        if (!checkDienTich) {
            result = "Diện tích phải lớn hơn hoặc bằng 20m2";
        }
        if (!checkGia) {
            result = "Giá thuê phải lớn hơn 1.000.000 VND";
        }
        return result;
    }

    @Override
    public String fomatDate(String date) {
        try {
            if (date == null) return "";
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parsedDate = inputFormat.parse(date);
            return date.format(String.valueOf(parsedDate));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public List<MatBang> findByLoai(int loai) {
        return  matBangDAO.findByLoai(loai);
    }

    @Override
    public List<MatBang> findByTang(int tang) {
        return matBangDAO.findByTang(tang);
    }
}
