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
    <input type="hidden" name="command" value="show_enter_deposit">
    <input type="hidden" name="name_deposit" value="start">
    <strong>Вклад "Старт"</strong>
    <button>Оформить заявку</button>
</form>
<form action="/bank-solution" method="post">
    <input type="hidden" name="command" value="show_enter_deposit">
    <input type="hidden" name="name_deposit" value="start+">
    <strong>Вклад "Старт Plus"</strong>
    <button>Оформить заявку</button>
</form>
<form action="/bank-solution" method="post">
    <input type="hidden" name="command" value="show_enter_deposit">
    <input type="hidden" name="name_deposit" value="bussiness">
    <strong>Вклад "Бизнес"</strong>
    <button>Оформить заявку</button>
</form>
<form action="/bank-solution" method="post">
    <input type="hidden" name="command" value="show_enter_deposit">
    <input type="hidden" name="name_deposit" value="bussiness+">
    <strong>Вклад "Бизнес Plus"</strong>
    <button>Оформить заявку</button>
</form>
<form action="/bank-solution" method="post">
    <input type="hidden" name="command" value="show_enter_deposit">
    <input type="hidden" name="name_deposit" value="diamond">
    <strong>Вклад "Diamond"</strong>
    <button>Оформить заявку</button>
</form>
<c:if test="${MakeDepositSuccessful != null}">
    <c:out value="${MakeDepositSuccessful}"/>
</c:if>
<c:if test="${NotEnoughBalance != null}">
    <c:out value="${NotEnoughBalance}"/>
</c:if>
</body>
</html>
