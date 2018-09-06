package com.yilvtong.first.flightreservation.entity.frontdesk;

import com.yilvtong.first.flightreservation.entity.EntityModule;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@Setter
@Getter
public class User extends EntityModule{

    private String account;
    private String password;
    private String name;
    private String sex;
    private String idNum;
    private String censusRegister;//户籍
    private String addr;//目前居住地址

    private int companyNum;//公司id
    private int departmentNum;//部门id

    private String company;//公司名称
    private String department;//部门名称


    private String phone;
    private String time;//入职时间

    private int type;//用户类型
    private String typeName;//用户类型名称

    private int status;//用户状态 0冻结 1可用
//    private String statusName;//用户状态名称

    private String description;//备注


}
