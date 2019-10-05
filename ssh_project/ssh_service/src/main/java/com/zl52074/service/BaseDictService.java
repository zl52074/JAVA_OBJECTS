package com.zl52074.service;

import com.zl52074.domain.BaseDict;

import java.util.List;

public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
