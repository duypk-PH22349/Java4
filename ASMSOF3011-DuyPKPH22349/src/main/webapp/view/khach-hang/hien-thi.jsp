<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 11/03/2023
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../layout/header.jsp"%>

<form class="form-group" action="/khach-hang/hien-thi" method="post">

    <label>Ma</label>
    <input name="ma" placeholder="Mã" class="form-control" type="text">
    <label>Tên</label>
    <input name="ten" placeholder="Tên" class="form-control" type="text">
    <label>Tên Đệm</label>
    <input name="tenDem" placeholder="Tên Đệm" class="form-control"  type="text">
    <label>Họ</label>
    <input name="ho" placeholder="Họ" class="form-control" type="text">
    <label>Ngày Sinh</label>
    <input name="ngaySinh" type="date" placeholder="Ngày Sinh" class="form-control">
    <label>SĐT</label>
    <input name="sdt" placeholder="SĐT" class="form-control" type="text">
    <label>Địa Chỉ</label>
    <input name="diaChi" placeholder="Địa Chỉ" class="form-control" type="text">
    <label>Thành Phố</label>
    <input name="thanhPho" placeholder="Thành Phố" class="form-control" type="text" >
    <label>Quốc Gia</label>
    <input name="quocGia" placeholder="Quốc Gia" class="form-control" type="text">
    <label>Mật Khẩu</label>
    <input name="matKhau" placeholder="Mật Khẩu" class="form-control"  type="text">
    <br>
    <button class="btn btn-primary" type="submit">Thêm</button>
</form>
<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Mã</td>
        <td>Họ và Tên</td>
        <td>Ngày Sinh</td>
        <td>Sdt</td>
        <td>Địa Chỉ</td>
        <td>Thành Phố</td>
        <td>Quốc Gia</td>
        <td>Mật Khẩu</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listHienThi}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.ma}</td>
            <td>${l.ho}  ${l.tenDem}  ${l.ten}</td>
            <td>${l.ngaySinh}</td>
            <td>${l.sdt}</td>
            <td>${l.diaChi}</td>
            <td>${l.thanhPho}</td>
            <td>${l.quocGia}</td>
            <td>${l.matKhau}</td>

            <td>
                <a type="button" class="btn btn-primary"  href="/khach-hang/view-update?id=${l.id}">Update</a>
                <a  type="button" class="btn btn-danger" href="/khach-hang/delete?id=${l.id}">Delete</a>
                <a  type="button" class="btn btn-warning" href="/khach-hang/detail?id=${l.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="../layout/footer.jsp"%>

</body>
</html>
