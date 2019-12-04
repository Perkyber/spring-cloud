package com.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/2 9:22
 * @description:
 */
//@SpringBootApplication
//@EnableDiscoveryClient(autoRegister = true) // 与@EnableEurekaClient作用类似，可以不加，autoRegister默认为true
//@EnableCircuitBreaker // hystrix注解
@SpringCloudApplication // 以上三个注解都不用写
@EnableFeignClients // 开启Feign
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced // 负载均衡注解，eureka集成了ribbon
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
