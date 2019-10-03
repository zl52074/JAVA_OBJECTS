package bean;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart
{
    // 有购物项的集合
					/* 购物项.商品对象.pid      购物项
					   购物项.商品对象.pid        购物项
					 购物项.商品对象.pid        购物项
					想拿到购物项就能拿到它的key    购物项.商品对象.pid*/
    private Map<String,CartItem> map=new LinkedHashMap<String,CartItem>();
    // 总金额
    private double total;

    public Map<String, CartItem> getMap() {
        return map;
    }
    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }
    public double getTotal() {
        return total;
    }
		/*public void setTotal(double total) {
			this.total = total;
		}*/

    // 设置总金额三种情况  清空   添加   删除

    // 清空购物车
    public void clear()
    {
        // 清空购物项
        map.clear();
        // 总金额要变成0
        total=0;
    }

    // 删除
    public void remove(String key)
    {
        // 去购物项集合中 根据key删除对应的购物项
        CartItem item = map.remove(key);
        // 计算总金额
        total=total-item.getSubtotal();
    }

    // 添加
    public void add(CartItem item)
    {
        // 只要添加进来购物项 我就得判断购物项集合中是否有该购物项
        CartItem citem = map.get(item.getProduct().getPid());
        if(citem==null)
        {
            // 没有 --- 直接添加到购物项集合中
            map.put(item.getProduct().getPid(),item);
            // 总金额=总金额+新添加进来购物项的小计
            total=total+item.getSubtotal();
        }else
        {
            // 有 --- 将以前存在于购物项集合中的购物项的数量进行累加
            citem.setCount(citem.getCount()+item.getCount());
            // 总金额=总金额+新添加进来购物项的小计
            total=total+item.getSubtotal();
        }

    }




}