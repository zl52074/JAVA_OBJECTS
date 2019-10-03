package bean;

// 购物项
public class CartItem
{
    // 商品对象
    private Product product;
    // 商品数量
    private Integer count;
    // 商品小计
    private double  subtotal;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    // 内部自定义好价格
    public double getSubtotal()
    {
        // 商品的单价*数量
        return product.getPrice()*count;
    }

    //安全性保证，价格不允许定义
	/*public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}*/
}