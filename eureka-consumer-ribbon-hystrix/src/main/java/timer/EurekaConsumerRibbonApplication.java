package timer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * 功能描述: ribbon负载
 *
 * @param:
 * @return: 
 * @auther: Administrator
 * @date: 2018/7/11 14:43
 */
//使用@EnableCircuitBreaker 或者 @EnableHystrix 开启Hystrix的使用：
/*@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication*/
//可以使用SpringCloudApplication注解，里面包含SpringBootApplication  EnableDiscoveryClient  EnableCircuitBreaker
@SpringCloudApplication
public class EurekaConsumerRibbonApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaConsumerRibbonApplication.class).web(true).run(args);
	}
}
