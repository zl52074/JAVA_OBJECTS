package com.zl52074.service;

import java.util.List;

import com.zl52074.domain.Customer;
import com.zl52074.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;


public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	Customer findById(Long cust_id);

	void delete(Customer customer);

	void update(Customer customer);

	List<Customer> findAll();

}
