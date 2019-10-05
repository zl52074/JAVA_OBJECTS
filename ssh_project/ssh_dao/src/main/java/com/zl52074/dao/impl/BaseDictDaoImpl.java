package com.zl52074.dao.impl;

import java.util.List;

import com.zl52074.dao.BaseDictDao;
import com.zl52074.domain.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 字典DAO的实现类
 * 
 * @author jt
 *
 */
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	@Override
	// 根据类型编码查询字典数据
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?",
				dict_type_code);
	}

}
