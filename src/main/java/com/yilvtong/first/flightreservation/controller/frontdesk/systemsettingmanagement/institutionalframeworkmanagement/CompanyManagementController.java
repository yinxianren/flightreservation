package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.yilvtong.first.flightreservation.entity.frontdesk.Company;
import com.yilvtong.first.flightreservation.service.frontdesk.CompanyService;
import com.yilvtong.first.flightreservation.tool.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/body")
public class CompanyManagementController {

    @Autowired
    private CompanyService companyService;


    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management")
    public String pageJump(Map<Object,Object> map) {
        List<Company> companyList=companyService.getAll();
        map.put("companyList",companyList);

        return "/frontdesk/body/systemSettingManagement/ifm_company_management";

    }





    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/get")
    public Company getByIdController(int id) {
        Company company= (Company) companyService.getById(id);
        if(null==company){
            return null;
        }
        return company;
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/getAll")
    public List<Company> getAllController() {
        List<Company> companyList=companyService.getAll();
        if(null==companyList){
            return null;
        }
        return companyList;
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/del")
    public boolean delByIdController(int id) {

        boolean isTrue=companyService.delById(id);
        if(isTrue){
            return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/upData")
    public boolean updataByIdController( Company company) {
        company.setUpdate(DateTimeUtils.getCurrentDateTimeStr2());
        boolean isTrue=companyService.updataById(company);
        if(isTrue){
            return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/add")
    public boolean addController(Company company) {

        String time= DateTimeUtils.getCurrentDateTimeStr2();
        company.setUpdate(time);
        company.setCreateDate(time);
        boolean isTrue=companyService.add(company);
        if(isTrue){
            return true;
        }
        return false;
    }
}
