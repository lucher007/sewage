package com.shenya.sewage.controller;

import com.shenya.sewage.model.User;
import com.shenya.sewage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String index(){
        return "hello";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public User findById(){
        return userService.findById(1);
    }


}
