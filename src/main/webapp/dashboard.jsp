<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 17-Mar-21
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/css/dashboard.css">
</head>
<body>
<div class="pane">
    <div class="wrapper">
        <div class="profile-pane">
            <img src="resources/images/user.png" alt="">
            <div class="profile">
                <h2>Профилна информация</h2>
                <!-- Get the Name from the session.parameters? Seems like it works like this-->
                <p>Име: ${sessionScope.User.name}</p>
                <p>Работа: Студент</p>
                <p>
                    Описание: Известен факт е, че читателя обръща внимаие на съдържанието, което чете, а не на оформлението му.
                    Свойството на Lorem Ipsum e, че до голяма степен има нормално разпределение
                    на буквите и се чете по-лесно, за разлика от нормален текст на английски език като "Това е съдържание, това
                    е съдържание".
                </p>
            </div>
        </div>
        <h2>Умения</h2>
        <div class="inner-pane">
            <div class="ability-left">

                <h3>Професионални</h3>
                <div class="ability">
                    <h4>Java</h4>
                    <div class="loading-background">
                        <div style="width: 32%" class="loading-bar">
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
                </div>
            </div>
            <div class="ability-right">
                <h3>Личностни</h3>
                <div class="ability">
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
                </div>
            </div>
        </div>
        <h2>Контакти</h2>
        <div class="footer-pane">
            <div class="info-pane">
                <div class="info">
                    <p>Имейл</p>
                    <a href="#">ivan@tu-varna.bg</a>
                </div>
                <div class="info">
                    <p>Град</p>Варна
                </div>
            </div>
            <div class="info-pane">
                <div class="info">
                    <p>Телефон</p>
                    09876543219
                </div>
                <div class="info">
                    <p>Улица</p>
                    Студентска 1
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
