package org.timer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/7/6 10 59
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "client1 -- hello";
    }
}
