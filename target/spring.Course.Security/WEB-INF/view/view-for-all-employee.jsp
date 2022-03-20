<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vinev
  Date: 20.03.2022
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Employees</title>
</head>
<body>

<h3>Information for All Employees</h3>
<br><br>
<security:authorize access="hasRole('HR')">
<input type="button" value="Salary" onclick="window.location.href= 'hr-info'">only for HR staff
</security:authorize>
<br><br>
<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance" onclick="window.location.href= 'manager-info'">only for manager staff
</security:authorize>
<br><br>

</body>
</html>
