<%@ page import="cn.edu.ahtcm.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: leibo
  Date: 2023/1/18
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    User user = (User)request.getSession().getAttribute("user");
%>

<html>
<head>
    <title>Title</title>
    <!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">当前用户：<%out.print(user.getName()); %></a></li>
                <li><a href="/LoginOut">[退出]</a></li>
            </ul>
        </div>
    </div>
</nav>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-8">
            <table class="table table-striped table-bordered">
                <div class="text-center"style="color:gray">
                    <p >
                        用户列表
                    </p>
                </div>
                <thead>
                <tr>
                    <th>id</th>
                    <th>用户名</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user"   items="${userList}" >
                    <tr>
                        <td>${user.id}</td>
                        <td><a href="${user.id}">${user.name}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="jumbotron text-center" style="margin-bottom:0">
    <p>底部内容</p>
</div>
</body>

