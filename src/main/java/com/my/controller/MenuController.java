package com.my.controller;

import com.my.domain.Sysmenu;
import com.my.service.SysmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wanwan on 16/9/7.
 */
@RequestMapping("/menu")
@Controller
public class MenuController {

    @Autowired
    private SysmenuService sysmenuService;
    @ResponseBody
    @RequestMapping("/list")
    public List list(int parentId){
        List list = sysmenuService.selectMenuList(parentId);
        return list;
    }
}
