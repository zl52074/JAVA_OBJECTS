package com.zl52074.service;


import com.zl52074.domain.SysLog;

import java.util.List;

public interface SysLogService {

    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(int page, int size) throws Exception;

    Integer findCount();
}
