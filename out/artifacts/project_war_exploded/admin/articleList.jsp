<%@ page import="cn.edu.ahtcm.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: leibo
  Date: 2023/1/17
  Time: 16:03
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
                        文章列表
                    </p>
                </div>
                <thead>
                <tr>
                    <th>id</th>
                    <th>标题</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="article"   items="${articleList}" >
                    <tr>
                        <td>${article.id}</td>
                        <td><a href="/ArticleDetailServlet?id=${article.id}">${article.title}</a></td>
                        <td>
                            <a href="/ArticleEditServlet?id=${article.id}">编辑</a>
                            <a href="javascript:;" onclick="deleteArticle(${article.id})">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript">
    function deleteArticle(id){
        if(!confirm("确认要删除选中的记录吗？")) return;
        $.ajax({
            type: "post",
            url: "/ArticleDeleteServlet",
            cache	: false,
            //dataType : "json",
            data: "id="+id,
            success: function (data) {
                console.log(data);
                location.href="/ArticleListServlet";
            }
        });
    }
</script>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>底部内容</p>
</div>
</body>

