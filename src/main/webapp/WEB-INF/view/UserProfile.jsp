<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<br>
<head>
    <title>Solution</title>
</head>
<br>
<jsp:include page="./fragments/header.jsp"></jsp:include>
Домашний телефон :<c:if test="${phone.homePhone != null}"> ${phone.homePhone}</c:if><c:if test="${phone.homePhone == null}">Нет данных</c:if></br>
Мобильный телефон :<c:if test="${phone.mobilePhone != null}"> ${phone.mobilePhone}</c:if><c:if test="${phone.mobilePhone == null}">Нет данных</c:if></br>
Номер паспорта :<c:if test="${passport.passportNo != null}"> ${passport.passportNo}</c:if><c:if test="${passport.passportNo == null}">Нет данных</c:if></br>
Кем выдан паспорт :<c:if test="${passport.issuedBy != null}"> ${passport.issuedBy}</c:if><c:if test="${passport.issuedBy == null}">Нет данных</c:if></br>
Дата выдачи паспорта :<c:if test="${passport.whenIssued != null}"> ${passport.whenIssued}</c:if><c:if test="${passport.whenIssued == null}">Нет данных</c:if></br>
Идентификационный номер паспорта :<c:if test="${passport.identificationNo != null}"> ${passport.identificationNo}</c:if><c:if test="${passport.identificationNo== null}">Нет данных</c:if></br>
Место рождения :<c:if test="${passport.placeBirth != null}"> ${passport.placeBirth}</c:if><c:if test="${passport.placeBirth == null}">Нет данных</c:if></br>
Текущее место жительства :<c:if test="${passport.cityActualResidence != null}"> ${passport.cityActualResidence}</c:if><c:if test="${passport.cityActualResidence == null}">Нет данных</c:if></br>
Место прописки :<c:if test="${passport.address != null}"> ${passport.address}</c:if><c:if test="${passport.address== null}">Нет данных</c:if></br>
Логин :<c:if test="${user.login != null}"> ${user.login}</c:if><c:if test="${user.login == null}">Нет данных</c:if></br>
Имя : <c:if test="${userData.name != null}">${userData.name}</c:if><c:if test="${userData.name == null}">Нет данных</c:if></br>
Фамилия :<c:if test="${userData.surname != null}"> ${userData.surname}</c:if><c:if test="${userData.surname == null}">Нет данных</c:if></br>
Отчество :<c:if test="${userData.patronymic != null}"> ${userData.patronymic}</c:if><c:if test="${userData.patronymic == null}">Нет данных</c:if></br>
Дата рождения :<c:if test="${userData.birthday != null}"> ${userData.birthday}</c:if><c:if test="${userData.birthday == null}">Нет данных</c:if></br>
Место работы :<c:if test="${userData.placeWork != null}"> ${userData.placeWork}</c:if><c:if test="${userData.placeWork == null}">Нет данных</c:if></br>
Позиция на месте работы :<c:if test="${userData.position != null}"> ${userData.position}</c:if><c:if test="${userData.position == null}">Нет данных</c:if></br>
Семейный статус :<c:if test="${userData.familyStatus != null}"> ${userData.familyStatus}</c:if><c:if test="${userData.familyStatus == null}">Нет данных</c:if></br>
Гражданство :<c:if test="${userData.citizenship != null}"> ${userData.citizenship}</c:if><c:if test="${userData.citizenship == null}">Нет данных</c:if></br>
Инвалидность :<c:if test="${userData.disability != null}"> ${userData.disability}</c:if><c:if test="${userData.disability == null}">Нет данных</c:if></br>
Зарплата :<c:if test="${userData.salary != null}"> ${userData.salary}</c:if><c:if test="${userData.salary == null}">Нет данных</c:if></br>
</body>
</html>
