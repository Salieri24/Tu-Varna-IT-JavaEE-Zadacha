
<%@ page import="com.example.Uni_login.models.Ability" %>
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
    <jsp:setProperty name="User" property="name" value="${sessionScope.User.name}"/>
    <jsp:setProperty name="User" property="workName" value="Студент"/>
    <jsp:setProperty name="User" property="description" value="Известен факт е, че читателя обръща внимаие на съдържанието, което чете, а не на оформлението му.
                    Свойството на Lorem Ipsum e, че до голяма степен има нормално разпределение
                    на буквите и се чете по-лесно, за разлика от нормален текст на английски език като 'Това е съдържание, това е съдържание'."/>

    <jsp:setProperty name="User" property="email" value="ivan@tu-varna.bg"/>
    <jsp:setProperty name="User" property="town" value="Варна"/>
    <jsp:setProperty name="User" property="phone" value="09876543219"/>
    <jsp:setProperty name="User" property="address" value="Студентска 1"/>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webResources/css/dashboard.css">
</head>
<body>

<div class="pane">
    <div class="wrapper">
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
<%--                <div class="ability">
                    <h4>Java</h4>
                    <div class="loading-background">
                        <div style="width: " class="loading-bar">
                        </div>
                    </div>
                </div>
                <div class="ability">
                    <h4>HTML</h4>
                    <div class="loading-background">
                        <div style="width: 32%" class="loading-bar">
                        </div>
                    </div>
                </div>
                <div class="ability">
                    <h4>CSS</h4>
                    <div class="loading-background">
                        <div style="width: 32%" class="loading-bar">
                        </div>
                    </div>
                </div>
                <div class="ability">
                    <h4>JavaScript</h4>
                    <div class="loading-background">
                        <div style="width: 32%" class="loading-bar">
                        </div>
                    </div>
                </div>--%>
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

<%--                <div class="ability">
                    <h4>Комуникативност</h4>
                    <div class="loading-background">
                        <div style="width: 32%" class="loading-bar">
                        </div>
                    </div>
                </div>
                <div class="ability">
                    <h4>Екиптна работа</h4>
                    <div class="loading-background">
                        <div style="width: 32%" class="loading-bar">
                        </div>
                    </div>
                </div>
                <div class="ability">
                    <h4>Креативност</h4>
                    <div class="loading-background">
                        <div style="width: 32%" class="loading-bar">
                        </div>
                    </div>
                </div>--%>
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
