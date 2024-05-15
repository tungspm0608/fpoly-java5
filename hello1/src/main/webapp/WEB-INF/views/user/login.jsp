<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="vn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>Đăng kí</h1>
    <p>${err}</p>
    <form action="/user/login" method="POST">
        <p>Tên</p>
        <input type="text" name="name">
        <p>Tuổi</p>
        <input type="text" name="age">
        <p>Địa chỉ</p>
        <input type="text" name="address">
        <br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>