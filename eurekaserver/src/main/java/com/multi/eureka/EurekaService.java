package com.multi.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/2 15:24
 * @description:
 */
@SpringBootApplication
@EnableEurekaServer // 开启Eureka服务
public class EurekaService {
    public static void main(String[] args) {
        SpringApplication.run(EurekaService.class, args);
    }
}
