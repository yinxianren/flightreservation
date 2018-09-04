package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.yilvtong.first.flightreservation.entity.frontdesk.Company;
import com.yilvtong.first.flightreservation.service.frontdesk.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/body")
public class CompanyManagementController {

    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management")
    public String pageJump(Map<Object,Object> map) {
        List<Company> companyList=companyService.getAllService();
        map.put("companyList",companyList);

        return "/frontdesk/body/systemSettingManagement/ifm-company-management";

    }


    @Autowired
    private CompanyService companyService;


    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/get")
    public Company getByIdController(int id) {
        Company company= (Company) companyService.getByIdService(id);
        if(null==company){
            return null;
        }
        return company;
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/getAll")
    public List<Company> getAllController() {
        List<Company> companyList=companyService.getAllService();
        if(null==companyList){
            return null;
        }
        return companyList;
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/del")
    public boolean delByIdController(int id) {
        boolean isTrue=companyService.delByIdService(id);
        if(isTrue){
            return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/upData")
    public boolean updataByIdController( Company company) {

        boolean isTrue=companyService.updataByIdService(company);
        if(isTrue){
            return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/add")
    public boolean addController(Company company) {
        boolean isTrue=companyService.addService(company);
        if(isTrue){
            return true;
        }
        return false;
    }
}
