package com.zl52074.dao;

import com.zl52074.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductDao {
    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;

    //查询所有的产品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Select("select count(*) from product")
    public Integer findCount() throws Exception;

    @Insert("insert into product values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product)throws Exception;

    @Update("update product set productNum =#{productNum},productName =#{productName} ,cityName =#{cityName},DepartureTime = #{departureTime},productPrice = #{productPrice},productDesc = #{productDesc},productStatus = #{productStatus} where id=#{id}")
    void update (Product product)throws Exception;

    @Select("select * from orders where productId=#{id}")
    String[] findOrderId(String id);

    @Delete("delete from order_traveller where orderId=#{id}")
    void deleteOrdersTraveller(String id);
    @Delete("delete from orders where id=#{id}")
    void deleteOrders(String id);
    @Delete("delete from product where id=#{id}")
    void deleteProduct(String id);
}
