package service;

import bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    int getProductCount() throws SQLException;
    List<Product> getList(int index,int size) throws SQLException;
    int getSerachCount(String keyword) throws SQLException;
    List<Product> getSearchList(String keyword,int index,int size) throws SQLException;
    Product getProduct(String pid)throws SQLException;

}
