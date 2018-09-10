package com.yilvtong.first.flightreservation.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ReturnResult<T>{

   private T t;
   private List<T> list;
   private Map<String,T> map;
   private String status;
   private int code;
   private String Message;
   private String title;
}
