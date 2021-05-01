package com.hyb.ssm.service;

import com.hyb.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll() throws Exception;
}
