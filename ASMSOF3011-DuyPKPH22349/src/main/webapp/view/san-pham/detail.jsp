<%--
  Created by IntelliJ IDEA.
  User: PH22349
  Date: 28/03/2023
  Time: 3:00 CH
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
<form class="form-group" action="/mau-sac/detail" method="get">

    <label>Mã</label>
    <input name="ma" placeholder="Mã" class="form-control" value="${sanPham.ma}">
    <label>Tên</label>
    <input name="ten" placeholder="Tên" class="form-control" value="${sanPham.ten}">
    <br>
    <a class="btn btn-primary" href="/san-pham/hien-thi" type="button"> Quay lại</a>

</form>

</body>
</html>
