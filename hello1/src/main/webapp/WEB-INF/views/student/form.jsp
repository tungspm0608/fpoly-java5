<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sinh viên</title>
</head>
<body>

<form action="/student/add" method="post">
    id: <input type="text" name="id" value="ID05"/>
    <br/>
    name: <input type="text" name="name" value="tung"/>
    <br/>
    age: <input type="text" name="age" value="20"/>
    <br/>
    address: <input type="text" name="address" value="quang ngai"/>
    <br/>
    gender:
    <input type="radio" name="gender" checked value="true"/>Nam
    <input type="radio" name="gender" value="false"/>Nữ
    <br/>
    <button type="submit">Add</button>
</form>
</body>
</html>
