package com.example.thi_module3.controller;

import com.example.thi_module3.model.MatBang;
import com.example.thi_module3.service.IMatBangService;
import com.example.thi_module3.service.impl.MatBangServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MatBangController", urlPatterns = "/mat-bang")
public class MatBangController extends HttpServlet {
    private IMatBangService matBangService;

    @Override
    public void init() throws ServletException {
        matBangService = new MatBangServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            default:
                listMatBangs(req, resp);
                break;
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        String maMB = req.getParameter("maMB");
        matBangService.delete(maMB);
        try {
            resp.sendRedirect("/mat-bang");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addMatBang(req, resp);
                break;
            case "search":
                searchMatBang(req, resp);
                break;
            default:
                listMatBangs(req, resp);
                break;
        }

    }

    private void searchMatBang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int loai = Integer.valueOf(req.getParameter("loai"));
        int tang = Integer.valueOf(req.getParameter("tang"));
        if (loai == -1 && tang == 0) {
            resp.sendRedirect("/mat-bang");
        } else {
            if (tang == 0) {
                List<Integer> tangs = new ArrayList<>();
                for (int i = 0; i <= 15; i++) {
                    tangs.add(i);
                }
                List<MatBang> matBangs = matBangService.findByLoai(loai);
                req.setAttribute("tangs", tangs);
                req.setAttribute("matBangs", matBangs);
                req.getRequestDispatcher("/hienthi.jsp").forward(req, resp);
            }
            if (loai == 0){
                List<Integer> tangs = new ArrayList<>();
                for (int i = 0; i <= 15; i++) {
                    tangs.add(i);
                }
                List<MatBang> matBangs = matBangService.findByTang(tang);
                req.setAttribute("tangs", tangs);
                req.setAttribute("matBangs", matBangs);
                req.getRequestDispatcher("/hienthi.jsp").forward(req, resp);
            }
        }
    }

    private void addMatBang(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String maMB = req.getParameter("maMB");
        int trangThai = Integer.parseInt(req.getParameter("trangThai"));
        int loaiMB = Integer.parseInt(req.getParameter("loai"));
        int dienTich = Integer.parseInt(req.getParameter("dienTich"));
        BigDecimal giaThueStr = BigDecimal.valueOf(Double.valueOf(req.getParameter("giaThue")));
        int soTangStr = Integer.valueOf(req.getParameter("tang"));
        String ngayBatDau = req.getParameter("ngayBatDau");
        String ngayKetThuc = req.getParameter("ngayKetThuc");
        String moTa = req.getParameter("moTa");
        MatBang matBang = MatBang.builder()
                .maMB(maMB)
                .trangThai(trangThai)
                .loaiMB(loaiMB)
                .dienTich(dienTich)
                .ngayBatDau(ngayBatDau)
                .ngayKetThuc(ngayKetThuc)
                .moTa(moTa)
                .giaThue(giaThueStr)
                .soTang(soTangStr)
                .build();
        String validate = matBangService.validateMa(matBang);
        if (!validate.equals("")) {
            List<Integer> tangs = new ArrayList<>();
            for (int i = 1; i <= 15; i++) {
                tangs.add(i);
            }
            req.setAttribute("tangs", tangs);
            req.setAttribute("validate", validate);
            req.getRequestDispatcher("/creatematbang.jsp").forward(req, resp);
        } else {
            matBangService.save(matBang);
            resp.sendRedirect("/mat-bang");
        }
    }

    private void listMatBangs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> tangs = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            tangs.add(i);
        }
        List<MatBang> matBangs = matBangService.findAll();
        req.setAttribute("tangs", tangs);
        req.setAttribute("matBangs", matBangs);
        req.getRequestDispatcher("/hienthi.jsp").forward(req, resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> tangs = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            tangs.add(i);
        }
        req.setAttribute("tangs", tangs);
        req.getRequestDispatcher("/creatematbang.jsp").forward(req, resp);
    }
}
