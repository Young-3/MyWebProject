<%--
  Created by IntelliJ IDEA.
  User: 3
  Date: 2019/2/27
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

</head>
<body>
<div align="center" style="padding-top: 2em">
    <span style="font-size: 3em">LOGIN</span> <br>
    ——————————————————————
    <form action="LoginCheckServlet" method="post">
        <table style="padding-left: 1em;">
            <tr>
                <td>用户名：</td>
                <td><input type=text name=id />
                </td>
            </tr>
            <tr>
                <td>密   码：</td>
                <td><input type="password" name="password" />
                </td>
            </tr>
        </table></p>
        <table style="padding-left: 0.6em">
            <tr>
                <td><input type=radio name=type value=partment>部门
                    <input type=radio name=type value=teacher>教师
                    <input type=radio name=type value=student checked>学生
                    <input type=radio name=type value=guest/>访客</p>
                </td>
            </tr>
        </table>
        <table align="center">
            <tr>
                <td><input type="submit" value="登录" />
                    <input type="reset" value="重置" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
