<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Solution</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/multipurpose.css">
</head>
<body>
<jsp:include page="./fragments/header.jsp"></jsp:include>

<div class="heading__wrapper">
    <h1>Заявка на депозит</h1>
</div>

<div class="card__wrapper my-3">
    <div class="card">
        <div class="card-body">
            Зарплата : <c:out value="${userData.salary}"/>
            <br>День рождение : <c:out value="${userData.birthday}"/>
            <br>Имя : <c:out value="${userData.name}"/>
            <br>Фамилия : <c:out value="${userData.surname}"/>
            <br>Отчество : <c:out value="${userData.patronymic}"/>
            <%--<br>Home phone : <c:out value="${phone.homePhone}"/>--%>
            <br>Мобильный телефон : <c:out value="${phone.mobilePhone}"/>
            <br>Название депозита : <c:out value="${deposit_type.name}"/>
            <form action="bank-solution">
                <input type="hidden" name="command" value="approved_deposit">
                <input type="hidden" name="result_approved_deposit" value="false">
                <input type="hidden" name="deposit_type_id" value="${deposit_type.id}">
                <input type="hidden" name="user_id" value="${userId}">
                <button>Отклонить</button>
            </form>
            <form action="bank-solution">
                <input type="hidden" name="command" value="approved_deposit">
                <input type="hidden" name="result_approved_deposit" value="true">
                <input type="hidden" name="deposit_type_id" value="${deposit_type.id}">
                <input type="hidden" name="user_id" value="${userId}">
                <button>Одобрить</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
