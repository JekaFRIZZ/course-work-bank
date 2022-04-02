<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Solution</title>
    <link rel="stylesheet" href="/static/registration.css">
</head>
<body>
<div class="form__wrapper">
    <form action="/bank-solution" method="post">
        <div class="from__label">Registration</div>
        <input type="hidden" name="command" value="registration">
        <input type="text" name="login" placeholder="Enter login">
        <input type="password" name="password" placeholder="Enter password">
        <input type="password" name="passwordConfirm" placeholder="Confirm password">
        <button type="submit">Registration</button>
    </form>
    <div class="error">
        <c:if test="${notUniqueUser != null}">
            ${requestScope.notUniqueUser}
        </c:if>
    </div>
    <div class="error">
        <c:if test="${passwordNotEquals != null}">
            ${requestScope.passwordNotEquals}
        </c:if>
    </div>
    <a href="/bank-solution?command=show_login">login</a>
</div>
</body>
</html>
