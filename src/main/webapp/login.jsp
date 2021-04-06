<%@ page pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Task1</title>
        <link rel="stylesheet" href="webResources/css/css.css">
        <meta charset="UTF-8">
    </head>
    <body>

        <div class = "wrapper">
            <h1>Влизане в системата</h1>
            <div class = "container">
                <form method="post" action="${pageContext.request.contextPath}/Login">
                    <div class = "textfield">
                        <label>Потребителско име:
                        <input name = "username" type ="text" placeholder="Въведете потребителско име" >
                        </label>
                    </div>
                    <div class = "textfield">
                        <label>Парола:
                        <input name = "password" type ="password" placeholder="Въведете парола с поне 8 символа" >
                        </label>
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
        <h1>Don't have an account?<br><a href="index.jsp">Create an account</a></h1>
    </body>
</html>