package service;

import bean.Product;
import dao.ProductDao;
import dao.ProductDaoImp;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImp implements ProductService {
    @Override
    public int getProductCount() throws SQLException {
        ProductDao pd = new ProductDaoImp();
        int productCount = pd.queryProductCount();
        return productCount;
    }

    @Override
    public List<Product> getList(int index, int size) throws SQLException {
        ProductDao pd = new ProductDaoImp();
        List<Product> list = pd.queryList(index, size);
        return list;
    }

    @Override
    public int getSerachCount(String keyword) throws SQLException {
        ProductDao pd = new ProductDaoImp();
        int productCount = pd.querySearchCount(keyword);
        return productCount;
    }

    @Override
    public List<Product> getSearchList(String keyword, int index, int size) throws SQLException {
        ProductDao pd = new ProductDaoImp();
        List<Product> list = pd.querySearchList(keyword,index, size);
        return list;
    }

    @Override
    public Product getProduct(String pid) throws SQLException {
        ProductDao pd = new ProductDaoImp();
        Product pro = pd.queryProduct(pid);
        return pro;
    }


}
