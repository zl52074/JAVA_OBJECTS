package com.zl52074.controller;


import com.github.pagehelper.PageInfo;
import com.zl52074.domain.Orders;
import com.zl52074.domain.Product;
import com.zl52074.service.ProductService;
import com.zl52074.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll.do")
    @RolesAllowed({"ADMIN","USER","VISITOR"})
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll(page, size);
        Integer count = productService.findCount();
        mv.addObject("count",count);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(productList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-page-list");
        return mv;
    }

    //产品添加
    @RequestMapping("/save.do")
    @RolesAllowed({"ADMIN","USER"})
    public String save(Product product) throws Exception {
        product.setId(UUIDUtils.getUUID());
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/update.do")
    @RolesAllowed({"ADMIN","USER"})
    public String update(Product product) throws Exception {
        productService.update(product);
        return "redirect:findAll.do";
    }


    //编辑商品
    @RequestMapping("/edit.do")
    @RolesAllowed({"ADMIN","USER"})
    public ModelAndView edit(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(id);
        mv.addObject("product",product);
        mv.setViewName("product-edit");
        return mv;
    }

    @RequestMapping("/delete.do")
    @RolesAllowed({"ADMIN", "USER"})
    public String delete(@RequestParam(name = "ids", required = true) String[] ids) throws Exception {
            productService.delete(ids);
            return "redirect:findAll.do";
    }


}
