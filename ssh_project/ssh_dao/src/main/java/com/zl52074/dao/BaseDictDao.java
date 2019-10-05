package com.zl52074.dao;

import com.zl52074.domain.BaseDict;

import java.util.List;

public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> findByTypeCode(String dict_type_code);

}
