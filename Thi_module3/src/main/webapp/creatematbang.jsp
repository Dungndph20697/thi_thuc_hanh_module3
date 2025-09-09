<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/9/2025
  Time: 9:40 AM
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

<div class="container mt-5">
    <div>
        <c:if test="${not empty validate}">
            <div class="alert alert-danger" role="alert">
                ${validate}
            </div>
        </c:if>
    </div>
    <form action="/mat-bang?action=add" method="post">
        <div class="row mb-2">
            <div class="col-md-4">
                <label for="ma" class="form-label">Mã mặt bằng (*)</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="ma" name="maMB" required>
            </div>
        </div>
        <div class="row mb-2">
            <div class="col-md-4">
                <label for="dienTich" class="form-label">Diện tích (*)</label>
            </div>
            <div class="col-md-8">
                <input type="number" class="form-control" id="dienTich" name="dienTich" required>
            </div>
        </div>
        <div class="row mb-2">
            <div class="col-md-4">
                <label for="trangThai" class="form-label">Trạng thái (*)</label>
            </div>
            <div class="col-md-8">
                <select class="form-select" aria-label="Default select example" name="trangThai">
                    <option value="0" selected>Trống</option>
                    <option value="1">Hạ tầng</option>
                    <option value="2">Đầy đủ</option>
                </select>
            </div>
        </div>
        <div class="row mb-2">
            <div class="col-md-4">
                <label for="tang" class="form-label">Tầng (*)</label>
            </div>
            <div class="col-md-8">
                <select class="form-select" aria-label="Default select example" name="tang">
                    <c:forEach var="tang" items="${tangs}" varStatus="status">
                        <option value="${tang}">${tang}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mb-2">
            <div class="col-md-4">
                <label for="loai" class="form-label" Loại văn phòng (*)</label>
            </div>
            <div class="col-md-8">
                <select class="form-select" aria-label="Default select example" name="loai">
                    <option value="1" selected>Văn phòng chia sẻ</option>
                    <option value="2">Văn phòng trọn gói</option>
                </select>
            </div>
        </div>
        <div class="row mb-2">
            <div class="col-md-4">
                <label for="moTa" class="form-label">Mô tả chi tiết </label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="moTa" name="moTa">
            </div>
        </div>
        <div class="row mb-2">
            <div class="col-md-4">
                <label for="gia" class="form-label">Giá cho thuê </label>
            </div>
            <div class="col-md-8">
                <input type="number" class="form-control" id="gia" name="giaThue" required>
            </div>
        </div>
        <div class="row mb-2">
            <div class="col-md-4">
                <label for="ngayBatDau" class="form-label">Ngày bắt đầu</label>
            </div>
            <div class="col-md-8">
                <input type="date" class="form-control" id="ngayBatDau" name="ngayBatDau">
            </div>
        </div>
        <div class="row mb-2">
            <div class="col-md-4">
                <label for="ngayKetThuc" class="form-label">Ngày kết thúc</label>
            </div>
            <div class="col-md-8">
                <input type="date" class="form-control" id="ngayKetThuc" name="ngayKetThuc">
            </div>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Lưu</button>
            <a href="/mat-bang" class="btn btn-secondary">Huỷ</a>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
        integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
        crossorigin="anonymous"></script>
</body>
</html>
