package com.multi.consumer.web;

import com.multi.consumer.client.UserClient;
import com.multi.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/2 10:38
 * @description:
 */
@RestController
@RequestMapping("consumer")
@Slf4j // 使用log.xxx()需注入
//@DefaultProperties(defaultFallback = "defaultFallBack")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id);
    }

    /**
     *  execution.isolation.thread.timeoutInMilliseconds 超时时间，默认1秒
     *  circuitBreaker.sleepWindowInMilliseconds 休眠时间，默认5秒
     *  circuitBreaker.requestVolumeThreshold 触发熔断最小失败请求数，默认20个
     *  circuitBreaker.errorThresholdPercentage 触发垄断最小失败请求占比，默认50%
     */
/*    @HystrixCommand(fallbackMethod = "queryByIdFallBack"*//*, commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    }*//*)
    // @HystrixCommand
    @GetMapping("{id}")
    public String queryById(@PathVariable("id") Long id) {
        if (id == 1) {
            throw new RuntimeException("太忙了");
        }
        String url = String.format("http://user-service/user/%d", id);
        return restTemplate.getForObject(url, String.class);
    }*/

    // 特定降级逻辑
    public String queryByIdFallBack(Long id) {
        log.error("查询用户信息失败, id：{}", id);
        return "对不起，网络太拥挤了！";
    }

    // 默认降级逻辑
    public String defaultFallBack() {
        return "默认提示：网络拥挤，请稍后重试！";
    }

    /*
        @GetMapping("{id}")
        public User queryById(@PathVariable("id") Long id) {
            // 拉取服务列表
            List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
            // 随机
            int nextInt = new Random().nextInt(instances.size());
            // 随机取服务
            ServiceInstance serviceInstance = instances.get(nextInt);
            String host = serviceInstance.getHost();
            int port = serviceInstance.getPort();
            String url = String.format("http://%s:%d/user/%d", host, port, id);
            return restTemplate.getForObject(url, User.class);
        }
    */
}
