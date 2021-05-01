package com.hyb.ssm.service.impl;

import com.hyb.ssm.dao.IOrdersDao;
import com.hyb.ssm.domain.Orders;
import com.hyb.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }
}
