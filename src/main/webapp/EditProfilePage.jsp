<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 06-Apr-21
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>EditProfilePage</title>
    <link rel="stylesheet" href="webResources/css/dashboard.css">
</head>
<body>
<div class="pane">
    <div class="wrapper">
        <form method="post" action="${pageContext.request.contextPath}/Edit">
        <div class="profile-pane">
            <img src="webResources/images/user.png" alt="">
            <div class="profile">
                <h2>Профилна информация</h2>
                <p>Име: </p>
                <label>
                    <input type="text" name="name">
                </label>
                <p>Работа: </p>
                <label>
                    <input type="text" name="work">
                </label>
                <p>Описание:</p>
                <label>
                    <input type="text" name="description">
                </label>
            </div>
        </div>




        <h2>Умения</h2>
        <div class="inner-pane">


            <div class="ability-left">

                <h3>Професионални</h3>


<%--                <c:forEach items= "${User.profAbilities}" var="profAbility">--%>
<%--                    <div class="ability">--%>
<%--                        <h4>${profAbility.name}</h4>--%>
<%--                        <div class="loading-background">--%>
<%--                            <div style="width: ${profAbility.percentage}%" class="loading-bar">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--            <div class="ability-right">--%>
<%--                <h3>Личностни</h3>--%>

<%--                <c:forEach items= "${User.persAbilities}" var="persAbility">--%>

<%--                    <div class="ability">--%>
<%--                        <h4>${persAbility.name}</h4>--%>
<%--                        <div class="loading-background">--%>
<%--                            <div style="width: ${persAbility.percentage}%" class="loading-bar">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
            </div>
        </div>
        <h2>Контакти</h2>
        <div class="footer-pane">
            <div class="info-pane">
                <div class="info">
                    <p>Имейл</p>
                    <label>
                        <input type="text" name="email">
                    </label>
                </div>
                <div class="info">
                    <p>Телефон</p>
                    <label>
                        <input type="text" name="phone">
                    </label>
                </div>

            </div>
            <div class="info-pane">
                <div class="info">
                    <p>Град</p>
                    <label>
                        <input type="text" name="town">
                    </label>
                </div>
                <div class="info">
                    <p>Улица</p>
                    <label>
                        <input type="text" name="street">
                    </label>

                </div>
            </div>
        </div>
        </form>
    </div>

</div>
</body>
</html>

