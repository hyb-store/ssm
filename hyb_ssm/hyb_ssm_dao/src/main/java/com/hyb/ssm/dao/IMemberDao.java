package com.hyb.ssm.dao;

import com.hyb.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {


    //根据id查询
    @Select("select * from member where id = #{id}")
    public Member findById(String id) throws Exception;
}
