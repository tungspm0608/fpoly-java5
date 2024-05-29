<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    ${message}
    <form:form action="/staff/form" method="post" modelAttribute="staff">
        Ten:<form:input path="name"/><br>
        <form:errors path="name" /><br>
        Tuoi:<form:input path="age"/><br>
        <form:errors path="age" /><br>
        Dia chi:<form:input path="address"/><br>
        <form:errors path="address" /><br>
        Vi tri:<form:radiobuttons path="position" items="${positions}" delimiter=" "/><br>
        <form:errors path="position" /><br>
        So thich:<form:checkboxes path="hobbies" items="${hobbies}" delimiter=" "/><br>
        <form:errors path="hobbies" /><br>
        Quoc gia:<form:select path="country.id">
            <option disabled value selected>Chon qg</option>
            <form:options items="${countries}" itemValue="id" itemLabel="name"/>
        </form:select><br>
        <form:errors path="country" /><br>
        <button type="submit">Save</button>
    </form:form>
</body>
</html>