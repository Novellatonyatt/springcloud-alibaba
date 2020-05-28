package com.novellatonyatt.service;

import org.springframework.stereotype.Component;

/**
 * @author: Zhuang HaoTang
 * @create: 2020-05-27 21:09
 * @description:
 */
@Component
public class HiApiFallback implements HiApi {
    @Override
    public String hi(String name) {
        return name + "你被降级了";
    }
}
