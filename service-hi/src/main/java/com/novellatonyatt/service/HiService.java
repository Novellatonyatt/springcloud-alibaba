package com.novellatonyatt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Zhuang HaoTang
 * @create: 2020-05-28 14:33
 * @description:
 */
@Service
@RefreshScope
public class HiService {

    @Value("${server.port}")
    private String port;

    @Value("${username:default}")
    private String username;

    @Value("${password:default}")
    private String password;

    public Map<String,Object> getConfig(){
        Map<String, Object> config = new HashMap<>();
        config.put("port", port);
        config.put("username", username);
        config.put("password", password);
        return config;
    }
}
