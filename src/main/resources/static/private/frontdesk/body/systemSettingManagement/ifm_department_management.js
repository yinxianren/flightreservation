$(function(){


  $("#add_department").click(function(){

      $("#submitButton").empty();
      $("#show_dep").hide();
      $(window).scrollTop(0);
      //输入框清空
      var co=$("#company").val("");
      var na=$("#name").val("");
      var pr=$("#pricipal").val("");
      var ab=$("#abbreviation").val("");
      var ad=$("#addr").val("");
      var ph=$("#phone").val("");
      var de=$("#description").val("");
      $(".widget-title h2").html("新增部门");
      //提示标签清空
      $("#hint_co").html("");
      $("#hint_na").html("");
      $("#hint_pr").html("");
      $("#hint_ab").html("");
      $("#hint_ad").html("");
      $("#hint_ph").html("");
      $("#hint_des").html("");


      $("#submitButton").append(" <button onclick=\"add_return()\"  style=\"margin-right: 20px;\"  type=\"button\" class=\"btn btn-success\">\n" +

          "                                <i class=\" icon-repeat\"></i>\n" +
          "                               返回\n" +
          "                            </button>");


      $("#submitButton").append(" <button onclick=\"add_submit()\"  style=\"margin-right: 25px;\"  type=\"button\" class=\"btn btn-inverse\">\n" +

          "                                <i class=\" icon-save\"></i>\n" +
          "                               提交\n" +
          "                            </button>");
      $("#add_dep").show();
  });





    //所属公司输入框失去焦点事件
    $("#company").focusout(function(){
        var co = $(this).val();
        if(isEmpty(co)){
            $("#hint_co").css("color","red");
            $("#hint_co").html("请输入该部门属哪一子公司或公司");
        }else{
            $("#hint_co").html("");
        }
    });


    //所属部门名称输入框失去焦点事件
    $("#name").focusout(function(){
        var na = $(this).val();
        if(isEmpty(na)){
            $("#hint_na").css("color","red");
            $("#hint_na").html("请输入该部门名称");
        }else{
            $("#hint_na").html("");
        }
    });


    //部门负责人输入框失去焦点事件
    $("#pricipal").focusout(function(){
        var pr = $(this).val();
        if(isEmpty(pr)){
            $("#hint_pr").css("color","red");
            $("#hint_pr").html("请输入该部门负责人");
        }else{
            $("#hint_pr").html("");
        }
    });



    //部门简称输入框失去焦点事件
    $("#abbreviation").focusout(function(){
        var ab = $(this).val();
        if(isEmpty(ab)){
            $("#hint_ab").css("color","red");
            $("#hint_ab").html("请输入该部门简称");
        }else{
            $("#hint_ab").html("");
        }
    });


    //部门地址输入框失去焦点事件
    $("#addr").focusout(function(){
        var ad = $(this).val();
        if(isEmpty(ad)){
            $("#hint_ad").css("color","red");
            $("#hint_ad").html("请输入部门所在地理位置");
        }else{
            $("#hint_ad").html("");
        }
    });


    //部门联系电话输入框失去焦点事件
    $("#phone").focusout(function(){
        var ph = $(this).val();
        if(isEmpty(ph)){
            $("#hint_ph").css("color","red");
            $("#hint_ph").html("请输入部门联系电话或负责人联系电话");
        }else{
            $("#hint_ph").html("");
        }
    });


    //备注输入框失去焦点事件
    $("#description").focusout(function(){
        var des = $(this).val();
        if(isEmpty(des)){
            $("#hint_des").css("color","red");
            $("#hint_des").html("备注一下吧！");
        }else{
            $("#hint_des").html("");
        }
    });



});