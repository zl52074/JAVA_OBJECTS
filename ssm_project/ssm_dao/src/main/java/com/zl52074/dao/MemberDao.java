package com.zl52074.dao;

import com.zl52074.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;
}
