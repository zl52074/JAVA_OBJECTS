package com.zl52074.dao;

import com.zl52074.domain.Orders;
import com.zl52074.domain.Product;
import org.apache.ibatis.annotations.*;
import org.aspectj.weaver.Member;

import java.util.List;

public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.zl52074.dao.ProductDao.findById")),
    })
    public List<Orders> findAll() throws Exception;

    //多表操作
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.zl52074.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.zl52074.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many = @Many(select = "com.zl52074.dao.TravellerDao.findByOrdersId"))
    })
    public Orders findById(String ordersId) throws Exception;


    @Select("select * from orders where productId=#{pid} ")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.zl52074.dao.ProductDao.findById")),
    })
    public List<Orders> findByProductId(String pid) throws Exception;

    @Delete("delete from order_traveller where orderId=#{id}")
    void deleteOrdersTraveller(String id);

    @Delete("delete from orders where id=#{id}")
    void deleteOrders(String id);

    @Select("select count(*) from orders")
    Integer findCount();

}