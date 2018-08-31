package com.yilvtong.first.flightreservation.service;

import java.util.List;

public interface ServiceModule<E> {



    E getByIdService(int id);
    List<E> getAllService();//默认最多获取100条
    boolean delByIdService(int id);
    boolean updataByIdService(E e);
    boolean addService(E e);

}
