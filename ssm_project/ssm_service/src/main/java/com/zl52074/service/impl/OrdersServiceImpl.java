package com.zl52074.service.impl;

import com.github.pagehelper.PageHelper;

import com.zl52074.dao.OrdersDao;
import com.zl52074.domain.Orders;
import com.zl52074.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {

        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        Orders orders = ordersDao.findById(ordersId);
        return orders;
    }

    @Override
    public List<Orders> findByProductId(int page, int size, String pid) throws Exception {
        PageHelper.startPage(page, size);
        return ordersDao.findByProductId(pid);
    }

    @Override
    public void delete(String[] ids) throws Exception {
        for(String id:ids){
            ordersDao.deleteOrdersTraveller(id);
            ordersDao.deleteOrders(id);
        }
    }

    @Override
    public Integer findCount() throws Exception {
        Integer count = ordersDao.findCount();
        return count;
    }
}
