<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 06-Apr-21
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.User==null}">
    <c:redirect url="/Login"/>
</c:if>

<html>
<head>
    <title>EditProfilePage</title>
    <link rel="stylesheet" href="webResources/css/dashboard.css">
</head>
<body>

<div class="pane">
    <c:set var="i" value="0"/>
    <c:set var="j" value="0"/>
    <div class="wrapper">
        <c:import url="components/header.jsp"/>
        <form method="post" action="${pageContext.request.contextPath}/Edit?id=${requestScope.user.id}" id="edit">
            <div class="profile-pane">
                <img src="webResources/images/user.png" alt="">
                <div class="profile">
                    <h2>Профилна информация</h2>
                    <label class="flex-lbl">
                        <input type="text" name="name" class="textbox" placeholder="Име:" value = "${sessionScope.User.name}">
                    </label>
                    <label class="flex-lbl">
                        <input type="text" name="work" class="textbox" placeholder="Работа:" value="${sessionScope.User.workName}">
                    </label>
                    <label class="flex-lbl">
                        <textarea name="description" form="edit" placeholder="Описание:" class="textbox">${sessionScope.User.description}</textarea>
                    </label>
                </div>
            </div>
            <h2>Умения</h2>
            <div class="inner-pane">
                <div class="ability-left">
                    <h3>Професионални</h3>
                    <div class="ability" id="skillsLeft">

                        <c:forEach items="${requestScope.user.profAbilities}" var="skill">
                        <label class="flex-lbl">
                            <input placeholder="Choose Skill." class="search-box" type="text" name="LSkillName${i}" value="${skill.name}" />
                            <input  class = "slider" type="range" min="1" max="100" name="LSkillValue${i}" value="${skill.percentage}">
                            <button type="button" onclick="">Remove</button>
                        </label>
                            <c:set var="i" value="${i+1}"/>
                        </c:forEach>
                    </div>
                    <button type="button" onclick="addAbilityLeft()">Add Skill</button>
                </div>
                <div class="ability-right">
                    <h3>Личностни</h3>
                    <div class="ability" id="skillsRight">
                        <c:forEach items="${requestScope.user.persAbilities}" var="skill">
                            <label class="flex-lbl">
                                <input placeholder="Choose Skill." class="search-box" type="text" name="RSkillName${j}" value="${skill.name}" />
                                <input  class = "slider" type="range" min="1" max="100" name="RSkillValue${j}" value="${skill.percentage}">
                                <button type="button" onclick="">Remove</button>
                            </label>
                            <c:set var="i" value="${i+1}"/>
                        </c:forEach>
                    </div>
                    <button type="button" onclick="addAbilityRight()">Add Skill</button>
                </div>
            </div>
            <h2>Контакти</h2>
            <div class="footer-pane">
            <div class="info-pane">
                <div class="info">
                    <label class="flex-lbl">
                        <input type="email" name="email" class="textbox" placeholder="Имейл" value="${sessionScope.User.email}">
                    </label>
                </div>
                <div class="info">
                    <label class="flex-lbl">
                        <input type="tel" name="phone" class="textbox" placeholder="Телефон" value="${sessionScope.User.phone}">
                    </label>
                </div>
            </div>
            <div class="info-pane">
                <div class="info">
                    <label class="flex-lbl">
                        <input type="text" name="town" class="textbox" placeholder="Град" value="${sessionScope.User.town}">
                    </label>
                </div>
                <div class="info">
                    <label class="flex-lbl">
                        <input type="text" name="street" class="textbox" placeholder="Адрес" value="${sessionScope.User.address}">
<%--                        <textarea name="street" form="edit" placeholder="Улица" class="textbox" ></textarea>--%>
                    </label>
                </div>
            </div>
        </div>
            <input type="submit" value="Save" class="btn">
        </form>
    </div>

</div>

<script>
    var i = ${i};
    var j = ${j};
    var containerLeft = document.getElementById("skillsLeft");
    var containerRight = document.getElementById("skillsRight");
    function addAbilityLeft(){
        // Container <div> where dynamic content will be placed
        var containerLbl = document.createElement("label");
        containerLbl.className= "flex-lbl";
        containerLeft.appendChild(containerLbl);

        // Create an <input> element, set its type and name attributes
        var inputName = document.createElement("input");
        var inputValue = document.createElement("input");
        inputName.placeholder = "Choose skill";
        inputName.className="search-box";
        inputName.type = "text";
        inputName.name = "LSkillName" + i;
        inputValue.type = "range";
        inputValue.name = "LSkillValue"+i++;
        inputValue.min = "1";
        inputValue.max = "100";
        inputValue.className = "slider";
        containerLbl.appendChild(inputName);
        containerLbl.appendChild(inputValue);
        var rmBtn = document.createElement("button");
        rmBtn.type = "button";
        rmBtn.onclick = function removeLbl() {
            containerLeft.removeChild(containerLbl);
        };
        rmBtn.textContent = "Remove";
        containerLbl.appendChild(rmBtn);
    }
    function addAbilityRight(){
        // Container <div> where dynamic content will be placed
        var containerLbl = document.createElement("label");
        containerLbl.className= "flex-lbl";
        containerRight.appendChild(containerLbl);

        // Create an <input> element, set its type and name attributes
        var inputName = document.createElement("input");
        var inputValue = document.createElement("input");
        inputName.placeholder = "Choose skill";
        inputName.className="search-box";
        inputName.type = "text";
        inputName.name = "RSkillName" + i;
        inputValue.type = "range";
        inputValue.name = "RSkillValue"+i++;
        inputValue.min = "1";
        inputValue.max = "100";
        inputValue.className = "slider";
        containerLbl.appendChild(inputName);
        containerLbl.appendChild(inputValue);
        var rmBtn = document.createElement("button");
        rmBtn.type = "button";
        rmBtn.onclick = function removeLbl() {
            containerRight.removeChild(containerLbl);
        };
        rmBtn.textContent = "Remove";
        containerLbl.appendChild(rmBtn);
    }
</script>
</body>
</html>

