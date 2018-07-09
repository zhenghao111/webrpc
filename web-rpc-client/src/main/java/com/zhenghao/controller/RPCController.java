package com.zhenghao.controller;

import com.zhenghao.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spitter")
public class RPCController {

    @Autowired
    private SpitterService spitterService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String processGetAll() {
        // 调用远程服务器的方法
        System.out.println("调用远程服务器的方法");
        spitterService.getAllSpitters();

        return "home";
    }


}
