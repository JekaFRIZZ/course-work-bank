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
    <h1>Запросы</h1>
</div>

<div class="card__wrapper my-3">
    <div class="card">
        <div class="card-body">
            <c:forEach var="depositAndUser" items="${mapDepositAndUser}">
                <form action="/bank-solution">
                    <input type="hidden" name="command" value="show_user_profile">
                    <input type="hidden" name="deposit_type_id" value="${depositAndUser.key.id}">
                    <input type="hidden" name="user_id" value="${depositAndUser.value.id}">
                        <%--<input type="hidden" name="deposit_id" value="${depositAndUser.value.id}">--%>
                    Пользователь <i><c:out value="${depositAndUser.value.login}"/></i> запрашивает депозит <i><c:out value="${depositAndUser.key.name}"/></i>
                    <button>Перейти</button>
                    <br>
                </form>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
