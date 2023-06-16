<%--
  Created by IntelliJ IDEA.
  User: PH22349
  Date: 28/03/2023
  Time: 2:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form class="form-group" action="/cua-hang/detail" method="get">
    <label>Mã</label>
    <input name="ma" placeholder="Mã" type="text" class="form-control" value="${cuaHang.ma}">
    <label>Tên</label>
    <input name="ten" placeholder="Tên" type="text" class="form-control" value="${cuaHang.ten}">
    <label>Địa Chỉ</label>
    <input name="diaChi" placeholder="Địa Chỉ" type="text" class="form-control" value="${cuaHang.diaChi}">
    <label>Thành Phố</label>
    <input name="thanhPho" placeholder="Thành Phố" type="text" class="form-control" value="${cuaHang.thanhPho}">
    <label>Quốc Gia</label>
    <input name="quocGia" placeholder="Quốc Gia" type="text" class="form-control" value="${cuaHang.quocGia}">
    <br>
    <a class="btn btn-primary" href="/cua-hang/hien-thi" type="button"> Quay lại</a>
</form>
</body>
</html>
