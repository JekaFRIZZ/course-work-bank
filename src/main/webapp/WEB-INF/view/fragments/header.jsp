<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Solution</title>
    <link rel="stylesheet" href="/static/header.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<%--<nav class="navbar navbar-light bg-light">
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
</nav>--%>
<div class="header__wrapper">
    <a href="/bank-solution?command=show_main">Solution</a>
    <c:if test="${sessionScope.role == 'USER'}">
        <a href="/bank-solution?command=show_profile">Профиль</a>
    </c:if>
    <c:if test="${sessionScope.role == 'USER'}">
        <a href="/bank-solution?command=show_fill_user_data">FillUserData</a>
    </c:if>
    <c:if test="${sessionScope.role == 'USER'}">
        <a href="/bank-solution?command=show_deposit">deposit</a>
    </c:if>
    <c:if test="${sessionScope.role == 'ADMIN'}">
        <a href="/bank-solution?command=show_request_deposit">Show request</a>
    </c:if>
    <c:if test="${sessionScope.role == 'USER'}">
        <a href="/bank-solution?command=show_top_up_balance">Пополнить баланс</a>
    </c:if>
    <c:if test="${sessionScope.role == 'ADMIN'}">
        <a href="/bank-solution?command=show_clients">Список клиентов</a>
    </c:if>
    <a href="/bank-solution?command=logout">Выход</a>
</div>
</body>
</html>
