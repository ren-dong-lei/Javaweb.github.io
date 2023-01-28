<%@ page import="cn.edu.ahtcm.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: leibo
  Date: 2023/1/5
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.edu.ahtcm.bean.User" %>
<%
    User user = (User)request.getSession().getAttribute("user");
%>
<head>
    <title>Title</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<html>
<body background="https://w.wallhaven.cc/full/2y/wallhaven-2yk9dx.png" style="background-size:100%;background-attachment: fixed;">
</body>
</html>


<div class="text-center" class="container-fluid" >
    <div  class="text-center" class="row" >
        <div  class="text-center" class="col-md-12" >
            <div class="text-center"style="color:black">
                <h2 >

                </h2>
                <h2 >
                    RENDONGLEI BLOG<br>
                </h2>

                <p>
                    欢迎来到hl的博客！
                </p>
                <br>
                <br>
            </div>

            <a href="/ArticleListServlet">
            <button type="button" class="btn btn-primary" style="z-index:9999;">
                文章列表
            </button>
            </a>
            <a href="/admin/articleAdd.jsp">
            <button type="button" class="btn btn-primary" style="z-index:9999;">
                添加文章
            </button>
            </a>
            <a href="/UserListServlet">
            <button type="button" class="btn btn-primary" style="z-index:9999;">
                用户列表
            </button>
            </a>
        </div>
    </div>
</div>
<br>

<div class=" text-center" style="color: white">
    <p>
        <br>
        <br>
    </p>
</div>
<div class="jumbotron text-center" style="margin-bottom:0" >
    <p>底部内容</p>
</div>
</body>
</html>





