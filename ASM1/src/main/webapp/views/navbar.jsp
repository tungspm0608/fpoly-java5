<%@ page import="com.example.demo.entity.NhanVien" %>
<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<div>
    <% NhanVien nhanvien=(NhanVien) request.getSession().getAttribute("nhanvien"); %>
    <nav class="navbar bg-body-tertiary navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="/trang-chu">Quần Áo Ò Ó O</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Mục lục</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <!-- Các mục điều hướng bên trái -->
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/ban-hang">Bán Hàng</a>
                        </li>
                        <li class="nav-item dropdown">
                            <button class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Mục lục
                            </button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/hoa-don/index">Hoa Don</a></li>
                                <li><a class="dropdown-item" href="/hoa-don-chi-tiet/index">Hoa Don Chi Tiet</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="/khach-hang/index">Khach Hang</a></li>
                                <li><a class="dropdown-item" href="/nhan-vien/index">Nhan Vien</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="/san-pham/index/2">San Pham</a></li>
                                <li><a class="dropdown-item" href="/san-pham-chi-tiet/index">San Pham Chi Tiet</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- Thêm form tìm kiếm và nút Đăng nhập -->
                    <ul class="navbar-nav">
                        <c:if test="<%=nhanvien != null%>">
                            <li class="nav-item d-flex align-items-center">
                                <h5 class="me-2">Xin chào, <%=nhanvien.getTen() %></h5>
                                <h5>Chức vụ : <%=nhanvien.getTrangThai() == 1 ? "Admin" : "Nhân viên" %></h5>
                                <a class="btn btn-primary ms-4" href="/dang-xuat">Đăng xuất</a>
                            </li>
                        </c:if>
                        <c:if test="<%=nhanvien == null%>">
                            <li class="nav-item">
                                <a class="btn btn-primary" href="#">Đăng nhập</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>
</body>
</html>