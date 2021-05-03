package com.hyb.ssm.dao;

import com.hyb.ssm.domain.Member;
import com.hyb.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {


    //根据id查询
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
