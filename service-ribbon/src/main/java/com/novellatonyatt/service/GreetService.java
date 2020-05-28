package com.novellatonyatt.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Zhuang HaoTang
 * @create: 2020-05-26 17:54
 * @description:
 */
@Service
public class GreetService {

    @Autowired
    private RestTemplate restTemplate;

    @SentinelResource(value = "greetSen", blockHandler = "handlerException1", fallback = "handlerException2")
    public String greet(String name) {
        return restTemplate.getForObject("http://service-hi/hi?name={name}", String.class, name);
    }

    public String handlerException1(String name, BlockException exception) {
        return name + "你被限流了";
    }

    public String handlerException2(String name) {
        return name + "你被降级了";
    }

}
