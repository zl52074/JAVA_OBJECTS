package com.zl52074.controller;


import com.github.pagehelper.PageInfo;
import com.zl52074.domain.Role;
import com.zl52074.domain.UserInfo;
import com.zl52074.service.UserService;
import com.zl52074.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    @RolesAllowed("ADMIN")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) {
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll.do";
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userid) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(userid);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userid);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    //查询指定id的用户
    @RequestMapping("/findById.do")
    @RolesAllowed({"ADMIN","USER"})
    public ModelAndView findById(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }
//
    //用户添加
    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")
    public String save(UserInfo userInfo) throws Exception {
        userInfo.setId(UUIDUtils.getUUID());
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    @RolesAllowed({"ADMIN","USER"})
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll(page, size);
        Integer count = userService.findCount();
        mv.addObject("count",count);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/deleteUser.do")
    @RolesAllowed("ADMIN")
    public String deleteRole(@RequestParam(name="id",required = true) String id) throws Exception {
        userService.deleteUserById(id);
        return "redirect:findAll.do";
    }
}
