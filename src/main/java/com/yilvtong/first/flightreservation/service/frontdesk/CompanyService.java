package com.yilvtong.first.flightreservation.service.frontdesk;

import com.yilvtong.first.flightreservation.mapper.frontdesk.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService<Company> extends ServiceParent<Company>{

    private CompanyMapper companyMapper;

    @Autowired
    public CompanyService(CompanyMapper companyMapper){
       super.setMapperModule(companyMapper);
       this.companyMapper=companyMapper;
    }



}
