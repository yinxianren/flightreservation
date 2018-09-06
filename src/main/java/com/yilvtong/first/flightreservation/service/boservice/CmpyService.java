package com.yilvtong.first.flightreservation.service.boservice;


import com.yilvtong.first.flightreservation.bo.Cmpy;
import com.yilvtong.first.flightreservation.mapper.boMapper.CmpyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmpyService {

   @Autowired
   private CmpyMapper cmpyMapper;


   public List<Cmpy> getAllCompany(){
       try {
           List<Cmpy> cmpyList= cmpyMapper.getAll();
           return cmpyList;
       }catch(Exception e){
           e.printStackTrace();
           return null;
       }
   }

}
