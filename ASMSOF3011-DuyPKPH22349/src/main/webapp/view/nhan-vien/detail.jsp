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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form class="form-group" action="nhan-vien/update?id=${nhanVien.id}" method="get">
    <label>Mã</label>
    <input name="ma" placeholder="Mã" class="form-control" value="${nhanVien.ma}">

    <label>Tên</label>
    <input name="ten" placeholder="Tên" class="form-control" value="${nhanVien.ten}">

    <label>Tên Đệm</label>
    <input name="tenDem" placeholder="Tên Đệm" class="form-control" value="${nhanVien.tenDem}">

    <label>Họ</label>
    <input name="ho" placeholder="Họ" class="form-control" value="${nhanVien.ho}">

    <label>Giới Tính</label>
    <input name="gioiTinh" placeholder="Giới Tính" class="form-control" value="${nhanVien.gioiTinh}">

    <label>Ngày Sinh</label>
    <input name="ngaySinh"  type="date" placeholder="Ngày Sinh" class="form-control" value="${ngaySinh}">

    <label>Địa Chỉ</label>
    <input name="diaChi" placeholder="Địa Chỉ" class="form-control" value="${nhanVien.diaChi}">

    <label>SĐT</label>
    <input name="sdt" placeholder="SĐT" class="form-control" value="${nhanVien.sdt}">

    <label>Mật Khẩu</label>
    <input name="matKhau" placeholder="Mật Khẩu" class="form-control" value="${nhanVien.matKhau}">

    <%--    <label>IdCH</label>--%>
    <%--    <label>IdCV</label>--%>
    <label>Trạng Thái</label>
    <input name="trangThai" placeholder="Trạng Thái" class="form-control" value="${nhanVien.trangThai}">
    <br>
    <a class="btn btn-primary" href="/nhan-vien/hien-thi" type="button"> Quay lại</a>

</form>

</body>
</html>
