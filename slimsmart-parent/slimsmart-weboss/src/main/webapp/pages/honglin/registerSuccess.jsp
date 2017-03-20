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
    <title>用钱宝</title>
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
        button[type="button"]{
            background-color: #38a0ef;
            height: 45px;
            line-height: 45px;
            color: #ffffff;
            border: none;
            width: 70%;
            font-weight: bold;
            font-size: 18px;
        }
    </style>
</head>
<body style="text-align: center">
    <img src="<%=contextPath%>/pages/honglin/css/about_3.png" alt="" width="100%" height="220px"/>
    <img src="<%=contextPath%>/pages/honglin/css/add_05.png" alt="" width="80px" style="margin: 20px 0 10px;"/>
    <div style="text-align: center;color: #55aa11; padding: 0 10px; margin-bottom: 20px">
        恭喜您注册成功
    </div>
    <div style="padding: 0 10px;margin-bottom: 40px">
        <p style="font-size: 12px;text-align: center;line-height: 20px;margin-bottom: 5px">立即下载APP，一键申请体现吧！</p>
        <button type="button">下载提现</button>
    </div>
    <div style="padding: 0 10px;text-align: center;">
        |&nbsp;&nbsp;<span>钱箱</span>&nbsp;&nbsp;|
        <p style="font-size: 12px;text-align: center;margin-top: 5px">XXXX有限公司/京ICP备XXXXXX号</p>
    </div>
</body>
</html>