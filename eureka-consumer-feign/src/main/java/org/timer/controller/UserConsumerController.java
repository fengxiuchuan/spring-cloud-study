package org.timer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.timer.service.UserConsomerService;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/7/11 14 58
 */
@RestController
public class UserConsumerController {


    @Autowired
    private UserConsomerService userConsomerService;

    @GetMapping(value = "/userConsumer")
    public String userConsumer(){
        return userConsomerService.hello();
    }
}
