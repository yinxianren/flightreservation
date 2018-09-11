package com.yilvtong.first.flightreservation.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String account;
    private String  oldPassword;
    private String  newPassword;
    private String update;

}



