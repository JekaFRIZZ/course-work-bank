<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Solution</title>
</head>
<body>
<jsp:include page="./fragments/header.jsp"></jsp:include>
<form action="/bank-solution" method="post">
    <input type="hidden" name="command" value="make_deposit">
    <input type="hidden" name="name_deposit" value="${requestScope.name_deposit}">
    Name ${requestScope.name_deposit}
    Minimum amount ${requestScope.min_amount}
    Minimum validity ${requestScope.min_validity}
    Enter amount <input type="number" name="amount" required>
    Enter validity <input type="number" name="validity" required>
    <button>Подать заявку</button>
</form>
<c:if test="${IncorrectValues != null}">
    <c:out value="${IncorrectValues}"/>
</c:if>
<c:if test="${MakeDepositNotSuccessful != null}">
    <c:out value="${MakeDepositNotSuccessful}"/>
    <a href="/bank-solution?command=show_fill_user_data">Заполните данные</a>
</c:if>
</body>
</html>
