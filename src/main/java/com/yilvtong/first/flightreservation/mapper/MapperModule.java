package com.yilvtong.first.flightreservation.mapper;

import java.util.List;

public interface MapperModule<E> {


    E getById(int id);
    List<E> getAll();//默认最多获取100条
    void delById(int id);
    void updataById(E e);
    void add(E e);


}
