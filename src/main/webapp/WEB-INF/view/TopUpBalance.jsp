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
    <h1>Пополнить баланс</h1>
</div>

<div class="card__wrapper my-3">
    <div class="card">
        <div class="card-body">
            <form action="/bank-solution" method="post">
                <input type="hidden" name="command" value="top_up_balance">
                <input type="number" name="amount">
                <button>Пополнить</button>
            </form>
            <c:if test="${balanceTopUp != null}">
                <c:out value="${balanceTopUp}"/>
            </c:if>
            <c:if test="${balanceError != null}">
                <c:out value="${balanceError}"/>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
