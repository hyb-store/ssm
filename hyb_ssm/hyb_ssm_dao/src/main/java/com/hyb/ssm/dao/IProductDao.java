package com.hyb.ssm.dao;

import com.hyb.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    //查询所有产品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
}
