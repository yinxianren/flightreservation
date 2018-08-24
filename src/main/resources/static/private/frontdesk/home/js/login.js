var image_code=null;
var check_name_input=false;
var check_password_input=false;
var check_imagecode_input=false;
$(function(){

    $("#yzm").val('');
    $("#username").val('');
    $("#password").val('');


    $(".i-text").focus(function(){
        $(this).addClass('h-light');
    });

    $(".i-text").focusout(function(){
        $(this).removeClass('h-light');
    });


    $("#username").focusout(function(){
        var username = $(this).val();
        if(username==''){
            $(".error-box").html('账号不为空');
            check_name_input=false;
            return;
        }
        check_name_input=true;
        $(".error-box").html("");
        return;
    });


    $("#password").focusout(function(){
        var password = $(this).val();
        if(password==''){
            $(".error-box").html('密码不为空');
            check_password_input=false;
            return;
        }
        check_password_input=true;
        $(".error-box").html("");
        return;
    });
    $("#yzm").focusout(function(){
        var verify = $(this).val();
        if(verify==''){
            $(".error-box").html('验证码不为空');
            check_imagecode_input=false;
            return;
        }
        if(verify!=''&&verify.toLowerCase()!=image_code.toLowerCase()){
            $(".error-box").html('验证码不正确');
            check_imagecode_input=false;
            return;
        }
        $(".error-box").html('');
        check_imagecode_input=true;
        return;
    });

    $("#yzm").focus(function(){
        requestToService("/home/imageCode",null);
    });



    $("#send-btn").click(function () {
     if(check_imagecode_input==false||check_name_input==false||check_password_input==false){
         $(".error-box").html('输入有误！');
         return false;
     }


    });


});


function requestToService(url,data){



            $.ajax({
                url : url,
                type: "POST",
                data:data,
                dataType:"json",
                error: function(request) {
                    // alert("Connection error");
                },
                success: function(data) {
                console.info(data);
                if(data.status=="imageCode"){
                    image_code=data.content;
                }
                }
            });


}