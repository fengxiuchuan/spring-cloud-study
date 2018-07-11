package org.timer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/7/11 14 59
 */
//使用FeignClient注解指定要调用的服务名称
@FeignClient(value = "eureka-client")
public interface UserConsomerService {

    @GetMapping(value = "/hello")
    String hello();
}
