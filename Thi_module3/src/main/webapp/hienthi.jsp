<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/9/2025
  Time: 9:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div>
        <form action="/mat-bang?action=search" method="post">
            <div class="row mb-2">
                <div class="col-md-4">
                    <label for="tang" class="form-label">Loại văn phòng</label>
                </div>
                <div class="col-md-8">
                    <select class="form-select" aria-label="Default select example" name="loai">
                        <option value="-1" selected>không</option>
                        <option value="1" >Văn phòng chia sẻ</option>
                        <option value="2">Văn phòng trọn gói</option>
                    </select>
                </div>
            </div>
            <div class="row mb-2">
                <div class="col-md-4">
                    <label for="tang" class="form-label">Tầng</label>
                </div>
                <div class="col-md-8">
                    <select class="form-select" aria-label="Default select example" name="tang">
                        <c:forEach var="tang" items="${tangs}" varStatus="status">
                            <option value="${tang}">${tang}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
        </form>
    </div>

    <div>
        <a href="/mat-bang?action=create" type="button" class="btn btn-primary">Thêm mặt bằng</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã MB</th>
            <th scope="col">Diện tích</th>
            <th scope="col">Trạng Thái</th>
            <th scope="col">Tầng</th>
            <th scope="col">Loại văn phòng</th>
            <th scope="col">Giá cho thuê</th>
            <th scope="col">Ngày bắt đầu</th>
            <th scope="col">Ngày kết thúc</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="mb" items="${matBangs}" varStatus="status">
            <tr>
                <th scope="row">${mb.maMB}</th>
                <td>${mb.dienTich}</td>
                <td>${mb.trangThai==0?'Trống':mb.trangThai==1?'Hạ tầng':'Đầy đủ'}</td>
                <td>${mb.soTang}</td>
                <td>${mb.loaiMB==1?'Văn phòng chia sẻ':'Văn phòng trọn gói'}</td>
                <td>${mb.giaThue}</td>
                <td>${mb.ngayBatDau}</td>
                <td>${mb.ngayKetThuc}</td>
                <td><a href="/mat-bang?action=delete&maMB=${mb.maMB}" onclick="return confirm('Bạn có chắc chắn muốn xoá ${mb.maMB}?')" class="btn btn-primary">Xoá</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
        integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
        crossorigin="anonymous"></script>
</body>
</html>
