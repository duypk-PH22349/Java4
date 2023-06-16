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

<form class="form-group" method="post" action="/chitiet-sp/hien-thi">

<%--    <label>IdNsx</label>--%>
<%--    <input name="idNsx" placeholder="IdNsx" class="form-control">--%>

<%--    <label>IdSP </label>--%>
<%--    <input name="idSp" placeholder="ID" class="form-control">--%>

<%--    <label>IdMauSac</label>--%>
<%--    <input name="idMs" placeholder="ID" class="form-control">--%>

<%--    <label>IdDongSp</label>--%>
<%--    <input name="idDongSp" placeholder="IdDongSp" class="form-control">--%>

    <label>Năm SX</label>
    <input name="namSX" placeholder="Năm Sx" class="form-control">

    <label>Mô tả</label>
    <input name="moTa" placeholder="Mô tả" class="form-control">

    <label>Số lượng tồn </label>
    <input name="soLuongTon" placeholder="Số lượng tồn " class="form-control">

    <label>Giá nhập </label>
    <input name="giaNhap" placeholder="Giá nhập" class="form-control">

    <label>Giá bán </label>
    <input name="giaBan" placeholder="Giá bán" class="form-control">
    <br>
    <button class="btn btn-primary" type="submit">Thêm</button>

</form>

<table class="table">
    <thead>
    <tr>
        <td>Id</td>
        <td>Năm Sx</td>
        <td>Mô tả</td>
        <td>Số lượng tồn</td>
        <td>Giá Nhập</td>
        <td>Giá Bán</td>
        <td>Action</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listHienThi}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.namSX}</td>
            <td>${l.moTa}</td>
            <td>${l.soLuongTon}</td>
            <td>${l.giaNhap}</td>
            <td>${l.giaBan}</td>
            <td>
                <a  type="button" class="btn btn-primary" href="/chitiet-sp/view-update?id=${l.id}">Update</a>
                <a type="button" class="btn btn-danger" href="/chitiet-sp/delete?id=${l.id}">Delete</a>
                <a type="button" class="btn btn-warning" href="/chitiet-sp/detail?id=${l.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@include file="../layout/footer.jsp"%>


</body>
</html>
