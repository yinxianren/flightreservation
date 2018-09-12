package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.yilvtong.first.flightreservation.controller.ReturnResult;
import com.yilvtong.first.flightreservation.entity.frontdesk.Company;
import com.yilvtong.first.flightreservation.service.boservice.CmpyService;
import com.yilvtong.first.flightreservation.service.frontdesk.CompanyService;
import com.yilvtong.first.flightreservation.tool.DateTimeUtils;
import com.yilvtong.first.flightreservation.tool.StatusCode;
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
    @Autowired
    private CmpyService cmpyService;

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
    public ReturnResult delByIdController(int id) {

        ReturnResult rr=new ReturnResult();
        int num=cmpyService.countCmpAndDep(id);
        rr.setCode(StatusCode.INTERNAL_ERROR_500_100.getCode());
        rr.setStatus(StatusCode.SUCCESS.getMsg());
        if(num>0){
            rr.setMessage("该公司目前还有"+num+"个相关部门依赖此公司！");
            return  rr;
        }


        boolean isTrue=companyService.delById(id);
        if(isTrue){
            rr.setCode(StatusCode.SUCCESS.getCode());
            rr.setStatus(StatusCode.SUCCESS.getMsg());
            rr.setMessage("删除成功！");
            return  rr;
        }
        return  rr;
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/upData")
    public ReturnResult updataByIdController( Company company) {

        ReturnResult rr=new ReturnResult();
        company.setUpdate(DateTimeUtils.getCurrentDateTimeStr2());
        boolean isTrue=companyService.updataById(company);
        if(isTrue){
            rr.setCode(StatusCode.SUCCESS.getCode());
            rr.setStatus(StatusCode.SUCCESS.getMsg());
            return  rr;
        }else{
            rr.setCode(StatusCode.INTERNAL_ERROR_500_100.getCode());
            rr.setStatus(StatusCode.INTERNAL_ERROR_500_100.getMsg());
            return  rr;
        }
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management/add")
    public ReturnResult addController(Company company) {
        ReturnResult rr=new ReturnResult();
        String time= DateTimeUtils.getCurrentDateTimeStr2();
        company.setUpdate(time);
        company.setCreateDate(time);
        boolean isTrue=companyService.add(company);
        if(isTrue){
            rr.setCode(StatusCode.SUCCESS.getCode());
            rr.setStatus(StatusCode.SUCCESS.getMsg());
            return  rr;
        }
        rr.setCode(StatusCode.INTERNAL_ERROR_500_100.getCode());
        rr.setStatus(StatusCode.INTERNAL_ERROR_500_100.getMsg());
        return  rr;
    }
}
