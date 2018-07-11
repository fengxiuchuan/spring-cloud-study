package timer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * * 同时打开eureka-server eureka-client eureka-client2 eureka-client3,启动本服务，
 * 浏览器输入 http://localhost:port/consumer,看访问的那个服务方
 * @Author: Administrator
 * @Date : 2018/7/11 13 48
 */
@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping(value = "/consumer")
    public String consumer(){
        return consumerService.consumer();
    }

    @Component
    class ConsumerService{

        @Autowired
        private RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer(){
            return restTemplate.getForObject("http://eureka-client/hello",String.class);
        }
        //当服务端超时，调用方法
        public String  fallback(){
            return "fallback";
        }
    }
}
