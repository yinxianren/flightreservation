package com.yilvtong.first.flightreservation.service;

import java.util.List;

public interface ServiceModule<T> {


    T getById(int id);
    List<T> getAll();//默认最多获取100条
    boolean delById(int id);
    boolean updataById(T t);
    boolean add(T t);


}
