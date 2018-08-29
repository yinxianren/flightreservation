package com.yilvtong.first.flightreservation.mapper.frontdesk;


import com.yilvtong.first.flightreservation.entity.frontdesk.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {

    /**
     *  根据部门id 获取部门信息
     * @param id
     * @return
     */
    Department getDepartmentById(int id);


    /**
     *  sql 设置默认最多获取100条
     * @return
     */
    List<Department> getAllDepartment();

    /**
     *  根据部门名查找详细信息
     * @param name
     * @return
     */
//     Department getDepartmentByName(String name);

    /**
     * 根据page一般规则获取数据
     * @return
     */
//     List<Department> getDepartmentByPage(Page page);


    /**
     * 根据 Departmente一般规则获取数据
     * @return
     */
//    List<Department> getDepartmentByDepartment(Department dep);

    /**
     *  添加一个部门
     * @param dep
     */
    void addDepartment(Department dep);


    /**
     *  根据部门名字删除该部门
     * @param name
     */
//    void delDepartmentByName(String name);

    /**
     *  根据部门id 删除该部门
     * @param id
     */
    void delDepartmentById(int id);


    /**
     * 根据id 更新部门，同时判断Department相关属性进行更新
     * @param Department
     */
    void updateDepartmentById(Department dep);

}
