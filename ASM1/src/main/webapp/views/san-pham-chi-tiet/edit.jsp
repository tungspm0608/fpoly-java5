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
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>
<div class="container mt-5 pt-5">
    <h1 class="text-center">Sửa Sản Phẩm Chi Tiết</h1>
    <form action="/san-pham-chi-tiet/update/${data.id}" method="post">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInputMa" name="ma" value="${data.ma}">
            <label for="floatingInputMa">Mã</label>
            <c:if test="${not empty errors['ma']}">
                <small style="color: red">${errors['ma']}</small>
            </c:if>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInputKt" name="kt" value="${data.kt}">
            <label for="floatingInputKt">Kích Thước</label>
            <c:if test="${not empty errors['kt']}">
                <small style="color: red">${errors['kt']}</small>
            </c:if>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInputMs" name="ms" value="${data.ms}">
            <label for="floatingInputMs">Màu Sắc</label>
            <c:if test="${not empty errors['ms']}">
                <small style="color: red">${errors['ms']}</small>
            </c:if>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInputSp" name="sp" value="${data.sp}">
            <label for="floatingInputSp">Sản Phẩm</label>
            <c:if test="${not empty errors['sp']}">
                <small style="color: red">${errors['sp']}</small>
            </c:if>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInputSoLuong" name="soLuong" value="${data.soLuong}">
            <label for="floatingInputSoLuong">Số Lượng</label>
            <c:if test="${not empty errors['soLuong']}">
                <small style="color: red">${errors['soLuong']}</small>
            </c:if>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInputDonGia" name="donGia" value="${data.donGia}">
            <label for="floatingInputDonGia">Đơn Giá</label>
            <c:if test="${not empty errors['donGia']}">
                <small style="color: red">${errors['donGia']}</small>
            </c:if>
        </div>

        <div class="form-floating mb-3">
            <select class="form-select" id="floatingSelectTrangThai" aria-label="Floating label select example" name="trangThai">
                <option value="" ${data.trangThai == null ? "selected" : ""}>Hãy Chọn Trạng Thái</option>
                <option value="0" ${data.trangThai == 0 ? "selected" : ""}>Hết Hàng</option>
                <option value="1" ${data.trangThai == 1 ? "selected" : ""}>Còn Hàng</option>
            </select>
            <label for="floatingSelectTrangThai">Trạng Thái</label>
            <c:if test="${not empty errors['trangThai']}">
                <small style="color: red">${errors['trangThai']}</small>
            </c:if>
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-success">Sửa Sản Phẩm</button>
            <a href="/san-pham-chi-tiet/index"><button type="button" class="btn btn-light">Back</button></a>
        </div>
    </form>
</div>
</body>
</html>