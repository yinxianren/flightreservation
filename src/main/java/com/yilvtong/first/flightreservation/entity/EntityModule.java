package com.yilvtong.first.flightreservation.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class EntityModule {

    private int id;
    private int isDelete;//是否已经删除，1表示存在，0表示已经删除
    private String createDate;
    private String update;
}
