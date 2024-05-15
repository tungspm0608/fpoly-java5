<html>
<head>
    <title>Sửa thông tin</title>
</head>
<body>

<form action="/student/update" method="post">
    id: <input type="text" name="id" value="${student.id}" readonly/>
    <br/>
    name: <input type="text" name="name" value="${student.name}"/>
    <br/>
    age: <input type="text" name="age" value="${student.age}"/>
    <br/>
    address: <input type="text" name="address" value="${student.address}"/>
    <br/>
    gender:
    <input type="radio" name="gender" value="true" ${student.gender ? "checked" : ""}/>Male
    <input type="radio" name="gender" value="false" ${!student.gender ? "checked" : ""}/>Female
    <br/>
    <button>Update</button>
</form>

</body>
</html>
