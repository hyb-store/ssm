package com.hyb.dao;

import com.hyb.domain.Province;

import java.sql.SQLException;
import java.util.List;

public interface ProvinceDao {

    public List<Province> findAll() throws Exception;
}
