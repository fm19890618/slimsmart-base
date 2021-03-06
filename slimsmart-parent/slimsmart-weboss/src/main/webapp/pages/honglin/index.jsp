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
    <link type="text/css" rel="stylesheet" href="<%=contextPath%>/pages/honglin/css/swiper-3.4.1.min.css">
    <script type="text/javascript" src="<%=contextPath%>/pages/honglin/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/pages/honglin/js/swiper-3.4.1.min.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/pages/honglin/js/vue.js"></script>
    <script type="text/javascript"> 
    	var baseUrl = "<%=contextPath%>";
    </script>
    <title>在线审核 3分钟放款</title>
    <style>
        .swiper-container {
            min-width: 320px;
            height: 240px;
        }
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
        .moveInfo{
            width: 100%;
            height: 45px;
            line-height: 45px;
            padding: 0 10px;
            color: #cc0000;
            font-weight:bold;
            background-color: #f0f1f7;
            border: 1px solid #eeeef1;
        }
        .viewInfos li{
            height: 130px;
            border-bottom: 1px solid #eeeef1;
        }
        .viewInfos li>img{
            margin-top: 20px;
            float: left;
        }
        .viewInfos li>span{
            display: inline-block;
            float: left;
            margin-left: 10px;
            width: 70%;
            margin-top: 20px;
        }
        .viewInfos li>span dt{
            font-size: 16px;color:#1b1b1b;font-weight: bold;line-height: 25px
        }
        .viewInfos li>span dd{
            line-height: 20px;font-size: 12px;color: #dddddd;
        }
        .viewInfos li>span dd>span span{
            color: #cc0000;
        }
    </style>
</head>
<body>
<div id="app">
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide" style="width: 1080px;background-image: url('<%=contextPath%>/pages/honglin/img/banner/banner1.jpg')"></div>
            <div class="swiper-slide" style="width: 1080px;background-image: url('<%=contextPath%>/pages/honglin/img/banner/banner1.jpg')"></div>
            <div class="swiper-slide" style="width: 1080px;background-image: url('<%=contextPath%>/pages/honglin/img/banner/banner1.jpg')"></div>
        </div>
        <!-- 如果需要分页器 -->
        <div class="swiper-pagination"></div>

        <!-- 如果需要导航按钮 -->
    </div>
    <div class="moveInfo"><img src="<%=contextPath%>/pages/honglin/img/jiekuan.png" alt="" width="8%" style="margin-right:3%;vertical-align: middle"/>资料少，审核快，还款灵活</div>
    <div style="padding: 0 10px;">
        <ul class="viewInfos">
            <li v-for="item in listData" v-on:click="greet(item.tapUrl)">
                <img v-bind:src="item.logoUrl"  width="80px"  alt="" />
                <span style="" >
                    <dl>
                        <dt>{{ item.name }}</dt>
                        <dd>借钱0门槛借钱0门槛借钱0门槛借钱0门槛借钱0门槛借钱0门槛</dd>
                        <dd><span>申请人数<span>{{item.applyNum}}</span>人</span><span>&nbsp;<span>{{item.rate}}</span></span></dd>
                    </dl>
                </span>
            </li>
        </ul>
    </div>
</div>    
    <script>
	    var app = new Vue({
    	  el: '#app',
    	  created:function(){
			  var _this = this;    		  
    		  $.ajax({
    			  type: "GET",
    			  url: baseUrl+"/loan/getLoanList.do",
    			  dataType: "json",
    			  success: function(res){
    				  //console.log(_this);
    				 _this.listData = res.result;
    			  }
    		  });
    	  },
    	  data: {
    	    listData: []
    	  },
    	  methods:{
    		  greet: function(url){
    			  window.location.href = url;
    		  }
    	  }
    	})
    	
        var mySwiper = new Swiper ('.swiper-container', {
            direction: 'horizontal',
            loop: true,

            // 如果需要分页器
            pagination: '.swiper-pagination',

            // 如果需要前进后退按钮
            nextButton: '.swiper-button-next',
            prevButton: '.swiper-button-prev'

            // 如果需要滚动条
           //crollbar: '.swiper-scrollbar'
        })
    </script>
</body>
</html>