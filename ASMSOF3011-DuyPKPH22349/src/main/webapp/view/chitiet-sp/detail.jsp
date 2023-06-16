<%--
  Created by IntelliJ IDEA.
  User: PH22349
  Date: 28/03/2023
  Time: 3:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
           rel="stylesheet"
           integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
           crossorigin="anonymous">
</head>
<body>
<form class="form-group" method="post" action="/chitiet-sp/detail">

<%--    <label>IdNsx</label>--%>
<%--    <input name="idNsx" placeholder="IdNsx" class="form-control" value="${chiTietSP.idNsx}" >--%>

<%--    <label>IdSP </label>--%>
<%--    <input name="idSp" placeholder="ID" class="form-control" value="${chiTietSP.idSp.ma}">--%>

<%--    <label>IdMauSac</label>--%>
<%--    <input name="idMs" placeholder="ID" class="form-control" value="${chiTietSP.idMs.ma}">--%>

<%--    <label>IdDongSp</label>--%>
<%--    <input name="idDongSp" placeholder="IdDongSp" class="form-control" value="${chiTietSP.idDongSp.ma}">--%>

    <label>Năm Sx</label>
    <input name="namSX" placeholder="Năm Sx" class="form-control" value="${chiTietSP.namSX}">

    <label>Mô tả</label>
    <input name="moTa" placeholder="Mô tả" class="form-control" value="${chiTietSP.moTa}">

    <label>Số lượng tồn </label>
    <input name="soLuongTon" placeholder="Số lượng tồn " class="form-control" value="${chiTietSP.soLuongTon}">

    <label>Giá nhập </label>
    <input name="giaNhap" placeholder="Giá nhập" class="form-control" value="${chiTietSP.giaNhap}">

    <label>Giá bán </label>
    <input name="giaBan" placeholder="Giá bán" class="form-control" value="${chiTietSP.giaBan}">
    <br>
    <a class="btn btn-primary" href="/chitiet-sp/hien-thi" type="button"> Quay lại</a>

</form>

</body>
</html>
