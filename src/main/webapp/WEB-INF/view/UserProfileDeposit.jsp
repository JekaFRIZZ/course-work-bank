<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Solution</title>
</head>
<body>
<jsp:include page="./fragments/header.jsp"></jsp:include>
Salary : <c:out value="${userData.salary}"/>
Birthday : <c:out value="${userData.birthday}"/>
Name : <c:out value="${userData.name}"/>
Surname : <c:out value="${userData.surname}"/>
Patronymic : <c:out value="${userData.patronymic}"/>
Home phone : <c:out value="${phone.homePhone}"/>
Mobile phone : <c:out value="${phone.mobilePhone}"/>
Deposit name : <c:out value="${deposit_type.name}"/>
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
</body>
</html>
