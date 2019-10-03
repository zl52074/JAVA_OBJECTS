package com.zl52074.dao;


import com.zl52074.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {

    @Insert("insert into syslog values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;

    @Select("select * from syslog")
    List<SysLog> findAll() throws Exception;

    @Select("select count(*) from syslog")
    Integer findCount();
}
