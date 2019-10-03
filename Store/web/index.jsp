<%--
  Created by IntelliJ IDEA.
  User: zl520
  Date: 2019/8/26
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎</title>
  </head>
  <body>
  <% request.getRequestDispatcher("/product?method=product_page&pagenumber=1").forward(request, response);%>
  <h1><center><font color="red">首页</font></center></h1>
  <a href="${pageContext.request.contextPath}/product?method=product_page&pagenumber=1">首页</a>
  <a href="${pageContext.request.contextPath}/user?method=login">登陆</a>
  <a href="${pageContext.request.contextPath}/user?method=register">注册</a>

  </body>
</html>
