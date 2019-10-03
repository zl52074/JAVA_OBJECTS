package com.zl52074.service;

import com.zl52074.domain.Product;

import java.util.List;

public interface ProductService {
    Integer findCount() throws Exception;
    List<Product> findAll(int page, int size) throws Exception;
    void save(Product product)throws Exception;
    void update(Product product)throws Exception;
    void delete(String[] ids) throws Exception;
    Product findById(String id) throws Exception;
}
