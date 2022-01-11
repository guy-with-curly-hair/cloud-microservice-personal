package com.dailycodebuffer.departmentservice.service;

import com.dailycodebuffer.departmentservice.entity.Department;
import com.dailycodebuffer.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository deptartmentRepo;

    public Department save(Department department) {
        log.info("inside department service for saving the deartment information");

        return deptartmentRepo.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("inside department service finddepartment by Id method");
       return  deptartmentRepo.findByDepartmentId(departmentId);
    }
}
