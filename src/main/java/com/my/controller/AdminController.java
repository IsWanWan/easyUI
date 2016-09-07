package com.my.controller;

import com.my.common.JsonView;
import com.my.common.MyCache;
import com.my.domain.Admin;
import com.my.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
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
    @Autowired
    private CacheManager cacheManager;


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

    /**
     * 查询 admin
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getById")
    public JsonView getById(int id){
     if(cacheManager.getCache("myCache").get("admin"+id) != null){
         Admin adminTwo = (Admin) cacheManager.getCache("myCache").get("admin"+id).get();
         System.out.println(" service取得admin 缓存 :"+adminTwo.getUsername());
     }

         Admin admin = adminService.selectByPrimaryKey(id);

//        Cache cache = cacheManager.getCache("myCache");
//        cache.put("test","00001");
//        System.out.println(" 取得test 缓存 :"+cache.get("test").get().toString());
//
//        cache.put("admin",admin);
//       Admin adminOne = (Admin) cache.get("admin").get();
//        System.out.println(" 取得admin 缓存 :"+adminOne.getUsername());

        return new JsonView(200,"查询成功",admin);
    }

    /***
     * 修改
     * @param admin
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateAdmin")
    public JsonView  updateAdmin(Admin admin){
        int n = adminService.updateByPrimaryKeySelective(admin);
        if(n == 1){
            return new JsonView(200,"修改成功");
        }else{
            return new JsonView(500,"修改失败");
        }

    }

    /***
     * 添加用户
     * @param admin
     * @return
     */
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

    /**
     * 测试事务
     * @return
     */
    @ResponseBody
    @RequestMapping("/testTran")
    public JsonView testTran(){
        int n = adminService.insertTrans();
        if(n == 1){
            return new JsonView(200,"添加成功");
        }else{
            return new JsonView(500,"添加失败");
        }
    }
}
