<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>好借好还-海量借款任你选</title>

  <!-- Set render engine for 360 browser -->
  <meta name="renderer" content="webkit">

  <!-- No Baidu Siteapp-->
  <meta http-equiv="Cache-Control" content="no-siteapp"/>

  <link rel="icon" type="image/png" href="<%=contextPath%>/pages/honglinv2/assets/i/favicon.png">

  <!-- Add to homescreen for Chrome on Android -->
  <meta name="mobile-web-app-capable" content="yes">
  <link rel="icon" sizes="192x192" href="<%=contextPath%>/pages/honglinv2/assets/i/app-icon72x72@2x.png">

  <!-- Add to homescreen for Safari on iOS -->
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
  <link rel="apple-touch-icon-precomposed" href="<%=contextPath%>/pages/honglinv2/assets/i/app-icon72x72@2x.png">

  <!-- Tile icon for Win8 (144x144 + tile color) -->
  <meta name="msapplication-TileImage" content="<%=contextPath%>/pages/honglinv2/assets/i/app-icon72x72@2x.png">
  <meta name="msapplication-TileColor" content="#0e90d2">

  <link rel="stylesheet" href="<%=contextPath%>/pages/honglinv2/assets/css/amazeui.css">
  <link rel="stylesheet" href="<%=contextPath%>/pages/honglinv2/assets/css/app.css">
  <script type="text/javascript" src="<%=contextPath%>/pages/honglin/js/vue.js"></script>
  <script type="text/javascript"> 
   	var baseUrl = "<%=contextPath%>";
   </script>
</head>
<body>

<!--<header data-am-widget="header" style="background-color:#FFFFFF"
        class="am-header am-header-default">
    <!-- <div class="am-header-left am-header-nav">
        <a href="#left-link" class="">
    
              <i class="am-header-icon am-icon-home"></i>
        </a>
    </div> -->

    <!--<h1 class="am-header-title" >
        <a href="#title-link" style="color:black">
          好借好还
        </a>
    </h1>-->

    <!-- <div class="am-header-right am-header-nav">
        <a href="#right-link" class="">
    
              <i class="am-header-icon am-icon-bars"></i>
        </a>
    </div> -->
<!--</header>-->


<div data-am-widget="slider" class="am-slider am-slider-default swiper-Imgs" data-am-slider='{}' >
  <ul class="am-slides">
      <li >
          <img src="<%=contextPath%>/pages/honglinv2/assets/i/header1.jpg">
         
      </li>
      
  </ul>
</div>
<div class="info-Title">
    <marquee behavior="scroll">梁**成功借贷3000元</marquee>
</div>
<div data-am-widget="tabs"
     class="am-tabs am-tabs-d2"
      >
    <ul class="am-tabs-nav am-cf">
        <li class="am-active"><a class="tabColor" href="[data-tab-panel-0]">短期速借</a></li>
        <li class=""><a class="tabColor" href="[data-tab-panel-1]">小额贷款</a></li>
        <li class=""><a class="tabColor" href="[data-tab-panel-2]">大额贷款</a></li>
    </ul>
</div>


<div id="app" data-am-widget="list_news" class="am-list-news am-list-news-default" >
  <div class="am-list-news-bd">
    <ul class="am-list" v-for="item in listData">
     <!--缩略图在标题左边-->
      <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
        <div class="am-u-sm-4 am-list-thumb">
          <a href="http://www.douban.com/online/11614662/" class="">
            <img v-bind:src="item.logoUrl" alt=""/>
          </a>
        </div>

        <div class=" am-u-sm-8 am-list-main">
            <a href="#" class="tag">{{item.applyNum}}人已申请</a>
            <h2 class="am-list-item-hd"><a v-bind:href="item.tapUrl">{{item.name}} </a></h2>
            <div class="am-list-item-text" style="margin-top:10px;color:#bfbfbf;">{{item.description}}</div>
        </div>
      </li>
      
    </ul>
  </div>
</div>

<figure data-am-widget="figure" class="am am-figure am-figure-default "   data-am-figure="{  pureview: 'true' }">
    


      <img style="height:150px;width:150px" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493715057654&di=0aefcae205944ab8b5ab4a3d00ef9bac&imgtype=0&src=http%3A%2F%2Fwww.zyue.com%2Fupload%2Faddr%2Fer_20140725105541.png" alt=""/>
          <figcaption class="am-figure-capition-btm">
            长按二维码关注微信公众号
          </figcaption>

    
</figure>

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=contextPath%>/pages/honglinv2/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="<%=contextPath%>/pages/honglinv2/assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="<%=contextPath%>/pages/honglinv2/assets/js/amazeui.min.js"></script>

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
   	
       
   </script>
</body>
</html>