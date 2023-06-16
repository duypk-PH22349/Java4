<%--
  Created by IntelliJ IDEA.
  User: PH22349
  Date: 26/03/2023
  Time: 6:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../layout/header.jsp"%>

<form class="form-group" action="/nhan-vien/hien-thi" method="post">
    <label>Mã</label>
    <input name="ma" placeholder="Mã" class="form-control">

    <label>Tên</label>
    <input name="ten" placeholder="Tên" class="form-control">

    <label>Tên Đệm</label>
    <input name="tenDem" placeholder="Tên Đệm" class="form-control">

    <label>Họ</label>
    <input name="ho" placeholder="Họ" class="form-control">

    <label>Giới Tính</label>
    <input name="gioiTinh" placeholder="Giới Tính" class="form-control">

    <label>Ngày Sinh</label>
    <input name="ngaySinh"  type="date" placeholder="Ngày Sinh" class="form-control">

    <label>Địa Chỉ</label>
    <input name="diaChi" placeholder="Địa Chỉ" class="form-control">

    <label>SĐT</label>
    <input name="sdt" placeholder="SĐT" class="form-control">

    <label>Mật Khẩu</label>
    <input name="matKhau" placeholder="Mật Khẩu" class="form-control">

    <label>Trạng Thái</label>
    <input name="trangThai" placeholder="Trạng Thái" class="form-control">
    <br>
    <button class="btn btn-primary" type="submit">Thêm</button>
</form>
<table class="table">
    <thead>
    <tr>
        <td>Id</td>
        <td>Mã</td>
        <td>Họ và Tên</td>
        <td>Giới Tính</td>
        <td>Ngày Sinh</td>
        <td>Địa Chỉ</td>
        <td>SĐT</td>
        <td>Mật Khẩu</td>
        <td>Trạng Thái</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listHienThi}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.ma}</td>
            <td>${l.ho} ${l.tenDem} ${l.ten}</td>
            <td>${l.gioiTinh}</td>
            <td>${l.ngaySinh}</td>
            <td>${l.diaChi}</td>
            <td>${l.sdt}</td>
            <td>${l.matKhau}</td>
            <td>${l.trangThai == 0?"Online":"Offline"}</td>

            <td>
                <a type="button" class="btn btn-primary" href="/nhan-vien/view-update?id=${l.id}">Update</a>
                <a type="button" class="btn btn-danger" href="/nhan-vien/delete?id=${l.id}">Delete</a>
                <a type="button" class="btn btn-warning" href="/nhan-vien/detail?id=${l.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="../layout/footer.jsp"%>


</body>
</html>
