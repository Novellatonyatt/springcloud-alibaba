package com.novellatonyatt.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.novellatonyatt.service.HiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Zhuang HaoTang
 * @create: 2020-05-26 18:16
 * @description:
 */
@RestController
public class GreetController {

    @Autowired
    private HiApi hiApi;

    @GetMapping("greet")
    @SentinelResource(value = "greetSen",blockHandler = "handlerException")
    public String greet(String name){
        return hiApi.hi(name);
    }

    public String handlerException(String name , BlockException exception){
        return name+"你被限流了";
    }
}
