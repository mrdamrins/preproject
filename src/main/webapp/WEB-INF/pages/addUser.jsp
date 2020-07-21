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
            <input type="submit" value="List All Users">
        </form> &nbsp;&nbsp;&nbsp;
    </h2>
</div>
<div align="center">
    <form action="/newUserCreator" method="POST" accept-charset="UTF-8">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Add New User
                </h2>
            </caption>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                    />
                </td>
            </tr>
            <tr>
                <th>User Role:</th>
                <td>
                    <input type="text" name="role" size="45"
                    />
                </td>
            </tr>
            <tr>
                <th>User Password:</th>
                <td>
                    <input type="text" name="password" size="45"
                    />
                </td>
            </tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save"/>
            </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
