package dao;

import bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    int queryProductCount() throws SQLException;
    List<Product> queryList(int index,int size) throws SQLException;
    int querySearchCount(String keyword) throws SQLException;
    List<Product> querySearchList(String keyword,int index,int size) throws SQLException;
    Product queryProduct(String pid)throws SQLException;
}
