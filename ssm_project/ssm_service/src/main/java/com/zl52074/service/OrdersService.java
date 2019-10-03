package com.zl52074.service;

import com.zl52074.domain.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String ordersId) throws Exception;

    List<Orders> findByProductId(int page, int size,String pid) throws Exception;

    void delete (String[] ids) throws Exception;

    Integer findCount()throws Exception;
}
