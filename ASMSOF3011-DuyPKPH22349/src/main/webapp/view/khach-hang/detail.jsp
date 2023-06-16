<%--
  Created by IntelliJ IDEA.
  User: PH22349
  Date: 27/03/2023
  Time: 7:45 CH
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
<form class="form-group" action="/khach-hang/detail" method="get">
    <label>Ma</label>
    <input name="ma" class="form-control" type="text" value="${khachHang.ma}">
    <label>Tên</label>
    <input name="ten" class="form-control" type="text" value="${khachHang.ten}">
    <label>Tên Đệm</label>
    <input name="tenDem" class="form-control"  type="text" value="${khachHang.tenDem}">
    <label>Họ</label>
    <input name="ho" class="form-control" type="text" value="${khachHang.ho}">
    <label>Ngày Sinh</label>
    <input name="ngaySinh" type="date"  class="form-control" value="${ngaySinh}">
    <label>SĐT</label>
    <input name="sdt"  class="form-control" type="text" value="${khachHang.sdt}">
    <label>Địa Chỉ</label>
    <input name="diaChi"  class="form-control" type="text" value="${khachHang.diaChi}">
    <label>Thành Phố</label>
    <input name="thanhPho"  class="form-control" type="text"value="${khachHang.thanhPho}" >
    <label>Quốc Gia</label>
    <input name="quocGia"  class="form-control" type="text" value="${khachHang.quocGia}">
    <label>Mật Khẩu</label>
    <input name="matKhau"  class="form-control"  type="text" value="${khachHang.matKhau}">
    <br>
    <a class="btn btn-primary" href="/khach-hang/hien-thi" type="button"> Quay lại</a>

</form>
</body>
</html>
