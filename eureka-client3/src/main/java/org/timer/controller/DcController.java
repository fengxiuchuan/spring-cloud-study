package org.timer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/7/6 10 53
 */
@RestController
public class DcController {

    @GetMapping("/dc")
    public String dc(){
        return "dd";
    }
}
