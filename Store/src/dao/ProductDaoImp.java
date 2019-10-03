package dao;

import bean.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImp implements ProductDao {
    @Override
    public int queryProductCount() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT COUNT(*) FROM product WHERE pstate = 1";
        int intValue = ((Long)qr.query(sql, new ScalarHandler())).intValue();
        return intValue;
    }

    @Override
    public List<Product> queryList(int index, int size) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from product where pstate = 1 limit ?,?";
        List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class),index,size);
        return list;
    }

    @Override
    public int querySearchCount(String keyword) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select count(*) from product where pstate = 1 and pname like ? or pdesc like ?";
        String key = "%"+keyword+"%";
        int intValue = ((Long)qr.query(sql, new ScalarHandler(),key,key)).intValue();
        return intValue;
    }

    @Override
    public List<Product> querySearchList(String keyword, int index, int size) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from product where pstate = 1 and pname like ? or pdesc like ? limit ?,?";
        String key = "%"+keyword+"%";
        List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class),key,key,index,size);
        return list;
    }

    @Override
    public Product queryProduct(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from product where pstate = 1 and pid = ?";
        Product pro = qr.query(sql, new BeanHandler<Product>(Product.class),pid);
        return pro;
    }
}
