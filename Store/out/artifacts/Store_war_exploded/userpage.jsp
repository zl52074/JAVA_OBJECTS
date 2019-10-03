<%--
  Created by IntelliJ IDEA.
  User: zl520
  Date: 2019/9/4
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户登陆</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap-validator/css/bootstrapValidator.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap-validator/js/bootstrapValidator.js"></script>
</head>

<body>
<div class="row" style="width:100%;margin:0 auto;">
    <div class="col-md-2 col-sm-0 col-xs-0"></div>
    <div class="col-md-8 col-sm-12 col-xs-12">
        <div class="col-md-12" style="padding-top: 10px;">
            <nav class="navbar navbar-default" style="border: 0px;">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/product?method=product_page&pagenumber=1">首页</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">



                        <ul class="nav navbar-nav navbar-right">
                            <c:if test="${not empty sessionScope.user}">
                                <li><a href="#">用户：${sessionScope.user.username}</a></li>
                            </c:if>
                            <c:if test="${empty sessionScope.user}">
                                <li><a href="${pageContext.request.contextPath}/user?method=login">登陆</a></li>
                            </c:if>
                            <li><a href="${pageContext.request.contextPath}/user?method=register">注册</a></li>
                            <li><a href="${pageContext.request.contextPath}/product?method=cart">购物车</a></li>
                            <li><a href="${pageContext.request.contextPath}/order?method=orderList">订单</a></li>
                            <li><a href="${pageContext.request.contextPath}/user?method=quitLogin">退出</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <center><font>注册成功，现在去<a href="${pageContext.request.contextPath}/user?method=login">登陆</a></font></center>

        </div>
    </div>
    <div class="col-md-2 col-sm-0 col-xs-0"></div>
</div>

</body>
</html>