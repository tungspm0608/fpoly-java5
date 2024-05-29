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
    <h1 class="text-center">Sửa Hóa Đơn</h1>
    <form action="/hoa-don/update" method="post">
        <input type="hidden" name="id" value="${data.id}">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="" value="${data.idNv}" >
            <label for="floatingInput">IDNV</label>
            <input type="hidden" name="idNv" value="${data.idNv}">
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInput" value="${data.idKh}" >
            <label for="floatingInput">IDKH</label>
            <input type="hidden" name="idKh" value="${data.idKh}">
        </div>
        <div class="form-floating mb-3">
            <input type="date" class="form-control" id="floatingInput1" name="ngayMuaHang" value="${data.ngayMuaHang}">
            <label for="floatingInput1">Ngày Mua Hàng</label>
            <c:if test="${not empty errors['ngayMuaHang']}">
                <small style="color: red">${errors['ngayMuaHang']}</small>
            </c:if>
        </div>
        <div class="form-floating mb-3">
            <select class="form-select" id="floatingSelect" aria-label="Floating label select example" name="trangThai" value="${data.trangThai}">
                <option value="0" ${data.trangThai == 0? "selected" : ""}>Đơn Treo</option>
                <option value="1" ${data.trangThai == 1? "selected" : ""}>Đã Trả Tiền</option>
            </select>
            <c:if test="${not empty errors['trangThai']}">
                <small style="color: red">${errors['trangThai']}</small>
            </c:if>
            <label for="floatingSelect">Trạng Thái</label>
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-success">Sửa Sản Phẩm</button>
            <a href="/hoa-don/index"><button type="button" class="btn btn-light">Back</button></a>
        </div>
    </form>
</div>
</body>
</html>