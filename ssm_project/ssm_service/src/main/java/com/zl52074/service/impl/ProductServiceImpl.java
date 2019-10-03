package com.zl52074.service.impl;

import com.github.pagehelper.PageHelper;
import com.zl52074.dao.OrdersDao;
import com.zl52074.dao.ProductDao;
import com.zl52074.domain.Product;
import com.zl52074.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer findCount() throws Exception {
        Integer count = productDao.findCount();
        return count;
    }

    @Override
    public List<Product> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public void update(Product product) throws Exception {
        productDao.update(product);
    }


    @Override
    public Product findById(String id) throws Exception {
        Product product = productDao.findById(id);
        return product;
    }


    @Override
    public void delete(String[] ids) throws Exception {
        for(String id:ids){
            String[] oids = productDao.findOrderId(id);
            for(String oid:oids){
                productDao.deleteOrdersTraveller(oid);
                productDao.deleteOrders(oid);
            }
            productDao.deleteProduct(id);
        }
    }
}
