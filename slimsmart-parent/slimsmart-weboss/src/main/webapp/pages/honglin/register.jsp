<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <script type="text/javascript" src="<%=contextPath%>/pages/honglin/js/jquery-1.11.3.js"></script>
    <script type="text/javascript"> 
    	var baseUrl = "<%=contextPath%>";
    </script>
    <title>钱箱</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            list-style: none;
        }
        body{
            font-size: 14px;
            font-family: "Microsoft Yahei",Arial,sans-serif;
            color: #333;
        }
        .form input[type="submit"]{
            background-color: #38a0ef;
            height: 45px;
            line-height: 45px;
            color: #ffffff;
            border: none;
            width: 70%;
            font-weight: bold;
            font-size: 18px;
        }
        .form{
            text-align: center;
        }
        .form input{
            height: 40px;
            width: 90%;
            margin-top: 10px;
            border: 1px solid #eeeef1;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border-radius: 2px;
            padding-left: 10px;
        }
    </style>
</head>
<body style="text-align: center">
    <img src="<%=contextPath%>/pages/honglin/css/about_3.png" alt="" width="100%" height="220px"/>
    <form action="<%=contextPath%>/loan/registerSuccess.do" style="padding: 0 5%px;" class="form">
        <input type="number" placeholder="请输入手机号码" pattern="/^1[34578]\d{9}$/" name="userPhone"/>
        <!-- <input type="number" placeholder="输入验证码" style="width: 60%;" name="code"/><input type="button" name="sendCode" style="width:30%;background: #38a0ef;border: 1px solid #38a0ef;color:#fff;" value="发送验证码"/> -->
        <input type="text" placeholder="输入密码" name="password"/>
        <p  style="font-size: 12px;text-align: left;line-height: 15px;margin-top: 5px;margin-left: 5%;color: #dddddd;">密码请使用6位以上，数字、字母、符号的组合</p>
        <div style="margin: 20px 0">
            <input type="submit" value="领取现款" id="submit"/>
        </div>
    </form>
    <div style="padding: 0 10px;text-align: center;">
        |&nbsp;&nbsp;<span>钱箱</span>&nbsp;&nbsp;|
        <p style="font-size: 12px;text-align: center;margin-top: 5px">XXXX有限公司/京ICP备XXXXXX号</p>
    </div>
    <script>
        $('input[name="sendCode"]').bind('click',function(){
            var _this = this;
            var time=5;
            var timer=window.setInterval(function(){
                time--;
                $(_this).val(time+'s');
                $(_this).attr('disabled',true).css('background','#ddd').css('border','none');
                if(time==0){
                    clearInterval(timer);
                    $(_this).css('background','#38a0ef').removeAttr('disabled').css('border','1px solid #38a0ef');
                    $(_this).val('重新发送');
                }
            },1000);
        });
        
        $("#submit").on('click',function(){
        	window.location.href=baseUrl+"/loan/registerSuccess.do";
        });
    </script>
</body>
</html>