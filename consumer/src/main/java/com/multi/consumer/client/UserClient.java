package com.multi.consumer.client;

import com.multi.consumer.pojo.User;
import org.apache.catalina.startup.UserConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/4 17:23
 * @description:
 */
@FeignClient(name = "user-service",
        fallback = UserFeignClient.class, configuration = UserConfig.class)
public interface UserClient {

    @GetMapping("/user/{id}")
    User queryById(@PathVariable("id") Long id);
}
