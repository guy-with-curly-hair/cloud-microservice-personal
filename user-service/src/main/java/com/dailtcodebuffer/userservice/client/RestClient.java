package com.dailtcodebuffer.userservice.client;

import com.dailtcodebuffer.userservice.VO.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    @Autowired
    RestTemplate restTemplate;

    public Department getDepartment(Long userId){
        ResponseEntity<Department> restExchange =
                restTemplate.exchange(
                        "http://DEPARTMENT-SERVICE/departments/{id}",
                        HttpMethod.GET,
                        null, Department.class, userId);

        return restExchange.getBody();
    }
}
