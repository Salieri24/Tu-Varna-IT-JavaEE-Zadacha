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
        <form method="post" action="${pageContext.request.contextPath}/Edit" id="edit">
        <div class="profile-pane">
            <img src="webResources/images/user.png" alt="">
            <div class="profile">
                <h2>Профилна информация</h2>
                <label class="flex-lbl">
                    <input type="text" name="name" class="textbox" placeholder="Име:">
                </label>
                <label class="flex-lbl">
                    <input type="text" name="work" class="textbox" placeholder="Работа:">
                </label>
                <label class="flex-lbl">
                    <textarea name="description" form="edit" placeholder="Описание:" class="textbox"></textarea>
                </label>
            </div>
        </div>
        <h2>Умения</h2>
        <div class="inner-pane">
            <div class="ability-left">
                <h3>Професионални</h3>
                <div class="ability">
                    <label class="flex-lbl">
                        <input placeholder="Choose Skill." class="search-box" type="text" list="prof" name="persSkill" />
                    </label>
                    <datalist id="prof">
                        <option value="Java"></option>
                        <option value="HTML"></option>
                        <option value="CSS"></option>
                    </datalist>
                    <label >Skill level:<input  class = "slider" type="range" min="1" max="100" value="50"></label>
                </div>
            </div>
            <div class="ability-right">
                <h3>Личностни</h3>
                <div class="ability">
                    <label class="flex-lbl">
                        <input placeholder="Choose Skill." class="search-box" type="text" list="pers" name="profSkill"/>
                    </label>
                    <datalist id="pers">
                        <option value="Communication"></option>
                        <option value="Creativity"></option>
                    </datalist>
                    <label >Skill level:<input  class = "slider" type="range" min="1" max="100" value="50"></label>
                </div>
            </div>
        </div>
        <h2>Контакти</h2>
        <div class="footer-pane">
            <div class="info-pane">
                <div class="info">
                    <label class="flex-lbl">
                        <input type="email" name="email" class="textbox" placeholder="Имейл">
                    </label>
                </div>
                <div class="info">
                    <label class="flex-lbl">
                        <input type="tel" name="phone" class="textbox" placeholder="Телефон">
                    </label>
                </div>
            </div>
            <div class="info-pane">
                <div class="info">
                    <label class="flex-lbl">
                        <input type="text" name="town" class="textbox" placeholder="Град">
                    </label>
                </div>
                <div class="info">
                    <label class="flex-lbl">
<%--                        <input type="text" name="street">--%>
                        <textarea name="street" form="edit" placeholder="Улица" class="textbox"></textarea>
                    </label>

                </div>
            </div>
        </div>
            <input type="submit" value="Save" class="btn">
        </form>
    </div>

</div>
</body>
</html>

