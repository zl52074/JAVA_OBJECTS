package com.zl52074.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.zl52074.domain.Customer;
import com.zl52074.domain.PageBean;
import com.zl52074.domain.SaleVisit;
import com.zl52074.domain.User;
import com.zl52074.service.CustomerService;
import com.zl52074.service.SaleVisitService;
import com.zl52074.service.UserService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;


public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{

	// 模型驱动使用的对象:
	private SaleVisit saleVisit = new SaleVisit();
	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}

	// 在Action中注入Service:
	@Resource(name="saleVisitService")
	private SaleVisitService saleVisitService;
	// 注入客户管理的Service
	@Autowired
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	// 注入Service:
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	// 接收分页 数据:
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

	// 接收数据:
	private Date visit_end_time;
	
	public void setVisit_end_time(Date visit_end_time) {
		this.visit_end_time = visit_end_time;
	}
	
	public Date getVisit_end_time() {
		return visit_end_time;
	}

	/**
	 * 查询拜访记录列表的方法：findAll
	 */
	public String findAll(){
		// 创建离线条件查询对象:
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
		// 设置条件:
		if(saleVisit.getVisit_time() != null){
			detachedCriteria.add(Restrictions.ge("visit_time",saleVisit.getVisit_time()));
		}
		if(visit_end_time != null){
			detachedCriteria.add(Restrictions.le("visit_time", visit_end_time));
		}
		// 调用业务层:
		PageBean<SaleVisit> pageBean = saleVisitService.findByPage(detachedCriteria,currPage,pageSize);
		// 存入到值栈:
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 拜访记录跳转到添加页面的方法:saveUI
	 */
	public String saveUI(){
		List<Customer> clist = customerService.findAll();
		List<User> ulist = userService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		ActionContext.getContext().getValueStack().set("ulist", ulist);
		return "saveUI";
	}
	
	/**
	 * 保存客户拜访记录的方法:save
	 */
	public String save(){
		// 调用业务层:
		saleVisitService.save(saleVisit);
		return "saveSuccess";
	}


	/**
	 * 跳转到编辑页面的方法：edit
	 */
	public String edit(){
		// 查询某个联系人，查询所有客户。
		// 查询所有客户:
		List<Customer> clist = customerService.findAll();
		List<User> ulist = userService.findAll();
		// 根据id查询联系人:
		saleVisit = saleVisitService.findById(saleVisit.getVisit_id());
		// 将list和linkMan的对象带到页面上：
		ActionContext.getContext().getValueStack().set("clist", clist);
		ActionContext.getContext().getValueStack().set("ulist", ulist);
		// 将对象的值存入到值栈:
		ActionContext.getContext().getValueStack().push(saleVisit);
		return "editSuccess";
	}

	/**
	 * 修改联系人的方法:update
	 */
	public String update(){
		// 调用业务层:
		saleVisitService.update(saleVisit);
		return "updateSuccess";
	}

	public String delete() {
		// 先查询，再删除。
		saleVisit = saleVisitService.findById(saleVisit.getVisit_id());
		saleVisitService.delete(saleVisit);
		return "deleteSuccess";
	}

}
