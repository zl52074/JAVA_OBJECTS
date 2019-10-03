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
                        <font color="#00bfff" size="4">购物车</font>
                        <font size="2">PRODUCT CART</font>
                    </div>
<%--####################################################################################--%>
                    <%--购物项表--%>
                    <div style="margin:0 auto; margin-top:10px;">
                            <strong style="font-size:16px;margin:5px 0;">购物车详情</strong>
                            <table class="table table-bordered">
                                <tbody>
                                <!--表头-->
                                <tr class="warning">
                                    <th><font size="2">图片</font></th>
                                    <th><font size="2">名称</font></th>
                                    <th><font size="2">单价</font></th>
                                    <th><font size="2">数量</font></th>
                                    <th><font size="2">总价</font></th>
                                    <th><font size="2">编辑</font></th>
                                </tr>
<%----------------------------------------------------------------------------------------------------------------------%>
                            <!-- 如果循环的是map 得到的结果是键值对的映射关系   mm.key=商品的pid   mm.value=cartItem 购物项 -->
                            <c:forEach items="${cart.map}" var="mm">
                                    <!--商品详情-->
                                <tr class="active">
                                    <!--预览图-->
                                    <td  width="10%">
                                        <input type="hidden" name="id" value="22">
                                        <img src="${pageContext.request.contextPath}/${mm.value.product.pimage}" width="50" height="50">
                                    </td>
                                    <!--商品名称-->
                                    <td width="20%">
                                        <a href="${pageContext.request.contextPath}/product?method=product_info&pid=${mm.value.product.pid}"> <font size="2">${mm.value.product.pname}</font></a>
                                    </td>
                                    <!--单价-->
                                    <td width="15%">
                                        <font size="2">￥${mm.value.product.price}</font>
                                    </td>
                                    <!--数量-->
                                    <td width="15%">
                                        <font size="2">${mm.value.count}</font>
                                    </td>
                                    <!--总价-->
                                    <td >
                                        <span class="subtotal"><font size="2">￥${mm.value.subtotal}</font></span>
                                    </td>
                                    <!--删除选项-->
                                    <td width="15%">
                                        <span><a href="${pageContext.request.contextPath}/cart?method=remove&pid=${mm.value.product.pid}" name="delete"><font size="2">删除</font></a></span>
                                    </td>
                                </tr>
                            </c:forEach>
<%----------------------------------------------------------------------------------------------------------------------%>
                                </tbody>
                            </table>
                    </div>
 <%--####################################################################################--%>
                    <div >
                            <div style="text-align:right;">
                                <em style="color:#ff6600;">
                                </em> 赠送积分: <em style="color:#ff6600;">${cart.total}</em>&nbsp; 商品金额: <strong style="color:#ff6600;">￥${cart.total}元</strong>
                            </div>
                            <div style="text-align:right;margin-top:10px;margin-bottom:10px;">
                                <a href="${pageContext.request.contextPath}/cart?method=removeAll" id="clear" class="clear">清空购物车</a>

                                <a href="${pageContext.request.contextPath}/order?method=addOrder">
                                        <input type="button" width="100" value="提交订单" name="submit" border="0" style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);height:35px;width:100px;color:white;">
                                </a>
                            </div>
                    </div>
            </div>


    </div>
    <div class="col-md-2 col-sm-0 col-xs-0"></div>
</div>


</body>

</html>
