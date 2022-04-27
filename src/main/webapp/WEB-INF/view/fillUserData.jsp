<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Solution</title>
    <link rel="stylesheet" href="/static/fillUserData.css">
</head>
<body>
<jsp:include page="./fragments/header.jsp"></jsp:include>
<div class="form__wrapper">
    <form action="/bank-solution" method="post">
        <div class="data__wrapper">
            <div class="data__left">
                <input type="hidden" name="command" value="fill_user_data">
                <input type="text" name="name" placeholder="Enter name">
                <input type="text" name="surname" placeholder="Enter surname">
                <input type="text" name="patronymic" placeholder="Enter patronymic">
                <input type="date" name="birthday">
                <div class="radio__wrapper">
                    <input type="radio" id="man" name="sex" value="true">
                    <label for="man">Man</label>
                    <input type="radio" id="woman" name="sex" value="false">
                    <label for="woman">Woman</label>
                </div>
                <input type="text" name="passportNo" placeholder="Enter passport number">
                <input type="text" name="issuedBy" placeholder="Enter issued by">
                <input type="date" name="whenIssued">
                <input type="text" name="identificationNo" placeholder="Enter identification number">
                <input type="text" name="placeBirth" placeholder="Enter place birth">
                <input type="text" name="cityActualResidence" placeholder="Enter city actual residence">
                <input type="text" name="address" placeholder="Enter address">
                <input type="text" name="homePhone" placeholder="Enter home phone">
                <c:if test="${homePhoneNotUnique != null}"><c:out value="${homePhoneNotUnique}"/></c:if>
            </div>
            <div class="data__right">
                <input type="text" name="mobilePhone" placeholder="Enter mobile phone">
                <c:if test="${phoneIncorrect != null}"><c:out value="${phoneIncorrect}"/></c:if>
                <c:if test="${mobilePhoneNotUnique != null}"><c:out value="${mobilePhoneNotUnique}"/></c:if>
                <input type="text" name="email" placeholder="Enter email">
                <c:if test="${emailIncorrect != null}"><c:out value="${emailIncorrect}"/></c:if>
                <input type="text" name="placeWork" placeholder="Enter place work">
                <input type="text" name="position" placeholder="Enter position">
                <input type="text" name="cityResidence" placeholder="Enter city residence">
                <input type="text" name="addressResidence" placeholder="Enter address residence">
                <input type="text" name="familyStatus" placeholder="Enter family status">
                <input type="text" name="citizenship" placeholder="Enter citizenship">
                <input type="text" name="disability" placeholder="Enter disability">
                <div class="radio__wrapper">
                    <input type="radio" id="pens__true" name="isPensioner" value="true">
                    <label for="pens__true">Yes</label>
                    <input type="radio" id="pens__false" name="isPensioner" value="false">
                    <label for="pens__false">No</label>
                </div>
                <input type="number" step="0.001" name="salary" placeholder="Enter salary">
                <div class="radio__wrapper">
                    <input type="radio" id="cons__true" name="isConscripts" value="true">
                    <label for="cons__true">Yes</label>
                    <input type="radio" id="cons__false" name="isConscripts" value="false">
                    <label for="cons__false">No</label>
                </div>
            </div>
        </div>
        <button type="submit">send</button>
    </form>
    <c:if test="${incorrectData != null}"><c:out value="${incorrectData}"/></c:if>
</div>
</body>
</html>
