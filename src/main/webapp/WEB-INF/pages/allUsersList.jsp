<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User Management Application</title>
</head>
<body>
<div style="text-align: center;">
    <h1>User Management</h1>
    <h2>
        <form action="/" method="GET">
            <input type="submit" value="Update users list">
        </form> &nbsp;&nbsp;&nbsp;
        <form action="/newUserFrom" method="GET">
            <input type="submit" value="Add user">
        </form>
    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Role</th>
            <th>Password</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.role}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td>
                    <form action="${pageContext.request.contextPath}/editForm" method="post">
                        <input type="hidden" name="id" value="${user.id}"/>
                        <input type="hidden" name="name" value="${user.name}"/>
                        <input type="hidden" name="role" value="${user.role}"/>
                        <input type="hidden" name="password" value="${user.password}"/>
                        <button type="submit">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/delete" method="post">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
