<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Solution</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/header.css">
    <style>
        .navbar-nav {
            flex-direction: row;
            justify-content: space-around;
            width: 100%;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/bank-solution?command=show_main">Главная</a>
        </li>
        <c:if test="${sessionScope.role == 'USER'}">
            <li class="nav-item">
                <a class="nav-link" href="/bank-solution?command=show_profile">Профиль</a>
            </li>
        </c:if>
        <c:if test="${sessionScope.role == 'USER'}">
            <li class="nav-item">
                <a class="nav-link" href="/bank-solution?command=show_fill_user_data">Аккаунт</a>
            </li>
        </c:if>
        <c:if test="${sessionScope.role == 'USER'}">
            <li class="nav-item">
                <a class="nav-link" href="/bank-solution?command=show_deposit">Депозиты</a>
            </li>
        </c:if>
        <c:if test="${sessionScope.role == 'ADMIN'}">
            <li class="nav-item">
                <a class="nav-link" href="/bank-solution?command=show_request_deposit">Запросы</a>
            </li>
        </c:if>
        <c:if test="${sessionScope.role == 'USER'}">
            <li class="nav-item">
                <a class="nav-link" href="/bank-solution?command=show_top_up_balance">Пополнить баланс</a>
            </li>
        </c:if>
        <c:if test="${sessionScope.role == 'ADMIN'}">
            <li class="nav-item">
                <a class="nav-link" href="/bank-solution?command=show_clients">Клиенты</a>
            </li>
        </c:if>
        <li class="nav-item">
            <a class="nav-link" href="/bank-solution?command=logout">Выход</a>
        </li>
    </ul>
</nav>

</body>
</html>
