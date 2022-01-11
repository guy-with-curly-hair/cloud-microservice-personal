package com.dailtcodebuffer.userservice.controller;

import com.dailtcodebuffer.userservice.VO.ResponseTemplateVO;
import com.dailtcodebuffer.userservice.entity.User;
import com.dailtcodebuffer.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public User saveUser(@RequestBody User user)
{
    log.info("Inside User saving method of User Controller");
    return userService.saveuser(user);
}

@GetMapping("/{id}")
public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId)
{
    log.info("inside UserController  for  ID  "+userId);
    return userService.getUserWithDepartment(userId);
}

}
