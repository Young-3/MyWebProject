<%--
  Created by IntelliJ IDEA.
  User: 3
  Date: 2019/3/1
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>success</title>
</head>
<body>
<c:forEach items="${list}" var="user">
    <tr>
        <td align="center">${user.u_id}</td>
        <td align="center">${user.u_name}</td>

    </tr>
</c:forEach>

    student welcom
</body>
</html>
