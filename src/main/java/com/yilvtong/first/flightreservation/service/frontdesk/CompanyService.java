package com.yilvtong.first.flightreservation.service.frontdesk;

import com.yilvtong.first.flightreservation.mapper.frontdesk.CompanyMapper;
import com.yilvtong.first.flightreservation.service.ServiceModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService<Company> implements ServiceModule<Company> {

    @Autowired
    private CompanyMapper companyMapper;

    /**
     *  根据id 获取公司信息
     * @param id
     * @return
     */
    @Override
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
    @Override
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
    @Override
    public boolean updataByIdService(Company com) {

        try{
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
    @Override
    public boolean addService(Company com) {

        try{
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
    @Override
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
