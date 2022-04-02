<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Solution</title>
    <link rel="stylesheet" href="static/index.css">
</head>
<body>
<div class="form__wrapper">
    <form action="/bank-solution" method="post">
        <div class="from__label">
            Login
        </div>
        <input type="hidden" name="command" value="login">
        <input type="text" name="login" placeholder="Enter login">
        <input type="password" name="password" placeholder="Enter password">

        <button type="submit">send</button>
    </form>
    <div class="error">
        <c:if test="${incorrectPasswordOrLogin != null}">
            ${requestScope.incorrectPasswordOrLogin}
        </c:if>
    </div>
    <a href="/bank-solution?command=show_registration">registration</a>
</div>
</body>
</html>
