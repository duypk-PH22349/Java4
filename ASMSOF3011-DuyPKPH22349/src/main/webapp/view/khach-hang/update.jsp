<%--
  Created by IntelliJ IDEA.
  User: PH22349
  Date: 28/03/2023
  Time: 10:43 CH
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
<form class="form-group" action="/khach-hang/update?id=${khachHang.id}" method="post">
    <label>Ma</label>
    <input name="ma" placeholder="Mã" class="form-control" type="text" value="${khachHang.ma}">
    <label>Tên</label>
    <input name="ten" placeholder="Tên" class="form-control" type="text" value="${khachHang.ten}">
    <label>Tên Đệm</label>
    <input name="tenDem" placeholder="Tên Đệm" class="form-control"  type="text" value="${khachHang.tenDem}">
    <label>Họ</label>
    <input name="ho" placeholder="Họ" class="form-control" type="text" value="${khachHang.ho}">
    <label>Ngày Sinh</label>
    <input name="ngaySinh" type="date" placeholder="Ngày Sinh" class="form-control" value="${ngaySinh}">
    <label>SĐT</label>
    <input name="sdt" placeholder="SĐT" class="form-control" type="text" value="${khachHang.sdt}">
    <label>Địa Chỉ</label>
    <input name="diaChi" placeholder="Địa Chỉ" class="form-control" type="text" value="${khachHang.diaChi}">
    <label>Thành Phố</label>
    <input name="thanhPho" placeholder="Thành Phố" class="form-control" type="text"value="${khachHang.thanhPho}" >
    <label>Quốc Gia</label>
    <input name="quocGia" placeholder="Quốc Gia" class="form-control" type="text" value="${khachHang.quocGia}">
    <label>Mật Khẩu</label>
    <input name="matKhau" placeholder="Mật Khẩu" class="form-control"  type="text" value="${khachHang.matKhau}">
    <br>
    <button  type="button" class="btn btn-primary" type="submit">Update</button>
</form>

</body>
</html>
