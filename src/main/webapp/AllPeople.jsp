<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 12-May-21
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webResources/css/css.css">
</head>
<body>
<c:import url="components/header.jsp"/>
<c:choose>
    <c:when test="${requestScope.users.userList.size() > 0}">
        <table class = "table">
          <thead>
                <tr>
                    <th>Потребител</th>
                    <th>Работа</th>
                    <th>Информация</th>
                </tr>
          </thead>
          <tbody>
              <c:forEach items="${requestScope.users.userList}" var="person">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/Edit?id=${person.id}">${person.name}</a></td>
                    <td>${person.workName}</td>
                    <td>${person.description}</td>
                </tr>
              </c:forEach>
          </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <h3>There are no Users in the database.</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
