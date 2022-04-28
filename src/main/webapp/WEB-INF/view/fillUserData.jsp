<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Solution</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <%--<link rel="stylesheet" href="/static/fillUserData.css">--%>
    <link rel="stylesheet" href="/static/multipurpose.css">
</head>
<body>
<jsp:include page="./fragments/header.jsp"></jsp:include>

<div class="heading__wrapper">
    <h1>Аккаунт</h1>
</div>

<div class="card__wrapper my-3">
    <div class="card">
        <div class="card-body">

            <div class="form__wrapper">
                <form action="/bank-solution" method="post">
                    <div class="data__wrapper">
                        <div class="data__left">
                            <input type="hidden" name="command" value="fill_user_data">
                            <input type="text" name="name" placeholder="Введите имя" >
                            <input type="text" name="surname" placeholder="Введите фамилию">
                            <input type="text" name="patronymic" placeholder="Введите отчество">
                            <label for="birth">День рождение</label>
                            <input type="date" name="birthday" id="birth">
                            <div class="radio__wrapper">
                                <input type="radio" id="man" name="sex" value="true">
                                <label for="man">Мужчина</label>
                                <input type="radio" id="woman" name="sex" value="false">
                                <label for="woman">Женщина</label>
                            </div>
                            <input type="text" name="passportNo" placeholder="Введите номер паспорта">
                            <input type="text" name="issuedBy" placeholder="Выдан">
                            <label for="whenIssued">Дата выдачи паспорта</label>
                            <input type="date" name="whenIssued" id="whenIssued">
                            <input type="text" name="identificationNo" placeholder="Введите идентификационный номер">
                            <input type="text" name="placeBirth" placeholder="Введите место рождения">
                            <input type="text" name="cityActualResidence" placeholder="Введите место проживания">
                            <input type="text" name="address" placeholder="Введите адрес">
                            <input type="text" name="homePhone" placeholder="Введите домашний телефон">
                            <c:if test="${homePhoneNotUnique != null}"><c:out value="${homePhoneNotUnique}"/></c:if>
                        </div>
                        <div class="data__right">
                            <input type="text" name="mobilePhone" placeholder="Введите мобильный номер телефона">
                            <c:if test="${phoneIncorrect != null}"><c:out value="${phoneIncorrect}"/></c:if>
                            <c:if test="${mobilePhoneNotUnique != null}"><c:out value="${mobilePhoneNotUnique}"/></c:if>
                            <input type="text" name="email" placeholder="Введите почту">
                            <c:if test="${emailIncorrect != null}"><c:out value="${emailIncorrect}"/></c:if>
                            <input type="text" name="placeWork" placeholder="Введите место работы">
                            <input type="text" name="position" placeholder="Введите должность">
                            <input type="text" name="cityResidence" placeholder="Введите город проживания">
                            <input type="text" name="addressResidence" placeholder="Введите адрес проживания">
                            <input type="text" name="familyStatus" placeholder="Введите семейное положение">
                            <input type="text" name="citizenship" placeholder="Введите гражданство">
                            <input type="text" name="disability" placeholder="Введите инвалидность">
                            <div class="radio__wrapper">
                                Пенсионер
                                <input type="radio" id="pens__true" name="isPensioner" value="true">
                                <label for="pens__true">Да</label>
                                <input type="radio" id="pens__false" name="isPensioner" value="false">
                                <label for="pens__false">Нет</label>
                            </div>
                            <input type="number" step="0.001" name="salary" placeholder="Введите зарплату">
                            <div class="radio__wrapper">
                                Годен
                                <input type="radio" id="cons__true" name="isConscripts" value="true">
                                <label for="cons__true">Да</label>
                                <input type="radio" id="cons__false" name="isConscripts" value="false">
                                <label for="cons__false">Нет</label>
                            </div>
                        </div>
                    </div>
                    <button type="submit">send</button>
                </form>
                <c:if test="${incorrectData != null}"><c:out value="${incorrectData}"/></c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
