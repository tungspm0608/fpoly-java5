<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<table>
    <form action="/student/detail" method="post">
        MSSV: <input name="id"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="/student/add">Add Student</a></button>
    <tr>
        <th>STT</th>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>address</th>
        <th>gender</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <c:forEach var="s" items="${student}" varStatus="i">
    <tbody>
        <td>${i.index + 1}</td>
        <td>${s.id}</td>
        <td>${s.name}</td>
        <td>${s.age}</td>
        <td>${s.address}</td>
        <td>${s.gender ? "Male" : "Female"}</td>
        <td>
            <button onclick="location.href='student/update?id=${s.id}'">Sua</button>
            <button onclick="location.href='student/delete?id=${s.id}'">Xoa</button>
        </td>
    </tbody>
    </c:forEach>
</table>
</body>
</html>
