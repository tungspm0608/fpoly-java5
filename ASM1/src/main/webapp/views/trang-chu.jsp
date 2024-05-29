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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container p-3">
        <h1 class="text-center">Trang chủ</h1>
        <div class="row g-2 row-cols-2">
            <div class="col"><a class="btn btn-outline-success w-100" href="/hoa-don/index">Quản lý hoá đơn</a><br></div>
            <div class="col"><a class="btn btn-outline-success w-100" href="/hoa-don-chi-tiet/index">Quản lý hoá đơn chi tiết</a><br></div>
            <div class="col"><a class="btn btn-outline-success w-100" href="/khach-hang/index">Quản lý khách hàng</a><br></div>
            <div class="col"><a class="btn btn-outline-success w-100" href="/kich-thuoc/index">Quản lý kích thước</a><br></div>
            <div class="col"><a class="btn btn-outline-success w-100" href="/mau-sac/index">Quản lý màu sắc</a><br></div>
            <div class="col"><a class="btn btn-outline-success w-100" href="/nhan-vien/index">Quản lý nhân viên</a><br></div>
            <div class="col"><a class="btn btn-outline-success w-100" href="/san-pham/index/2">Quản lý sản phẩm</a><br></div>
            <div class="col"><a class="btn btn-outline-success w-100" href="/san-pham-chi-tiet/index">Quản lý sản phẩm chi tiết</a><br></div>
        </div>
    </div>
</body>
</html>