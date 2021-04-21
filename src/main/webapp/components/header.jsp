<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 21-Apr-21
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<nav>
    <ul class="navigation-bar">
        <c:choose >
            <c:when test="${sessionScope.User!=null}">
                <li><a href="${pageContext.request.contextPath}/Logout">Изход</a> </li>
            </c:when>
            <c:otherwise>
                <li><a href="${pageContext.request.contextPath}/Registration">Регистрация</a></li>
                <li><a href="${pageContext.request.contextPath}/Login">Вход</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>