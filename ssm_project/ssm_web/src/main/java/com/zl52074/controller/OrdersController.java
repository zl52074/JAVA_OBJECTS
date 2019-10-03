package com.zl52074.controller;

import com.github.pagehelper.PageInfo;

import com.zl52074.domain.Orders;
import com.zl52074.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    //查询全部订单---未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll();
//        mv.addObject("ordersList", ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }

    @RequestMapping("/findAll.do")
    @RolesAllowed({"ADMIN","USER","VISITOR"})
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, size);
        Integer count = ordersService.findCount();
        mv.addObject("count",count);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    @RolesAllowed({"ADMIN","USER","VISITOR"})
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

    @RequestMapping("/findByProductId.do")
    @RolesAllowed({"ADMIN","USER","VISITOR"})
    public ModelAndView findByProductId(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size,@RequestParam(name = "pid", required = true) String pid) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println(pid);
        List<Orders> ordersList = ordersService.findByProductId(page, size,pid);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }


    @RequestMapping("/delete.do")
    @RolesAllowed({"ADMIN", "USER"})
    public String delete(@RequestParam(name = "ids", required = true) String[] ids) throws Exception {
            ordersService.delete(ids);
            return "redirect:findAll.do";
    }
}
