<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Solution</title>
    <link rel="stylesheet" href="/static/header.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/main.css">
</head>
<body>
<jsp:include page="./fragments/header.jsp"></jsp:include>


<div class="gallery">
    <img alt="Butterfly"
         src="/image/main.jpg"/>
    <div class="block-overlay colored"></div>
    <div class="block-overlay">
    </div>

    <div class="text-block">
        <h1 class="try display-3">Solution</h1>
        <h4>Банк Solution рад приветствовать на своем сайте! Предлагаем ознакомиться с нашими услугами в разделах.</h4>
    </div>
</div>

<c:if test="${sessionScope.role == 'USER'}">
    <div class="contacts">
        <h2 class="text-center display-5">Неуверены с чего начать?</h2> <br>
        <p class="lead p-fix">Предлагаем посетить свой профиль и убедиться, что вся информация заполнена.</p>
        <br>

        <p class="lead p-fix">
            <a class="btn btn-secondary btn-lg p-fix" href="/bank-solution?command=show_fill_user_data" role="button">Посетить
                профиль</a>
        </p>
    </div>
</c:if>
<c:if test="${sessionScope.role == 'ADMIN'}">
    <div class="contacts">
        <h2 class="text-center display-5">Неуверены с чего начать?</h2> <br>
        <p class="lead p-fix">Предлагаем просмотреть список клиентов</p>
        <br>

        <p class="lead p-fix">
            <a class="btn btn-secondary btn-lg p-fix" href="/bank-solution?command=show_clients" role="button">Просмотреть список</a>
        </p>
    </div>
</c:if>

<%--<div class="gallery">
    <div class="image">
        <img src="/image/main.jpg">
    </div>
    <div class="text">
        <h1>Solution</h1>
        <p>Our bank offers</p>
    </div>
</div>--%>

<%--<img src="/image/main.jpg" height="690px" width="100%">--%>
</body>
</html>
