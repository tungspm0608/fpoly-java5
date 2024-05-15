
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết sinh viên</title>
</head>
<body>
    id:
    <br/>
    ${student.id}
    <br/>
    name:
    <br/>
    ${student.name}
    <br/>
    age:
    <br/>
    ${student.age}
    <br/>
    address:
    <br/>
    ${student.address}
    <br/>
    gender:
    <br/>
    ${student.gender ? "Male" : "Female"}
</body>
</html>
