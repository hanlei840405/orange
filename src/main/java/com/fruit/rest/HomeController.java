package com.fruit.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanlei6 on 16-12-13.
 */
@Slf4j
@RestController
public class HomeController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        log.info("orange,a: {},b: {}", a, b);
        ServiceInstance instance = client.getLocalServiceInstance();

        Integer r = a + b;
        return r;
    }

    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public String print(String payload) {
        log.info("orange,payload: {}", payload);
        ServiceInstance instance = client.getLocalServiceInstance();

        return "hello : " + payload;
    }
}
