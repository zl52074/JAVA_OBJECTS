<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<title>登陆系统</title>

	<meta
			content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
			name="viewport">

	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
	<script
			src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js">
	</script>
</head>

<body style="background-color: #2A8DC8">
<div style="padding-top: 130px">
	<div class="login-logo">
		<a href="all-admin-index.html"><font color="white">客户关系管理系统</font></a>
	</div>
	<div style="text-align: center"><font color="white" size="3"><s:property value="#request.error" /></font></div>
	<!-- /.login-logo -->
	<div style="width: 350px;height: 500px; margin: 0 auto;">
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
			<TR>
				<TD width=15><IMG src="images/new_019.jpg"
								  border=0></TD>
				<TD width="100%" background=images/new_020.jpg
					height=20></TD>
				<TD width=15><IMG src="images/new_021.jpg"
								  border=0></TD>
			</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
			<tr>
				<TD width=15 background=images/new_022.jpg>
					<IMG	src="images/new_022.jpg" border=0>
				</TD>
				<TD align="center" bgColor=#ffffff>
					<table width="100%" height=100% border="0" cellpadding="0" cellspacing="0">
						<tr>
							<div style="text-align: center;padding-bottom: 5px"><font color="red">超级管理员admin 密码123</font></div>
							<form action="${ pageContext.request.contextPath }/user_login.action" method=post target="_parent">
								<div class="form-group has-feedback">
									<input type="text" name="user_code" class="form-control"
										   placeholder="用户名"> <span
										class="glyphicon glyphicon-envelope form-control-feedback"></span>
								</div>
								<div class="form-group has-feedback">
									<input type="password" name="user_password" class="form-control"
										   placeholder="密码"> <span
										class="glyphicon glyphicon-lock form-control-feedback"></span>
								</div>
								<div class="row">
									<!-- /.col -->
									<div class="col-xs-12">
										<button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
									</div>

									<!-- /.col -->
								</div>

							</form>
						</tr>
					</table>
				</td>
				<TD width=15 background=images/new_023.jpg>
					<IMG src="images/new_023.jpg" border=0>
				</TD>
			</tr>
			</TBODY>
		</table>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
			<TR>
				<TD width=15><IMG src="images/new_024.jpg"
								  border=0></TD>
				<TD align=middle width="100%"
					background=images/new_025.jpg height=15></TD>
				<TD width=15><IMG src="images/new_026.jpg"
								  border=0></TD>
			</TR>
			</TBODY>
		</TABLE>



	</div>
	<!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->


</body>

</html>