package com.dailtcodebuffer.userservice.service;

import com.dailtcodebuffer.userservice.VO.Department;
import com.dailtcodebuffer.userservice.VO.ResponseTemplateVO;
import com.dailtcodebuffer.userservice.client.RestClient;
import com.dailtcodebuffer.userservice.entity.User;
import com.dailtcodebuffer.userservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestClient restClient;

    public User saveuser(User user) {
        log.info("Inside User saving method of User service");
        log.info("user info " +user.toString());
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment( Long userId )
    {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        //another way of rest client to invoke other micro service (through exchange method)
        //Department department = restTemplate.getDepartment(userId);
        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
