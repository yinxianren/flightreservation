package com.yilvtong.first.flightreservation.service.boservice;


import com.yilvtong.first.flightreservation.bo.Dep;
import com.yilvtong.first.flightreservation.mapper.boMapper.DapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepService {

   @Autowired
   private DapMapper dapMapper;


   public List<Dep> getAllDepartment(){
       try {
           List<Dep> depList= dapMapper.getAll();
           return depList;
       }catch(Exception e){
           e.printStackTrace();
           return null;
       }
   }


    public List<Dep> getDepByCompany(int id){
        try {
            List<Dep> depList= dapMapper.getDepByCompany(id);
            return depList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
