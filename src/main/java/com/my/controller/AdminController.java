package com.my.controller;

import com.my.common.JsonView;
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

    /***
     * 分页查询
     * @param username
     * @param rows
     * @param page
     * @return
     */

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

    /**
     * 根据主键删除
     * @param adminId
     * @return
     */

    @ResponseBody
    @RequestMapping("/delete")
    public JsonView delete(int adminId){
        int n = adminService.deleteByPrimaryKey(adminId);

        if(n == 1){
            return new JsonView(200,"删除成功");
        }else{
            return new JsonView(500,"删除失败");
        }


    }

    /***
     * 修改
     * @param admin
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateAdmin")
    public JsonView  updateAdmin(Admin admin){
        int n = adminService.insertSelective(admin);
        if(n == 1){
            return new JsonView(200,"修改成功");
        }else{
            return new JsonView(500,"修改失败");
        }

    }
    @ResponseBody
    @RequestMapping("/add")
    public JsonView add(Admin admin){
        int n = adminService.insertSelective(admin);
        if(n == 1){
            return new JsonView(200,"添加成功");
        }else{
            return new JsonView(500,"添加失败");
        }
    }
}
