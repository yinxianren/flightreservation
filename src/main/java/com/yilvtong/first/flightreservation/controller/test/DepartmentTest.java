package com.yilvtong.first.flightreservation.controller.test;


import com.yilvtong.first.flightreservation.entity.frontdesk.Department;
import com.yilvtong.first.flightreservation.service.frontdesk.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentTest {

    @Autowired
    private DepartmentService departmentService;

    /**
     *    http://localhost:8080/test/getDepartmentById?id=10003
     * @param id
     * @return
     */
    @GetMapping("/test/getDepartmentById")
    public Department getDepartmentById(int id){
        return departmentService.getDepartmentById(id);
    }


    /**
     *   http://localhost:8080/test/getAllDepartment
     * @return
     */
    @GetMapping("/test/getAllDepartment")
    public List<Department> getAllDepartment() {

               return departmentService.getAllDepartment();
    }




}
