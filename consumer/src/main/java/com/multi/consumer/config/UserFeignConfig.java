package com.multi.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static feign.Logger.Level;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/4 19:10
 * @description:
 */
@Configuration
public class UserFeignConfig {
    @Bean
    Level feignLogging() {
        return Level.FULL;
    }
}
