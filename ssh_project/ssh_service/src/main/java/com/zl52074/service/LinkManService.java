package com.zl52074.service;

import com.zl52074.domain.LinkMan;
import com.zl52074.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;


public interface LinkManService {

	PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);

}
