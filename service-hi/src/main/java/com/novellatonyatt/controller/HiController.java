package com.novellatonyatt.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.novellatonyatt.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: Zhuang HaoTang
 * @create: 2020-05-26 17:43
 * @description:
 */
@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @GetMapping("hi")
    @SentinelResource(value = "hiSentinel", blockHandler = "blockHandler", fallback = "fallbackHandler")
    public String hi(String name) throws InterruptedException {
//        throw new RuntimeException();
        Thread.sleep(100);
        return String.format("welcome %s!", name);
    }

    @GetMapping("getConfig")
    public Map<String, Object> getConfig() throws InterruptedException {
        Thread.sleep(100);
        return hiService.getConfig();
    }

    public String blockHandler(String name, BlockException exception) {
        return name + "你被限流了";
    }

    public String fallbackHandler(String name) {
        return name + "你被降级了";
    }

}
