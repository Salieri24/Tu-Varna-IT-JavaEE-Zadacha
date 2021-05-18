<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 17-Mar-21
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="User" scope="session" type="com.example.Uni_login.models.User"/>
    <jsp:setProperty name="User" property="name" value="${(sessionScope.User.name != null) ? sessionScope.User.name : 'No information' }"/>
    <jsp:setProperty name="User" property="workName" value = "${(sessionScope.User.workName != null) ? sessionScope.User.workName : 'Unemployed' }"/>
    <jsp:setProperty name="User" property="description" value="${(sessionScope.User.description != null) ? sessionScope.User.description : 'Empty' }"/>
    <jsp:setProperty name="User" property="email" value="${(sessionScope.User.email != null) ? sessionScope.User.email : 'no Email' }"/>
    <jsp:setProperty name="User" property="town" value="${(sessionScope.User.town != null) ? sessionScope.User.town : 'no Info' }"/>
    <jsp:setProperty name="User" property="phone" value="${(sessionScope.User.phone != null) ? sessionScope.User.phone : 'no Phone' }"/>
    <jsp:setProperty name="User" property="address" value="${(sessionScope.User.address != null) ? sessionScope.User.address : 'no Info' }"/>

<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="webResources/css/dashboard.css">
</head>
<body>
<div class="pane">
    <c:import url="components/header.jsp"/>
    <div class="wrapper">

        <c:if test="${cookie.get('firstLoginPerDay')==null}">
            <p>Добре дошли!</p>
            <form method="get" action="${pageContext.request.contextPath}/ProfileServlet">
                <input type="hidden" name="turnedOff" value="yes">
                <input type="submit" value="Изключи">
            </form>
        </c:if>

        <div class="profile-pane">
            <img src="webResources/images/user.png" alt="">
            <div class="profile">
                <h2>Профилна информация</h2>
                <p>Име: ${User.name}</p>
                <p>Работа: <jsp:getProperty name="User" property="workName"/> </p>
                <p>
                    Описание: <jsp:getProperty name="User" property="description"/>
                </p>
            </div>
            <a href="${pageContext.request.contextPath}/Edit?id=${sessionScope.User.id}">Edit Profile</a>
        </div>
        <h2>Умения</h2>
        <div class="inner-pane">
            <div class="ability-left">
                <h3>Професионални</h3>
                <c:forEach items= "${User.profAbilities}" var="profAbility">
                    <div class="ability">
                        <h4>${profAbility.name}</h4>
                        <div class="loading-background">
                            <div style="width: ${profAbility.percentage}%" class="loading-bar">
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="ability-right">
                <h3>Личностни</h3>
                <c:forEach items= "${User.persAbilities}" var="persAbility">
                        <div class="ability">
                            <h4>${persAbility.name}</h4>
                            <div class="loading-background">
                                <div style="width: ${persAbility.percentage}%" class="loading-bar">
                                </div>
                            </div>
                        </div>
                </c:forEach>
            </div>
        </div>
        <h2>Контакти</h2>
        <div class="footer-pane">
            <div class="info-pane">
                <div class="info">
                    <p>Имейл</p>
                    <a href="#">${User.email}</a>
                </div>
                <div class="info">
                    <p>Телефон</p> <a href="#">${User.phone}</a>
                </div>
            </div>
            <div class="info-pane">
                <div class="info">
                    <p>Град</p>${User.town}
                </div>
                <div class="info">
                    <p>Улица</p>
                    ${User.address}
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
