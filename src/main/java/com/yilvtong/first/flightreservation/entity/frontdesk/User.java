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

    private String name;
    private String password;
    private String sex;
    private String idNum;
    private String censusRegister;//户籍
    private String addr;//目前居住地址
    private String company;//公司
    private String department;//部门
    private String phone;
    private String time;//入职时间
    private String type;//用户类型
    private String description;//备注


}
