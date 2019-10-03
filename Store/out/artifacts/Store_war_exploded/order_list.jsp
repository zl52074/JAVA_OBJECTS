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
    <title>商品列表</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.js"></script>


</head>

<body>

<div class="row" style="width:100%;margin:0 auto;">
    <div class="col-md-2 col-sm-0 col-xs-0"></div>
    <div class="col-md-8 col-sm-12 col-xs-12">
        <div class="col-md-12" style="padding-top: 10px;">
            <%--导航栏--%>
            <nav class="navbar navbar-default" style="border: 0px;">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/product?method=product_page&pagenumber=1">首页</a>
                    </div>
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
                    </div>
                </div>
            </nav>
            <%--页面标签--%>
            <div class="page-header">
                <font color="#00bfff" size="4">订单列表</font>
                <font size="2">ORDER LIST</font>
            </div>
            <%--####################################################################################--%>
            <%--购物项表--%>
            <div style="margin:0 auto; margin-top:10px;">
                <strong><font size="2">我的订单</font></strong>
                <c:forEach items="${requestScope.orders}" var="order">


                <table class="table table-bordered" >
                    <tbody>
                    <tr class="success">
                        <th colspan="4"><font size="2">订单编号：${order.oid}</font></th>
                        <th style="text-align: right"><font size="2"><a href="${pageContext.request.contextPath}/order?method=deleteOrder&oid=${order.oid}">删除订单</a></font></th>
                    </tr>

                    <tr class="warning">
                        <th> <font size="2">图片</font></th>
                        <th><font size="2">商品</font></th>
                        <th><font size="2">价格</font></th>
                        <th><font size="2">数量</font></th>
                        <th><font size="2">小计</font></th>
                    </tr>
                    <c:forEach items="${order.orderItems}" var="orderitem">
                        <tr class="active">
                            <td  width="10%">
                                <input type="hidden" name="id" value="22">
                                <img src="${pageContext.request.contextPath}/${orderitem.product.pimage}" width="50px" height="50px">
                            </td>
                            <td width="20%">
                                <a href="${pageContext.request.contextPath}/product?method=product_info&pid=${orderitem.product.pid}"><font size="2">${orderitem.product.pname}</font></a>
                            </td>
                            <td width="15%">
                                <font size="2">￥${orderitem.product.price}</font>
                            </td>
                            <td width="15%">
                                <font size="2">${orderitem.count}</font>
                            </td>
                            <td width="15%">
                                <span class="subtotal"><font size="2">￥${orderitem.subtotal}</font></span>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr class="success" >
                        <td colspan="5"  style="text-align: right">
                            <font size="2"></em> 赠送积分: <em style="color:#ff6600;">${order.total}</em>&nbsp; 商品金额: <strong style="color:#ff6600;">￥${order.total}元</strong></font>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </c:forEach>

            </div>
        </div>

    </div>
    <div class="col-md-2 col-sm-0 col-xs-0"></div>
</div>


</body>

</html>


