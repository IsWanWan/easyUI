package com.my.controller;

import com.my.domain.Admin;
import com.my.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanwan on 16/8/26.
 */
@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(){
     Admin admin =   adminService.selectByPrimaryKey(1);
        return new ModelAndView("/user");
    }

    @ResponseBody
    @RequestMapping("/listPage")
    public Map listPage(@RequestParam(required = false) String username,Integer rows,Integer page){
       Map<String ,Object> map = new HashMap<>();
        Map<String,Object> pageMap = new HashMap<>();
        map.put("username",username);
        map.put("start",(page-1)*rows);
        map.put("end",page*rows);

        pageMap.put("username",username);

        Map model = new HashMap();
        List<Admin> adminList = adminService.listPage(map);
        Integer total = adminService.totalPage(pageMap);
       model.put("total",total);
        model.put("rows",adminList);

        return model;
    }


}
