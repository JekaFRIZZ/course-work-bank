<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solution</title>
    <link rel="stylesheet" href="/static/registration.css">
</head>
<body>
<div class="form__wrapper">
    <form action="/bank-solution">
        <div class="from__label">Registration</div>
        <input type="hidden" name="command" value="registration">
        <input type="text" name="login" placeholder="Enter login">
        <input type="password" name="password" placeholder="Enter password">
        <input type="password" name="passwordConfirm" placeholder="Confirm password">
        <button type="submit">Registration</button>
    </form>
    <a href="/bank-solution?command=show_login">login</a>
</div>
</body>
</html>
