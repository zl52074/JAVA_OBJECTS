package com.zl52074.controller;


import com.github.pagehelper.PageInfo;
import com.zl52074.domain.Orders;
import com.zl52074.domain.SysLog;
import com.zl52074.service.SysLogService;
import org.apache.log4j.net.SyslogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll(page, size);
        Integer count = sysLogService.findCount();
        mv.addObject("count", count);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(sysLogList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }

}
