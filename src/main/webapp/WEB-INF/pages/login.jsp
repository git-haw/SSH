<%--
  Created by IntelliJ IDEA.
  User: haw
  Date: 17-5-15
  Time: 下午2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>please login</title>
</head>
<body>
<form:form action="/login.do" method="post">
<table>
    <tr>
        <td>Name:</td><td><input type="text" name="username"/></td>
    </tr>
    <tr>
        <td>password:</td><td><input type="password" name="password"/></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="提交"/></td>
    </tr>
</table>
</form:form>
</body>
</html>
