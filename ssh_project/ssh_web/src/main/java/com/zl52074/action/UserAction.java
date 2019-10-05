package com.zl52074.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zl52074.domain.LinkMan;
import com.zl52074.domain.PageBean;
import com.zl52074.domain.User;
import com.zl52074.service.UserService;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class UserAction extends ActionSupport implements ModelDriven<User> {
	// 模型驱动使用的对象
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}

	// 注入Service:
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 分页参数:
	private Integer currPage = 1;
	private Integer pageSize = 3;

	public void setCurrPage(Integer currPage) {
		if(currPage == null){
			currPage = 1;
		}
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize == null){
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}

	//用户添加
	public String save(){
		System.out.println(user.getUser_state());
		userService.regist(user);
		return "saveSuccess";
	}

	//用户添加
	public String add(){
		return "add";
	}


	//用户退出
	public String quit(){
		ActionContext.getContext().getSession().remove("existUser");
		return LOGIN;
	}


	//用户登录
	public String login(){
		// 调用业务层查询用户:
		User existUser = userService.login(user);
		if(existUser == null){
			// 登录失败
			// 添加错误信息:
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("error", "用户名或密码错误!");
			return LOGIN;
		}else{
			// 登录成功
//			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			ActionContext.getContext().getSession().put("existUser", existUser);
			return SUCCESS;
		}
	}

	public String findAllUser() throws IOException {
		List<User> list = userService.findAll();
		JSONArray jsonArray = JSONArray.fromObject(list);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}


	public String userList(){
		// 创建离线条件查询:
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		// 设置条件

		if(user.getUser_name()!=null){
			// 设置按名称查询的条件:
			detachedCriteria.add(Restrictions.like("user_name", "%"+user.getUser_name()+"%"));
		}
		// 设置性别条件:
		if(user.getUser_state() != null && !"".equals(user.getUser_state())){
			// 设置按性别查询的条件:
			detachedCriteria.add(Restrictions.eq("user_state", user.getUser_state()));
		}
		// 调用业务层
		PageBean<User> pageBean = userService.userList(detachedCriteria,currPage,pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "userList";
	}

	public String delete() {
		// 先查询，再删除。
		user = userService.findById(user.getUser_id());
		userService.delete(user);
		return "deleteSuccess";
	}
}
