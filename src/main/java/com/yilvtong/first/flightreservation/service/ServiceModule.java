package com.yilvtong.first.flightreservation.service;

import java.util.List;

public interface ServiceModule<T> {

    /**
     *   根据id 获取对象
     * @param id
     * @return
     */
    T getById(int id);

    /**
     *  获取所以相关信息，默认最多获取100条
     * @return
     */
    List<T> getAll();

    /**
     *  根据id 删除对应的记录
     * @param id
     * @return
     */
    boolean delById(int id);

    /**
     *   根据参数对象，更新非空字段的信息
     * @param t
     * @return
     */
    boolean updataById(T t);

    /**
     *  根据参数对象，添加非空字段的信息
     * @param t
     * @return
     */
    boolean add(T t);


}
