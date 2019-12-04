package com.multi;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/1 21:57
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient // 与@EnableDiscoveryClient作用类似，可以不加
@MapperScan("com.multi.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
