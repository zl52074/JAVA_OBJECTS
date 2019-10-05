package com.zl52074.service.impl;

import com.zl52074.dao.BaseDictDao;
import com.zl52074.domain.BaseDict;
import com.zl52074.service.BaseDictService;

import java.util.List;



public class BaseDictServiceImpl implements BaseDictService {
	// 注入DAO
	private BaseDictDao baseDictDao;

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return baseDictDao.findByTypeCode(dict_type_code);
	}
	
}
