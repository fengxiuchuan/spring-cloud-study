package org.timer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/7/5 17 31
 */
@RestController
public class HomeController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/home")
    public String home() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services +"fdsfsdffss";
    }
}
