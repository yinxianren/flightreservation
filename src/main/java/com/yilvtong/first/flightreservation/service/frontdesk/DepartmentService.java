package com.yilvtong.first.flightreservation.service.frontdesk;


import com.yilvtong.first.flightreservation.mapper.frontdesk.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService<Department> extends ServiceParent<Department>{



    private DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentService(DepartmentMapper departmentMapper){
        super.setMapperModule(departmentMapper);
        this.departmentMapper=departmentMapper;
    }

}
