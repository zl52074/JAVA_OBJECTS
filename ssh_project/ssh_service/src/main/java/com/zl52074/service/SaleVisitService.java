package com.zl52074.service;

import com.zl52074.domain.PageBean;
import com.zl52074.domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;



public interface SaleVisitService {

	PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(SaleVisit saleVisit);

    SaleVisit findById(String visit_id);

	void update(SaleVisit saleVisit);

	void delete(SaleVisit saleVisit);
}
