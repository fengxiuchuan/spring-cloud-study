package org.timer;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
//EnableFeignClients 注解开启扫描Spring Cloud Feign客户端的功能：
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerFeignApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaConsumerFeignApplication.class).web(WebApplicationType.SERVLET).run(args);
	}
}
