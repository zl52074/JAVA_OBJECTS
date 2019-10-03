package com.zl52074.controller;


import com.github.pagehelper.PageInfo;
import com.zl52074.domain.Permission;
import com.zl52074.service.PermissionService;
import com.zl52074.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")
    public String save(Permission permission) throws Exception {
        permission.setId(UUIDUtils.getUUID());
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findAll.do")
    @RolesAllowed({"ADMIN","USER"})
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList = permissionService.findAll(page, size);
        Integer count = permissionService.findCount();
        mv.addObject("count",count);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(permissionList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/deletePermission.do")
    @RolesAllowed("ADMIN")
    public String deleteRole(@RequestParam(name="id",required = true) String id) throws Exception {
        permissionService.deletePermissionById(id);
        return "redirect:findAll.do";
    }
}
