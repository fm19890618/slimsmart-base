<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<link rel="stylesheet" href="../pages/honglin/res/css/weui.css"/>
<link rel="stylesheet" href="../pages/honglin/res/css/weuiexample.css"/>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="../pages/honglin/res/js/zepto.min.js"></script>
<title>在线审核3分钟放款</title>
</head>
<body ontouchstart>

<div class="container" id="container">
	<div class="page home js_show">
	    <div class="page__hd">
	        <h1 class="page__title">
	            <img src="./images/logo.png" alt="WeUI" height="21px">
	        </h1>
	        <p class="page__desc">WeUI 是一套同微信原生视觉体验一致的基础样式库，由微信官方设计团队为微信内网页和微信小程序量身设计，令用户的使用感知更加统一。</p>
	    </div>
	    <div class="page__bd page__bd_spacing">
	        <ul>
	            <li>
	                <div class="weui-flex js_category">
	                    <p class="weui-flex__item">表单</p>
	                    <img src="./images/icon_nav_form.png" alt="">
	                </div>
	            </li>
	            <li>
	                <div class="weui-flex js_category">
	                    <p class="weui-flex__item">基础组件</p>
	                    <img src="./images/icon_nav_layout.png" alt="">
	                </div>
	            </li>
	            <li>
	                <div class="weui-flex js_category">
	                    <p class="weui-flex__item">操作反馈</p>
	                    <img src="./images/icon_nav_feedback.png" alt="">
	                </div>
	                <div class="page__category js_categoryInner">
	                    <div class="weui-cells page__category-content">
	                        <a class="weui-cell weui-cell_access js_item" data-id="actionsheet" href="javascript:;">
	                            <div class="weui-cell__bd">
	                                <p>Actionsheet</p>
	                            </div>
	                            <div class="weui-cell__ft"></div>
	                        </a>
	                        <a class="weui-cell weui-cell_access js_item" data-id="dialog" href="javascript:;">
	                            <div class="weui-cell__bd">
	                                <p>Dialog</p>
	                            </div>
	                            <div class="weui-cell__ft"></div>
	                        </a>
	                        <a class="weui-cell weui-cell_access js_item" data-id="msg" href="javascript:;">
	                            <div class="weui-cell__bd">
	                                <p>Msg</p>
	                            </div>
	                            <div class="weui-cell__ft"></div>
	                        </a>
	                        <a class="weui-cell weui-cell_access js_item" data-id="picker" href="javascript:;">
	                            <div class="weui-cell__bd">
	                                <p>Picker</p>
	                            </div>
	                            <div class="weui-cell__ft"></div>
	                        </a>
	                        <a class="weui-cell weui-cell_access js_item" data-id="toast" href="javascript:;">
	                            <div class="weui-cell__bd">
	                                <p>Toast</p>
	                            </div>
	                            <div class="weui-cell__ft"></div>
	                        </a>
	                    </div>
	                </div>
	            </li>
	            <li>
	                <div class="weui-flex js_category">
	                    <p class="weui-flex__item">导航相关</p>
	                    <img src="./images/icon_nav_nav.png" alt="">
	                </div>
	                <div class="page__category js_categoryInner">
	                    <div class="weui-cells page__category-content">
	                        <a class="weui-cell weui-cell_access js_item" data-id="navbar" href="javascript:;">
	                            <div class="weui-cell__bd">
	                                <p>Navbar</p>
	                            </div>
	                            <div class="weui-cell__ft"></div>
	                        </a>
	                        <a class="weui-cell weui-cell_access js_item" data-id="tabbar" href="javascript:;">
	                            <div class="weui-cell__bd">
	                                <p>Tabbar</p>
	                            </div>
	                            <div class="weui-cell__ft"></div>
	                        </a>
	                    </div>
	                </div>
	            </li>
	            <li>
	                <div class="weui-flex js_category">
	                    <p class="weui-flex__item">搜索相关</p>
	                    <img src="./images/icon_nav_search.png" alt="">
	                </div>
	            </li>
	            <li>
	                <div class="weui-flex js_item" data-id="layers">
	                    <p class="weui-flex__item">层级规范</p>
	                    <img src="./images/icon_nav_z-index.png" alt="">
	                </div>
	            </li>
	        </ul>
	    </div>
	    <div class="page__ft">
	        <a href="javascript:home()"><img src="./images/icon_footer.png"></a>
	    </div>
	</div>
	<div class="js_dialog" id="iosDialog2" style="display: none;">
        <div class="weui-mask"></div>
        <div class="weui-dialog">
            <div class="weui-dialog__bd">弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内</div>
            <div class="weui-dialog__ft">
                <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_primary">知道了</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>