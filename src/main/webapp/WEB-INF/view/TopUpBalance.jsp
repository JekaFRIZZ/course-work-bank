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
</body>
</html>
