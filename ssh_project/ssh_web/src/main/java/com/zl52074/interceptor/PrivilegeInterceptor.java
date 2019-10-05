package com.zl52074.interceptor;

import com.zl52074.domain.User;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import javax.servlet.http.HttpServletRequest;


public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 判断session中是否有登录用户的信息
		User existUser = (User)ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser!=null){
			String uname = existUser.getUser_name();
			if(!"admin".equals(uname)){
				// 存错误信息,页面跳转到登录页面
				ActionSupport actionSupport = (ActionSupport) invocation.getAction();
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("error", "权限不足，无法操作");
				return "403";
			}else{
				// 已经登录：
				return invocation.invoke();
			}
		}else{
			return "login";
		}


	}

}
