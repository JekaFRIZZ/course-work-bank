<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Solution</title>
</head>
<body>
<jsp:include page="./fragments/header.jsp"></jsp:include>
<c:forEach var="depositAndUser" items="${mapDepositAndUser}">
    <form action="/bank-solution">
        <input type="hidden" name="command" value="show_user_profile">
        <input type="hidden" name="deposit_type_id" value="${depositAndUser.key.id}">
        <input type="hidden" name="user_id" value="${depositAndUser.value.id}">
        <%--<input type="hidden" name="deposit_id" value="${depositAndUser.value.id}">--%>
        <c:out value="${depositAndUser.value.login}"/>
        <c:out value="${depositAndUser.key.name}"/>
        <button>Перейти</button>
    </form>
</c:forEach>
</body>
</html>
