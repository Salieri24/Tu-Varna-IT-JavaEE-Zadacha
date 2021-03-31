<%@ page pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Task1</title>
        <link rel="stylesheet" href="webResources/css/css.css">
        <meta charset="UTF-8">
    </head>
    <body>

        <div class = "wrapper">
            <h1>Създаване на профил</h1>
            <div class = "container">
                <form action = "RegistrationServlet" method="post" >
                    <div class = "textfield">
                        <label for="name">Име:</label>
                        <input name = "name" id = "name" type ="text" placeholder="Въведете име за контакт" >

                    </div>
                    <div class = "textfield">
                        <label for="username">Потребителско име:</label>
                        <input name = "username" id = "username" type ="text" placeholder="Въведете потребителско име" >

                    </div>
                    <div class = "textfield">
                        <label for="password">Парола:</label>
                        <input name = "password"  id="password" type ="password" placeholder="Въведете парола с поне 8 символа" >

                    </div>
                    <div class = "textfield">
                        <label for="password2">Повторете паролата:</label>
                        <input name = "password2" id="password2"  type ="password" placeholder="Въведете парола с поне 8 символа" >
                    </div>
                <input type = "submit" value = "Вход">
                </form>

            </div>
            <%if(session.getAttribute("error")!=null){%>
            <div class="error-field">
                ${sessionScope.error}
            </div>
            <%}%>
            
        </div>
        			<h1> Have an account?<br><a href="login.jsp">Log in</a> </h1>
        
    </body>
</html>