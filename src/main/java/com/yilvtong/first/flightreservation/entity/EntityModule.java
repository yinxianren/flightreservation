package com.yilvtong.first.flightreservation.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Setter
@Getter
public class EntityModule {

    private int id;
    private Date createDate;
    private Date update;
}
