<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Solution</title>
</head>
<body>
<jsp:include page="./fragments/header.jsp"></jsp:include>
<c:forEach var="user" items="${users}">
    Логин : ${clientModel.login}
    Имя : ${clientModel.name}
    Фамилия : ${clientModel.surname}
    Отчество : ${clientModel.patronymic}
    Мобильный телефон : ${clientModel.mobilePhone}
</c:forEach>
</body>
</html>
