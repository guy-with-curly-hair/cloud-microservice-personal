package com.dailycodebuffer.departmentservice.controller;


import com.dailycodebuffer.departmentservice.entity.Department;
import com.dailycodebuffer.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("inside department controller for saving the department information");

        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    private Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("inside department controller for sgetting department by ID");
        return departmentService.findDepartmentById(departmentId);
    }
}
