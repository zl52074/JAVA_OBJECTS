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
    <title>用户注册</title>
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

            <form id="defaultForm" method="post" class="form-horizontal" action="${pageContext.request.contextPath}/user" >
                <input type="hidden" name="method" value="submitRegister">
                <div class="form-group">
                    <label class="col-lg-3 control-label">用户名</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="username" placeholder="用户名" />
                    </div>
                </div>
                <%--密码--%>
                <div class="form-group">
                    <label class="col-lg-3 control-label">密码</label>
                    <div class="col-lg-5">
                        <input type="password" class="form-control" name="password" placeholder="密码"/>
                    </div>
                </div>
                <%--确认密码--%>
                <div class="form-group">
                    <label class="col-lg-3 control-label">确认密码</label>
                    <div class="col-lg-5">
                        <input type="password" class="form-control" name="confirmPassword" placeholder="确认密码"/>
                    </div>
                </div>
                <%--邮箱--%>
                <div class="form-group">
                    <label class="col-lg-3 control-label">邮箱</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="email" placeholder="邮箱"/>
                    </div>
                </div>
                <%--姓名--%>
                <div class="form-group">
                    <label class="col-lg-3 control-label">姓名</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="name" placeholder="姓名" />
                    </div>
                </div>
                <%--性别--%>
                <div class="form-group">
                    <label class="col-lg-3 control-label">性别</label>
                    <div class="col-lg-5">
                        <div >
                            <label class="radio-inline">
                                <input type="radio" name="sex" value="1" checked /> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" value="0"  /> 女
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">出生日期</label>
                    <div class="col-lg-5">
                        <input type="date" class="form-control" name="birthday" value="1999-01-01"/>
                    </div>
                </div>
                <%--验证码--%>
                <div class="form-group">
                    <label class="col-lg-3 control-label">验证码</label>
                    <div></div>
                    <div class="col-lg-2 col-xs-6" style="float: left">
                        <input type="text" class="form-control" name="code" />
                    </div>
                    <div class="col-lg-2" style="float: left">
                        <img id="codeimg" src="${pageContext.request.contextPath}/code" alt="" style="height: 32px" >
                    </div>
                </div>
                <%--提交按钮--%>
                <div class="form-group">
                    <div class="col-lg-9 col-lg-offset-3">
                        <button type="submit" class="btn btn-primary">注册</button>
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
        })
        $('#defaultForm')
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
                            },
                            stringLength: {
                                min: 6,
                                max: 30,
                                message: '用户名长度必须为6至30位'
                            },
                            remote: {
                                url: '${pageContext.request.contextPath}/user?method=validateUsername',
                                message: '用户名被注册',
                                dalay:2000,
                                type:"post"
                            },
                            regexp: {
                                regexp: /^[a-zA-Z0-9]+$/,
                                message: '用户名只能由字母或数字组成'
                            }
                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: '邮箱不能为空'
                            },
                            regexp: {
                                regexp: /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/,
                                message: '格式不正确'
                            },
                            remote: {
                                url: '${pageContext.request.contextPath}/user?method=validateEmail',
                                message: '邮箱已被注册',
                                dalay:2000,
                                type:"post"
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            },
                            regexp : {
                                regexp : /^(?:(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])|(?=.*[A-Z])(?=.*[a-z])(?=.*[^A-Za-z0-9])|(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9])|(?=.*[a-z])(?=.*[0-9])(?=.*[^A-Za-z0-9])).{8,16}$/,
                                message : '用户新密码长度为8至16位,并且需要包含数字、小写字母、大写字母、符号(至少三种)'
                            },
                            stringLength: {
                                min: 8,
                                max: 50,
                                message: '用户新密码长度不能少于8位'
                            },
                            identical: {
                                field: 'confirmPassword',
                                message: '两次密码必须一致'
                            }
                        }
                    },
                    confirmPassword:{
                        validators: {
                            notEmpty: {
                                message: '确认密码不能为空'
                            },
                            identical: {
                                field: 'password',
                                message: '两次密码必须一致！'
                            }
                        }
                    },
                    name: {
                        validators: {
                            notEmpty: {
                                message: '姓名不能为空'
                            }
                        }
                    },
                    birthday: {
                        validators: {
                            notEmpty: {
                                message: '日期不能为空'
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
</script>

</body>
</html>
