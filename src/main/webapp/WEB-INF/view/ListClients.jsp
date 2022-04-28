<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Solution</title>
    <style>
        div {
            margin-left: 20px;
        }
    </style>
</head>
<body>
<jsp:include page="./fragments/header.jsp"></jsp:include>
<div>
<form action="/bank-solution">
    <input type="hidden" name="command" value="search_user">
    <input type="text" name="login">
    <button>поиск</button>
</form>
<c:if test="${clientModelSearch != null}">
    Логин : <c:if test="${clientModelSearch.login == null}">Нет данных</c:if> ${clientModelSearch.login} |
    Имя : <c:if test="${clientModelSearch.name == null}">Нет данных</c:if> ${clientModelSearch.name} |
    Фамилия : <c:if test="${clientModelSearch.surname == null}">Нет данных</c:if> ${clientModelSearch.surname} |
    Отчество : <c:if test="${clientModelSearch.patronymic == null}">Нет данных</c:if> ${clientModelSearch.patronymic} |
    Мобильный телефон : <c:if test="${clientModelSearch.mobilePhone == null}">Нет данных</c:if> ${clientModelSearch.mobilePhone}</br>
    <c:forEach var="depositClientModel" items="${depositClientModels}">
        Название депозита : ${depositClientModel.name} | Сумма : ${depositClientModel.count} | Срок : ${depositClientModel.validity}</br>
    </c:forEach>
</c:if>
<c:if test="${clientModelSearch == null}">
    <c:forEach var="model" items="${clientModel}">
        Логин : ${model.login} |
        Имя : ${model.name} |
        Фамилия : ${model.surname} |
        Отчество : ${model.patronymic} |
        Мобильный телефон : ${model.mobilePhone}
        <form action="/bank-solution" method="post">
            <input type="hidden" name="command" value="delete_user">
            <input type="hidden" name="user_id" value="${model.id}">
            <button>удалить</button>
        </form>
        </br>
    </c:forEach>
    <c:forEach var="model" items="${clientModelsNoData}">
        Логин : ${model.login} |
        Имя : ${model.name} |
        Фамилия : ${model.surname} |
        Отчество : ${model.patronymic} |
        Мобильный телефон : ${model.mobilePhone}
        <form action="/bank-solution" method="post">
            <input type="hidden" name="command" value="delete_user">
            <input type="hidden" name="user_id" value="${model.id}">
            <button>удалить</button>
        </form>
        </br>
    </c:forEach>
</c:if>
</div>
</body>
</html>
