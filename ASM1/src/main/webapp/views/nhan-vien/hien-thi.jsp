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
<jsp:include page="../navbar.jsp"></jsp:include>
<div class="container mt-5 pt-5">
    <h1 class="text-center">Quản Lý Nhân Viên</h1>
    <div class="row mt-2 mb-2">
        <div class="col-8">
            <a href="/nhan-vien/create"><button type="button" class="btn btn-primary">Thêm</button></a>
        </div>
        <form class="d-flex col-4">
            <input value="${search}" name="search" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
    <table class="table">
        <thead>
        <td>ID</td>
        <td>Mã Nhân Viên</td>
        <td>Tên Nhân Viên</td>
        <td>Tên Đăng Nhập</td>
        <td>Mật Khẩu</td>
        <td>Trạng Thái</td>
        <td>Hành Động</td>
        </thead>
        <tbody>
        <c:forEach items="${data}" var="sp">
            <tr>
                <td>${sp.id}</td>
                <td>${sp.maNv}</td>
                <td>${sp.ten}</td>
                <td>${sp.tenDangNhap}</td>
                <td>${sp.matKhau}</td>
                <td>${sp.trangThai == 0 ? "Nhân Viên" : "ADMIN"}</td>
                <td>
                    <a href="/nhan-vien/edit/${sp.id}"><button type="button" class="btn btn-info">Sửa</button></a>
                    <a href="/nhan-vien/delete/${sp.id}"><button type="button" class="btn btn-danger">Xóa</button></a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

    <div class="d-flex justify-content-center align-items-center">
        <form>
            <input name="search" value="${search}" hidden>
            <input hidden name="currentPage" value="${currentPage-1}"/>
            <button class="btn btn-warning" ${currentPage - 1 <= 0 ? "disabled" : ""}>-</button>
        </form>
        <h3 class="ms-3 me-3">Page : ${currentPage}</h3>
        <form>
            <input name="search" value="${search}" hidden>
            <input hidden name="currentPage" value="${currentPage+1}"/>
            <button class="btn btn-warning" ${currentPage >= lastPage ? "disabled" : ""}>+</button>
        </form>
    </div>
</div>
</body>
</html>