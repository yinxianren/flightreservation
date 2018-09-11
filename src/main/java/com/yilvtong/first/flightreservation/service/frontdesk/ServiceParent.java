package com.yilvtong.first.flightreservation.service.frontdesk;

import com.yilvtong.first.flightreservation.mapper.MapperModule;
import com.yilvtong.first.flightreservation.service.ServiceModule;

import java.util.List;


public abstract class  ServiceParent<T> implements ServiceModule<T> {

    private  MapperModule mm;

    public void setMapperModule(MapperModule mm){
        this.mm=mm;
    }

    public MapperModule getMapperModule(){
        if(null==mm){
            throw new NullPointerException("MapperModule 对象为null");
        }
        return this.mm;
    }


    @Override
    public  T getById(int id){
        try{
            T t= (T) mm.getById(id);
            return t;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> getAll(){
        try {
            List<T> tList = mm.getAll();
            return tList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  返回true 并不代表删除了一条数据，如果id不存在，则没有删除动作
     * @param id
     * @return
     */
    @Override
    public boolean delById(int id){
        try {
            mm.delById(id);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean updataById(T t){
        try {
            mm.updataById(t);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean add(T t){
        try {
            mm.add(t);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
