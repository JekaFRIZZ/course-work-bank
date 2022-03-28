<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/fillUserData.css">
</head>
<body>
<form action="/bank-solution">
    <input type="hidden" name="command" value="fillUserData">
    <input type="text" name="name" placeholder="Enter name">
    <input type="text" name="surname" placeholder="Enter surname">
    <input type="text" name="patronymic" placeholder="Enter patronymic">
    <input type="date" name="birthday">
    <input type="radio" name="sex" value="true">
    <input type="radio" name="sex" value="false">
    <input type="text" name="passportSeries" placeholder="Enter your passport series">
    <input type="text" name="passportNo" placeholder="Enter passport number">
    <input type="text" name="issuedBy" placeholder="Enter issuedBy">
    <input type="date" name="whenIssued">
    <input type="text" name="identificationNo" placeholder="Enter identification number">
    <input type="text" name="placeBirth" placeholder="Enter place birth">
    <input type="text" name="cityActualResidence" placeholder="Enter cityActualResidence">
    <input type="text" name="address" placeholder="Enter address">
    <input type="text" name="homePhone" placeholder="Enter homePhone">
    <input type="text" name="mobilePhone" placeholder="Enter address">
    <input type="text" name="email" placeholder="Enter email">
    <input type="text" name="placeWork" placeholder="Enter placeWork">
    <input type="text" name="position" placeholder="Enter position">
    <input type="text" name="cityResidence" placeholder="Enter cityResidence">
    <input type="text" name="addressResidence" placeholder="Enter addressResidence">
    <input type="text" name="familyStatus" placeholder="Enter familyStatus">
    <input type="text" name="citizenship" placeholder="Enter citizenship">
    <input type="text" name="disability" placeholder="Enter disability">
    <input type="radio" name="isPensioner" value="true">
    <input type="radio" name="isPensioner" value="false">
    <input type="number" step="0.001" name="salary" placeholder="Enter salary">
    <input type="radio" name="isConscripts" value="true">
    <input type="radio" name="isConscripts" value="false">
    <button type="submit">send</button>
</form>
</body>
</html>
