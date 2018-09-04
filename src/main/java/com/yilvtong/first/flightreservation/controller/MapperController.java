package com.yilvtong.first.flightreservation.controller;

import java.util.List;

public interface MapperController {


    Object getByIdController(int id);
    List<Object> getAllController();//默认最多获取100条
    boolean delByIdController(int id);
    boolean updataByIdController(Object obj);
    boolean addController(Object obj);


}
