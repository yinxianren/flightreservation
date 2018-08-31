package com.yilvtong.first.flightreservation.controller;

import java.util.List;

public interface MapperController<E> {


    E getByIdController(int id);
    List<E> getAllController();//默认最多获取100条
    boolean delByIdController(int id);
    boolean updataByIdController(E e);
    boolean addController(E e);


}
