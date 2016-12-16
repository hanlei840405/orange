package com.fruit.rest;

import com.fruit.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by hanlei6 on 16-12-13.
 */
@Slf4j
@RestController
@RequestMapping("/api")
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

    @RequestMapping(value = "/user/username/{username}", method = RequestMethod.GET)
    public User username(@PathVariable("username") String username) {
        User user = new User();
        user.setUsername(username);
        user.setRealName("Jesse.Han");
        user.setAge(32);
        user.setBirthday(new Date());
        user.add(linkTo(methodOn(HomeController.class).username(username)).withSelfRel());
        return user;
    }

    @RequestMapping(value = "/user/age/{age}", method = RequestMethod.GET)
    public List<User> age(@PathVariable("age") int age) {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= age; i++) {
            User user = new User();
            user.setUsername("HanLei" + i);
            user.setRealName("Jesse." + i + ".Han");
            user.setAge(i);
            user.setBirthday(new Date());
            user.add(linkTo(methodOn(HomeController.class).username(user.getUsername())).withSelfRel());
            users.add(user);
        }
        return users;
    }
}
