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
    <h1>Информация о депозите</h1>
</div>

<div class="card__wrapper my-3">
    <div class="card">
        <div class="card-body">

            <form action="/bank-solution" method="post">
                <input type="hidden" name="command" value="make_deposit">
                <input type="hidden" name="name_deposit" value="${requestScope.name_deposit}">
                <br>Название депозита: ${requestScope.name_deposit}
                <br>Минимальная сумма: ${requestScope.min_amount}
                <br>Минимальный срок: ${requestScope.min_validity}
                <br>Введите сумму: <input type="number" name="amount" required>
                <br>Введите срок: <input type="number" name="validity" required>
                <br><button>Подать заявку</button>
            </form>
            <c:if test="${IncorrectValues != null}">
                <c:out value="${IncorrectValues}"/>
            </c:if>
            <c:if test="${MakeDepositNotSuccessful != null}">
                <c:out value="${MakeDepositNotSuccessful}"/>
                <a href="/bank-solution?command=show_fill_user_data">Заполните данные</a>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
