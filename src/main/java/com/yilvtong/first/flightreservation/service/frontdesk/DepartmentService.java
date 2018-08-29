package com.yilvtong.first.flightreservation.service.frontdesk;


import com.yilvtong.first.flightreservation.entity.frontdesk.Department;
import com.yilvtong.first.flightreservation.mapper.frontdesk.DepartmentMapper;
import com.yilvtong.first.flightreservation.tool.VeDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     *   服务中转，根据id获取部门信息
     * @param id
     * @return
     */
    public Department getDepartmentById(int id){
        try{

            Department department=departmentMapper.getDepartmentById(id);
            return department;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  sql 设置值获取100条记录
     * @return
     */
    public List<Department>  getAllDepartment(){

        try{
            List<Department> departmentList=departmentMapper.getAllDepartment();
            return departmentList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



    /**
     *   根据 Department 相关信息添加部门
     * @param dep
     * @return
     */
    public  boolean addDepartment(Department dep){
        try {
            dep.setCreateDate(VeDate.getNowDate());
            departmentMapper.addDepartment(dep);
          return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  根据部门id 删除部门
     * @param id
     * @return
     */
    public  boolean delDepartmentById(int id){

        try{
            departmentMapper.delDepartmentById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


    /**
     *   根据部门id 更新 指定的信息
     * @param dep
     * @return
     */
    public boolean updateDepartmentById(Department dep){

        try{

            dep.setUpdate(VeDate.getNowDate());
            departmentMapper.updateDepartmentById(dep);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
