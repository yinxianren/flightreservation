package com.yilvtong.first.flightreservation.controller.frontdesk.navigationmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/body")
@Controller
public class BusinessManagementController {

    /**
     * 照片管理
     * @return
     */
    //http://localhost:8080/body/busi-manage/photograph-management
    @RequestMapping("/busi-manage/photograph-management")
    public String gotoPhotographManegement(){

        return "/frontdesk/body/businessManagement/photograph-management";
    }


    /**
     *    证照管理
     * @return
     */
    // http://localhost:8080/body/busi-manage/license-management
    @RequestMapping("/busi-manage/license-management")
    public String gotoLicenseManagement(){

        return "/frontdesk/body/businessManagement/license-management";
    }

    /**
     *  签证管理
     * @return
     */
    // http://localhost:8080/body/busi-manage/license-management
    @RequestMapping("/busi-manage/visa-management")
    public String gotoVizaManagement(){

        return "/frontdesk/body/businessManagement/visa-management";
    }

    /**
     *   机票管理
     * @return
     */
    // http://localhost:8080/body/busi-manage/air-ticket-management
    @RequestMapping("/busi-manage/air-ticket-management")
    public String gotoAirTicketManagement(){
        return "/frontdesk/body/businessManagement/air-ticket-management";
    }

    /**
     *  酒店管理
     * @return
     *
     *   http://localhost:8080/body/busi-manage/hotel-management
     */
    @RequestMapping("/busi-manage/hotel-management")
    public String gotoHotelManagement(){

        return"/frontdesk/body/businessManagement/hotel-management";
    }


    /**
     *  自由行管理
     * @return
     *
     *    http://localhost:8080/body/busi-manage/independent-travel-management
     */
    @RequestMapping("/busi-manage/independent-travel-management")
   public String gotoIndependentTravel(){

        return "/frontdesk/body/businessManagement/independent-travel-management";
    }

    /**
     *  台湾自由行管理
     * @return
     *  http://localhost:8080/body/busi-manage/taiwan-independent-travel-management
     */

    @RequestMapping("/busi-manage/taiwan-independent-travel-management")
    public String gotoTaiWanIndenpendentTravel(){

       return "/frontdesk/body/businessManagement/taiwan-independent-travel-management";
    }

    /**
     *   旅游团管理
     * @return
     *
     *   http://localhost:8080/body/busi-manage/tourist-groups-management
     */

    @RequestMapping("/busi-manage/tourist-groups-management")
    public String gotoTouristGroupsManagement(){

        return "/frontdesk/body/businessManagement/tourist-groups-management";
    }

    /**
     *  保险代理管理
     * @return
     *
     *
     *   http://localhost:8080/body/busi-manage/insurance-agency-management
     */

    @RequestMapping("/busi-manage/insurance-agency-management")
   public String gotoInsuranceAgencyManagement(){

        return "/frontdesk/body/businessManagement/insurance-agency-management";
   }


    /**
     *  快递管理
     * @return
     *
     *  http://localhost:8080/body/busi-manage/expressage-management
     */


    @RequestMapping("/busi-manage/expressage-management")
   public String gotoExpressageManagement(){

       return "/frontdesk/body/businessManagement/expressage-management";
   }


    /**
     *
     * @return
     *
     *  http://localhost:8080/body/busi-manage/other-management
     */
    @RequestMapping("/busi-manage/other-management")
    public String gotoOtherManagement(){

       return "/frontdesk/body/businessManagement/other-management";
    }



}
