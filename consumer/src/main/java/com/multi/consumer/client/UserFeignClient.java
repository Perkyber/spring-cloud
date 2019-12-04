package com.multi.consumer.client;

import com.multi.consumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/4 18:55
 * @description:
 */
@Component
public class UserFeignClient implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("查询用户信息失败");
        return user;
    }
}
