package com.zl52074.controller;

import com.github.pagehelper.PageInfo;
import com.zl52074.domain.Permission;
import com.zl52074.domain.Role;
import com.zl52074.service.RoleService;
import com.zl52074.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/deleteRole.do")
    @RolesAllowed("ADMIN")
    public String deleteRole(@RequestParam(name="id",required = true) String roleId) throws Exception {
        roleService.deleteRoleById(roleId);
        return "redirect:findAll.do";
    }

    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")
    public String save(Role role) throws Exception {
        role.setId(UUIDUtils.getUUID());
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    @RolesAllowed({"ADMIN","USER"})
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll(page, size);
        Integer count = roleService.findCount();
        mv.addObject("count",count);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(roleList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    //角色详情查询
    @RequestMapping("/findById.do")
    @RolesAllowed({"ADMIN","USER"})
    public ModelAndView findById(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);

        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }

    //给角色添加权限
    @RequestMapping("/addPermissionToRole.do")
    @RolesAllowed("ADMIN")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }

    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据roleId查询role
        Role role = roleService.findById(roleId);
        //根据roleId查询可以添加的权限


        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;

    }
}
