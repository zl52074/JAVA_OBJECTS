package bean;

import java.util.List;

public class ProductPage<T> {
     List<T> list;
     private int pageSize;
     private int pageNumber;
     private int productCount;
     private int pageTatal;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getPageTatal() {
        return pageTatal;
    }

    public void setPageTatal(int pageTatal) {
        this.pageTatal = pageTatal;
    }

    public int getPageTotal(){
        return   (int)Math.ceil(productCount*1.0/pageSize);
    }

    public int getPageIndex(){
        return (pageNumber-1)*pageSize;
    }

    public ProductPage( int pageNumber,int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
