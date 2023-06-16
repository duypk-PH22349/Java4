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

<form class="form-group" action="/cua-hang/hien-thi" method="post">
    <label>Mã</label>
    <input name="ma" placeholder="Mã" type="text" class="form-control">
    <label>Tên</label>
    <input name="ten" placeholder="Tên" type="text" class="form-control">
    <label>Địa Chỉ</label>
    <input name="diaChi" placeholder="Địa Chỉ" type="text" class="form-control">
    <label>Thành Phố</label>
    <input name="thanhPho" placeholder="Thành Phố" type="text" class="form-control">
    <label>Quốc Gia</label>
    <input name="quocGia" placeholder="Quốc Gia" type="text" class="form-control">
    <br>
<button class="btn btn-primary" type="submit">Thêm</button>

</form>
<table class="table">
    <thead>
    <tr>
        <td>Id</td>
        <td>Mã</td>
        <td>Tên</td>
        <td>Địa Chỉ</td>
        <td>Thành Phố</td>
        <td>Quốc Gia</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listHienThi}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.ma}</td>
            <td>${l.ten}</td>
            <td>${l.diaChi}</td>
            <td>${l.thanhPho}</td>
            <td>${l.quocGia}</td>

            <td>
                <a type="button" class="btn btn-primary"  href="/cua-hang/view-update?id=${l.id}">Update</a>
                <a type="button" class="btn btn-danger" href="/cua-hang/delete?id=${l.id}">Delete</a>
                <a type="button" class="btn btn-warning" href="/cua-hang/detail?id=${l.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="../layout/footer.jsp"%>

</body>
</html>
