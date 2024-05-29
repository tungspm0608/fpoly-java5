<%@page language="java" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="p-2">
        <div class="row g-4">
            <div class="col-6">
                <h2>Sản phẩm đã chọn</h2>
                <table class="table">
                    <thead>
                    <%--        <td>ID</td>--%>
                    <td>IDSPCT</td>
                    <td>Số Lượng</td>
                    <td>Đơn Giá</td>
                    <td>Trạng Thái</td>
                    <td>Loại</td>
                    </thead>
                    <tbody>
                    <c:forEach items="${hdcts}" var="hdct">
                        <tr>
                                <%--                <td>${hdct.id}</td>--%>
                            <td>${hdct.idSPCT}</td>
                            <td colspan="1" class="d-flex justify-items-center align-items-center">
                                <form action="/ban-hang">
                                    <input name="soLuong" value="${hdct.soLuong - 1}" hidden>
                                    <input name="idsp" value="${hdct.idSPCT}" hidden>
                                    <button class="btn btn-outline-success">-</button>
                                </form>
                                <form>
                                    <input name="idsp" value="${hdct.idSPCT}" hidden>
                                    <input class="ms-2 me-2" name="soLuong" value="${hdct.soLuong}"
                                           onchange="this.form.submit()">
                                </form>
                                <form action="/ban-hang">
                                    <input name="soLuong" value="${hdct.soLuong + 1}" hidden>
                                    <input name="idsp" value="${hdct.idSPCT}" hidden>
                                    <button ${errSoLuong == null ? "" : "disabled"} class="btn btn-outline-success">+</button>
                                </form>
                                    ${errSoLuong}
                            </td>
                            <td>${hdct.donGia}</td>
                            <td>${hdct.trangThai == 1 ? "Đã Trả Tiền" : "Đơn Treo"}</td>
                            <td>
                                <form action="/ban-hang">
                                    <input name="soLuong" value="${0}" hidden>
                                    <input name="idsp" value="${hdct.idSPCT}" hidden>
                                    <button class="btn btn-danger">Loại</button>
                                </form>
                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-1"></div>
            <div class="col-5">
                <div class="d-flex mb-2">
                    <div class="me-1">Ngày mua hàng :</div>
                    <div><%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()) %></div>
                </div>

                <form class="d-flex pe-4 mb-2" action="/ban-hang/khach-hang" method="post">
                    <input value="${khachhang.sdt}" name="sdt" class="form-control me-2" type="search" placeholder="Số điện thoại" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                <div class="mb-2 d-flex">
                    <div>Tên khách hàng:</div>
                    <div class="text-info">${khachhang.ten}</div>
                </div>
                <c:if test="${khachhang.id == null}">
                    <a href="/khach-hang/create" class="mb-2 btn btn-secondary">Thêm mới khách hàng</a>
                </c:if>

                <div class="d-flex mb-2">
                    <div>Tổng số tiền cần thanh toán :</div>
                    <div>${tongtien}</div>
                </div>

                <form method="post" action="/ban-hang">
                    <button class="btn btn-success px-5 py-2 w-75">Xác nhận</button>
                </form>
            </div>
        </div>

        <form class="d-flex col-4" action="/ban-hang/search" method="post">
            <input id="search" value="${search}" name="search" class="form-control me-2" type="search" placeholder="Từ khoá Search" aria-label="Search">
            <button class="btn btn-outline-success me-3" type="submit">Search</button>
            ${search != "" ? "<button onclick=\"document.getElementById('search').value = '';this.form.submit()\" class='btn btn-outline-danger' type='button'>Back</button>" : ""}
        </form>

        <table class="table">
            <thead>
            <td>ID</td>
            <td>Sản phẩm</td>
            <td>Kích Thước</td>
            <td>Màu Sắc</td>
            <td>Tên Sản Phẩm</td>
            <td>Số Lượng</td>
            <td>Đơn Giá</td>
            <td>Trạng Thái</td>
            <td>Thêm</td>
            </thead>
            <tbody>
            <c:forEach items="${spcts}" var="spct">
                <tr>
                    <td>${spct.id}</td>
                    <c:forEach items="${sanphams}" var="sp">
                        <c:if test="${sp.ma eq spct.ma}">
                            <td>${sp.ten}</td>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${kichthuocs}" var="kt">
                        <c:if test="${spct.kt eq kt.ma}">
                            <td>${kt.ten}</td>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${mausacs}" var="ms">
                        <c:if test="${spct.ms eq ms.ma}">
                            <td>${ms.ten}</td>
                        </c:if>
                    </c:forEach>
                    <td>${spct.sp}</td>
                    <td>${spct.soLuong}</td>
                    <td>${spct.donGia}</td>
                    <td>${spct.trangThai == 1 ? "Còn hoạt động" : "Dừng hoạt động"}</td>
                    <td>
                        <form action="/ban-hang">
                            <input name="idsp" value="${spct.id}" hidden>
                            <button class="btn btn-primary"
                                ${spct.trangThai == 1 ? "" : "disabled"}
                                ${spct.soLuong > 0 ? "" : "disabled"}
                            >Thêm</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="d-flex justify-content-center align-items-center">
            <form method="post" action="/ban-hang/getPage">
                <input hidden name="currentPage" value="${currentPage-1}"/>
                <button class="btn btn-warning" ${currentPage - 1 <= 0 ? "disabled" : ""}>-</button>
            </form>
            <h3 class="ms-3 me-3">Trang : ${currentPage}</h3>
            <form method="post" action="/ban-hang/getPage">
                <input hidden name="currentPage" value="${currentPage+1}"/>
                <button class="btn btn-warning" ${currentPage >= lastPage ? "disabled" : ""}>+</button>
            </form>
        </div>
    </div>
</body>
</html>