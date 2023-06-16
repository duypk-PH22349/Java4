<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="view/layout/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div>
    <div class="background-image">
        <br>
        <div class="container">
            <header class="d-flex justify-content-center py-3">
                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="/" class="nav-link active" aria-current="page">Home</a></li>
                    <li class="nav-item"><a href="/chuc-vu/hien-thi" class="nav-link">Chức vụ</a></li>
                    <li class="nav-item"><a href="/chitiet-sp/hien-thi" class="nav-link">Chi tiết sản phẩm</a></li>
                    <li class="nav-item"><a href="/cua-hang/hien-thi" class="nav-link">Cửa hàng</a></li>
                    <li class="nav-item"><a href="/dong-sp/hien-thi" class="nav-link">Dòng sản phẩm</a></li>
                    <li class="nav-item"><a href="/khach-hang/hien-thi" class="nav-link">Khách hàng</a></li>
                    <li class="nav-item"><a href="/mau-sac/hien-thi" class="nav-link">Màu sắc</a></li>
                    <li class="nav-item"><a href="/nhan-vien/hien-thi" class="nav-link">Nhân viên</a></li>
                    <li class="nav-item"><a href="/nsx/hien-thi" class="nav-link">Nhà sản xuất</a></li>
                    <li class="nav-item"><a href="/san-pham/hien-thi" class="nav-link">Sản phẩm</a></li>
                </ul>
            </header>
        </div>

        <section class="section section-top section-full">
            <div class="bg-cover" style="background-image: url(/view/layout/background.jpg);"></div>
            <div class="bg-overlay"></div>
            <div class="bg-triangle bg-triangle-light bg-triangle-bottom bg-triangle-left"></div>
            <div class="bg-triangle bg-triangle-light bg-triangle-bottom bg-triangle-right"></div>
            <div class="container">
                <div class="row justify-content-center align-items-center">
                    <div class="col-md-8 col-lg-7">

                        <p class="font-weight-medium text-center text-xs text-uppercase text-white text-muted animate"
                           data-toggle="animation" data-animation="fadeUp" data-animation-order="0"
                           data-animation-trigger="load">
                            ASM JAVA4
                        </p>

                        <h1 class="text-white text-center mb-4 animate" data-toggle="animation" data-animation="fadeUp"
                            data-animation-order="1" data-animation-trigger="load">
                            <a style="color: black">Cửa Hàng</a>
                        </h1>

                        <p class="lead text-white text-muted text-center mb-5 animate" data-toggle="animation"
                           data-animation="fadeUp" data-animation-order="2" data-animation-trigger="load"
                           style="color: black">
                            Họ và tên: Phạm Khương Duy
                            MSSV: PH22349
                        </p>

                        <p class="text-center mb-0 animate" data-toggle="animation" data-animation="fadeUp"
                           data-animation-order="3" data-animation-trigger="load">
                            <a href="https://www.facebook.com/duy.k.pham.3597" target="_blank"
                               class="btn btn-outline-primary text-white" style="color: black">
                                Facebook
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </section>


        <section class="section" id="pages">

            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-8 col-lg-6">
                        <h2 class="text-center mb-4">
                            PHẠM KHƯƠNG DUY
                        </h2>
                        <p class="text-muted text-center mb-5">
                            PH22349
                        </p>
                    </div>
                </div>


                <div class="row g-4 py-5 row-cols-1 row-cols-lg-3" style="text-align: center">
                    <div class="feature col">
                        <a href="/san-pham/hien-thi" class="card border-0 mb-3 mb-md-0" style="text-decoration: none">
                            <img src="/view/layout/img/sanpham.jpg" alt="Sản Phẩm" height="250px" width="300px">
                            <div class="card-body">
                                <h4 class="card-title">
                                    Sản Phẩm
                                </h4>
                                <p class="card-text text-muted">
                                    Các sản phẩm của cửa hàng
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="feature col">
                        <a href="/chitiet-sp/hien-thi" class="card border-0 mb-3 mb-md-0" style="text-decoration: none">
                            <img src="/view/layout/img/chiTietSp.jpg" alt="Chi Tiết Sản Phẩm" height="250px"
                                 width="300px">
                            <div class="card-body">
                                <h4 class="card-title">
                                    Chi Tiết Sản Phẩm
                                </h4>
                                <p class="card-text text-muted">
                                    Chi tiết sp của cửa hàng
                                </p>
                            </div>

                        </a>
                    </div>

                    <div class="feature col">
                        <a href="/chuc-vu/hien-thi" class="card border-0 mb-3 mb-md-0" style="text-decoration: none">
                            <img src="/view/layout/img/chucVu.jpg" alt="Chức Vụ" height="250px" width="300px">
                            <div class="card-body">
                                <h4 class="card-title">
                                    Chức Vụ
                                </h4>
                                <p class="card-text text-muted">
                                    Các chức vụ của cửa hàng
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="feature col">
                        <a href="cua-hang/hien-thi" class="card border-0 mb-3 mb-md-0" style="text-decoration: none">
                            <div class="card-img-top">
                                <img src="/view/layout/img/cuaHang.jpg" alt="Cửa Hàng" height="250px" width="300px">
                            </div>
                            <div class="card-body">
                                <h4 class="card-title">
                                    Cửa Hàng
                                </h4>
                                <p class="card-text text-muted">
                                    Các cửa hàng
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="feature col">
                        <a href="/dong-sp/hien-thi" class="card border-0 mb-3 mb-md-0" style="text-decoration: none">
                            <div class="card-img-top">
                                <img src="/view/layout/img/dongSp.jpg" alt="Dòng Sản Phẩm" height="250px" width="300px">
                            </div>
                            <div class="card-body">
                                <h4 class="card-title">
                                    Dòng Sản Phẩm
                                </h4>
                                <p class="card-text text-muted">
                                    Dòng Sản Phẩm của cửa hàng
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="feature col">
                        <a href="/khach-hang/hien-thi" class="card border-0 mb-3 mb-md-0" style="text-decoration: none">
                            <div class="card-img-top">
                                <img src="/view/layout/img/khachHang.jpg" alt="Khách Hàng" height="250px" width="300px">
                            </div>
                            <div class="card-body">
                                <h4 class="card-title">
                                    Khách Hàng
                                </h4>
                                <p class="card-text text-muted">
                                    Khách hàng của cửa hàng
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="feature col">
                        <a href="/mau-sac/hien-thi" class="card border-0 mb-3 mb-md-0" style="text-decoration: none">
                            <div class="card-img-top">
                                <img src="/view/layout/img/mauSac.jpg" alt="Màu Sắc" height="250px" width="300px">
                            </div>
                            <div class="card-body">
                                <h4 class="card-title">
                                    Màu Sắc
                                </h4>
                                <p class="card-text text-muted">
                                    Màu Sắc của cửa hàng
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="feature col">
                        <a href="/nhan-vien/hien-thi" class="card border-0 mb-3 mb-md-0" style="text-decoration: none">
                            <div class="card-img-top">
                                <img src="/view/layout/img/nhanVien.jpg" alt="Nhân Viên" height="250px" width="300px">
                            </div>
                            <div class="card-body">
                                <h4 class="card-title">
                                    Nhân Viên
                                </h4>
                                <p class="card-text text-muted">
                                    Nhân Viên của cửa hàng
                                </p>
                            </div>
                        </a>
                    </div>

                    <div class="feature col">
                        <a href="/nsx/hien-thi" class="card border-0 mb-3 mb-md-0" style="text-decoration: none">
                            <div class="card-img-top">
                                <img src="/view/layout/img/nsx.jpg" alt="NSX" height="250px" width="300px">
                            </div>
                            <div class="card-body">
                                <h4 class="card-title">
                                    Nhà Sản Xuất
                                </h4>
                                <p class="card-text text-muted">
                                    Nhà sản xuất của cửa hàng
                                </p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </section>

        <div class="container">
            <footer class="py-3 my-4">
                <ul class="nav justify-content-center border-bottom pb-3 mb-3">
                    <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Home</a></li>
                    <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Features</a></li>
                    <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Pricing</a></li>
                    <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">FAQs</a></li>
                    <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">About</a></li>
                </ul>
                <p class="text-center text-body-secondary">© 2023 Company, Inc</p>
            </footer>
        </div>
    </div>
</div>
</body>
</html>