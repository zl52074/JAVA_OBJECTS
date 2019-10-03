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
            <div class="page-header">
                <font color="#00bfff" size="4">用户登陆</font>
                <font size="2">USER LOGIN</font>
            </div>

            <form id="loginForm" method="post"  class="form-horizontal" action="${pageContext.request.contextPath}/user">
                <input type="hidden" name="method" value="submitLogin">
                <div class="form-group">
                    <label class="col-md-3  control-label"></label>
                    <div class="col-md-5 " id="warnning" style="display: inline-block">
                        <font color="#a94442" size="2px">${requestScope.msg}</font>
                    </div>
                </div>
                <%--用户名--%>
                <div class="form-group">
                    <label class="col-md-3 control-label">用户名</label>
                    <div class="col-md-5 ">
                        <input type="text" id = "username" class="form-control" name="username" placeholder="用户名" />
                    </div>
                </div>
                <%--密码--%>
                <div class="form-group">
                    <label class="col-md-3  control-label">密码</label>
                    <div class="col-md-5 ">
                        <input type="password" id="password" class="form-control" name="password" placeholder="密码"/>
                    </div>
                </div>
                <%--验证码--%>
                <div class="form-group">
                    <label class="col-md-3  control-label">验证码</label>
                    <div></div>
                    <div class="col-md-2 col-xs-6" style="float: left">
                        <input type="text" class="form-control" name="code" />
                    </div>
                    <div class="col-md-2 " style="float: left">
                        <img id="codeimg" src="${pageContext.request.contextPath}/code" alt="" style="height: 32px" >
                    </div>
                </div>
                <%--提交按钮--%>
                <div class="form-group">
                    <div class="col-md-9  col-md-offset-3">
                        <button id="btn1" type="submit"  class="btn btn-primary"style="float:left ">登陆</button>
                        <div style="float: left; margin-top: 8px;margin-left: 15px;"><a href="${pageContext.request.contextPath}/user?method=register"><font color="#00bfff"size="3">注册</font></a></div>
                    </div>
                </div>
            </form>

        </div>
    </div>
    <div class="col-md-2 col-sm-0 col-xs-0"></div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $("#codeimg").click(function(){
            this.src="${pageContext.request.contextPath}/code?date="+new Date().getTime();
        });
        $('#loginForm')
            .bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    username: {
                        message: 'The username is not valid',
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
                            },regexp: {
                                regexp: /^[^\u4e00-\u9fa5]+$/,
                                message: '用户名不能含有中文'
                            }

                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            }
                        }
                    },
                    code: {
                        validators: {
                            notEmpty: {
                                message: '验证码不能为空'
                            },
                            remote: {
                                url: '${pageContext.request.contextPath}/user?method=validateCode',
                                message: '验证码输入有误',
                                dalay:2000,
                                type:"post"
                            }
                        }
                    }
                }
            })

    });
    $("#warnning").show().delay(3000).fadeOut();
</script>

</body>
</html>
