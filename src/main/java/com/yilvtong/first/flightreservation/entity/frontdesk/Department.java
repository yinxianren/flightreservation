package com.yilvtong.first.flightreservation.entity.frontdesk;

import com.yilvtong.first.flightreservation.entity.EntityModule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Department extends EntityModule {
    private String depCompany;//所属公司
    private String depName;//部门名
    private String depPricipal;//部门负责人
    private String depAbbreviation;//部门简称
    private String depAddr;//部门地址
    private String depPhone;//部门电话
    private String description;//描述

}
