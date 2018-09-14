package com.yilvtong.first.flightreservation.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Page<E> {


    private E obj;
    private List<E> list;
    private Map<String,E> map;
    private String status;
    private int currentPage;  //当前页
    private int totalPage;   //合计
    private String Message;
    private String title;


}
