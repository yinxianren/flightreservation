package com.yilvtong.first.flightreservation.entity.frontdesk;

import com.yilvtong.first.flightreservation.entity.EntityModule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Company  extends EntityModule{

    private String companyName; //公司名称
    private String companyShareName; //公司简称
    private String registeredAddress;//注册地址
    private String businessLicense;//营业执照号
    private String legalRepresentative;//法定代表人
    private String legalRepresentativeIdNum;//法定代表人身份证号码
    private String industryType;//行业类型
    private String businessScope;//经营范围
    private String webAddr;//网址
    private String ipcNum;//ipc备案号

    private String bankAccountName;//银行开户名
    private String bankNum;//卡号
    private String bankName;//开户银行




}
