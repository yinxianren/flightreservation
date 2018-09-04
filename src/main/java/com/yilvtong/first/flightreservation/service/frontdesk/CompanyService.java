package com.yilvtong.first.flightreservation.service.frontdesk;

import com.yilvtong.first.flightreservation.entity.frontdesk.Company;
import com.yilvtong.first.flightreservation.mapper.frontdesk.CompanyMapper;
import com.yilvtong.first.flightreservation.tool.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService{

    @Autowired
    private CompanyMapper companyMapper;

    /**
     *  根据id 获取公司信息
     * @param id
     * @return
     */
    public Company getByIdService(int id){

        try{
            Company company= (Company) companyMapper.getById(id);
            return company;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }


    /**
     *  默认获取100条数据
     * @return
     */
    public List<Company> getAllService() {
        try {
            List<Company> comList = companyMapper.getAll();
            return comList;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  根据id 更新公司信息
     * @param com
     * @return
     */
    public boolean updataByIdService(Company com) {

        try{
            com.setUpdate(DateTimeUtils.getCurrentDateTimeStr2());
            companyMapper.updataById(com);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     *   添加一条公司信息
     * @param com
     * @return
     */
    public boolean addService(Company com) {
            String time=DateTimeUtils.getCurrentDateTimeStr2();
        try{

            com.setUpdate(time);
            com.setCreateDate(time);
            companyMapper.add(com);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }



    /**
     *   根据id 删除公司信息
     * @param id
     * @return
     */
    public boolean delByIdService(int id){

        try{
            companyMapper.delById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }







}
