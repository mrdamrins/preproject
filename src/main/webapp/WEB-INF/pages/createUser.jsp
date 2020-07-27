<%--
  Created by IntelliJ IDEA.
  User: kleschev
  Date: 26.06.2020
  Time: 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<div align="center">
    <div>
        <a href="/logout">Logout</a>
    </div>
    <form action="<c:url value="/admin/createUser"/>" method="post">
        <table border="1" cellpadding="5">
            <caption><h2>Add User</h2></caption>
            <tr>
                <th>Username: </th>
                <td>
                    <input type="text" name="username" size="45" required
                           value="<c:out value='${user.username}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45" required
                           value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>