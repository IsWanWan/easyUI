package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wanwan on 16/8/28.
 */
@RequestMapping("/index")
@Controller
public class IndexController {
    @ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/test");
    }

    @ResponseBody
    @RequestMapping("/layout")
    public ModelAndView layout(){
        return new ModelAndView("/layout");
    }
}
