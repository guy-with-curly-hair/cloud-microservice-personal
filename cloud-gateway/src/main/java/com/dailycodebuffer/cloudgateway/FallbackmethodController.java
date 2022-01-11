package com.dailycodebuffer.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackmethodController {

    @GetMapping("/userServiceFallbackMethod")
    public String userServiceFallbackMethod()
    {
        return "User service is not available please try again";
    }
    @GetMapping("/deptServiceFallbackMethod")
    public String deptServiceFallbackMethod()
    {
        return "Department service is not available please try again";
    }
}
