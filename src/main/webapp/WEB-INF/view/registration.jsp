<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/bank-solution">
    <input type="hidden" name="command" value="registration">
    <input type="text" name="login" placeholder="Enter login">
    <input type="password" name="password" placeholder="Enter password">
    <input type="password" name="passwordConfirm" placeholder="Confirm password">
    <button type="submit">Registration</button>
</form>
</body>
</html>
