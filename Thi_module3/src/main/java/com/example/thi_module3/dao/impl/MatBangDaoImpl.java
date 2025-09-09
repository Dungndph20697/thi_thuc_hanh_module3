package com.example.thi_module3.dao.impl;

import com.example.thi_module3.dao.IMatBang;
import com.example.thi_module3.model.MatBang;
import com.example.thi_module3.utils.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatBangDaoImpl implements IMatBang {
    private static final String SELECT_ALL = "select * from mat_bang order by dien_tich asc;";
    private static final String INSERT_MATBANG = "INSERT INTO mat_bang (ma_mat_bang, dien_tich, trang_thai, loai, gia, ngay_bat_dau, ngay_ket_thuc, so_tang,mo_ta) VALUES\n" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_MATBANG = "DELETE FROM mat_bang WHERE ma_mat_bang = ?;";
    private static final String SELECT_BY_MA = "select * from mat_bang where ma_mat_bang = ?;";

    private static final String SELECT_BY_LOAI = "select * from mat_bang where loai = ?";

    private static final String SELECT_BY_TANG = "select * from mat_bang where so_tang = ?";

    @Override
    public List<MatBang> findAll() {
        List<MatBang> matBangs = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             Statement stmt = conn.createStatement();) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                String maMB = rs.getString("ma_mat_bang");
                int dienTich = rs.getInt("dien_tich");
                int trangThai = rs.getInt("trang_thai");
                int soTang = rs.getInt("so_tang");
                BigDecimal giaThue = rs.getBigDecimal("gia");
                int loaiMB = rs.getInt("loai");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");
                String moTa = rs.getString("mo_ta");
                matBangs.add(new MatBang(maMB, trangThai, loaiMB, dienTich, giaThue, soTang, ngayBatDau, ngayKetThuc, moTa));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return matBangs;
    }

    @Override
    public void save(MatBang matBang) {
        int rowAffected = 0;
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_MATBANG);) {
            pstmt.setString(1, matBang.getMaMB());
            pstmt.setInt(2, matBang.getDienTich());
            pstmt.setInt(3, matBang.getTrangThai());
            pstmt.setInt(4, matBang.getLoaiMB());
            pstmt.setBigDecimal(5, matBang.getGiaThue());
            pstmt.setString(6, matBang.getNgayBatDau());
            pstmt.setString(7, matBang.getNgayKetThuc());
            pstmt.setInt(8, matBang.getSoTang());
            pstmt.setString(9, matBang.getMoTa());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String maMB) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(DELETE_MATBANG);
            pstmt.setString(1, maMB);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MatBang findByMa(String maMB) {
        MatBang matBang = null;
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_MA);) {
            pstmt.setString(1, maMB);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                matBang = new MatBang();
                String maMBResult = rs.getString("ma_mat_bang");
                int dienTich = rs.getInt("dien_tich");
                int trangThai = rs.getInt("trang_thai");
                int soTang = rs.getInt("so_tang");
                BigDecimal giaThue = rs.getBigDecimal("gia");
                int loaiMB = rs.getInt("loai");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");
                String moTa = rs.getString("mo_ta");
                matBang.setMaMB(maMBResult);
                matBang.setDienTich(dienTich);
                matBang.setTrangThai(trangThai);
                matBang.setSoTang(soTang);
                matBang.setGiaThue(giaThue);
                matBang.setLoaiMB(loaiMB);
                matBang.setNgayBatDau(ngayBatDau);
                matBang.setNgayKetThuc(ngayKetThuc);
                matBang.setMoTa(moTa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return matBang;
    }

    @Override
    public List<MatBang> findByLoai(int loai) {
        List<MatBang> matBangs = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_LOAI);) {
            pstmt.setInt(1, loai);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String maMB = rs.getString("ma_mat_bang");
                int dienTich = rs.getInt("dien_tich");
                int trangThai = rs.getInt("trang_thai");
                int soTang = rs.getInt("so_tang");
                BigDecimal giaThue = rs.getBigDecimal("gia");
                int loaiMB = rs.getInt("loai");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");
                String moTa = rs.getString("mo_ta");
                matBangs.add(new MatBang(maMB, trangThai, loaiMB, dienTich, giaThue, soTang, ngayBatDau, ngayKetThuc, moTa));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return matBangs;
    }

    @Override
    public List<MatBang> findByTang(int tang) {
        List<MatBang> matBangs = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_TANG);) {
            pstmt.setInt(1, tang);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String maMB = rs.getString("ma_mat_bang");
                int dienTich = rs.getInt("dien_tich");
                int trangThai = rs.getInt("trang_thai");
                int soTang = rs.getInt("so_tang");
                BigDecimal giaThue = rs.getBigDecimal("gia");
                int loaiMB = rs.getInt("loai");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");
                String moTa = rs.getString("mo_ta");
                matBangs.add(new MatBang(maMB, trangThai, loaiMB, dienTich, giaThue, soTang, ngayBatDau, ngayKetThuc, moTa));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return matBangs;
    }

}
