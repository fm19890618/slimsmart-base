<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/header.jsp"%>
<script type="text/javascript" src="<%=contextPath%>/pages/taobao/shop/shop-list.js"></script>
</head>
<body style="margin-top: 10px;">
	<table style="width: 100%; margin-bottom: 20px;">
		<tr>
			<td class="tr">去淘宝搜关键词：</td>
			<td class="tl"><input type="text" id="searchKey" name="searchKey" class="easyui-textbox"/></td>
			<td>
				<a href="#" class="easyui-linkbutton" id="taobao-shop-search-key-btn"  style="width:80px">立即搜索</a>
			</td>
			<td>声明：每次搜索会消耗大量服务器资源，请避免多人同时搜索和多次搜索重复关键词，搜索后会在后台抓取数据，前台需等待10分钟左右能看见搜索的数据</td>
		</tr>
		<tr>
			<td colspan="4" id="search_key_list">
				
			</td>
		</tr>
				
	</table>
	<form id="taobao-shop-list-form">
		<table style="width: 100%; margin-bottom: 20px;">
			<tr>
				<td class="tr">店铺名称：</td>
				<td class="tl"><input type="text" name="shopName" class="easyui-textbox"/></td>
				<td class="tr">旺旺id：</td>
				<td class="tl"><input type="text" name="wangwang" class="easyui-textbox"/></td>
				<td class="tr">省份：</td>
				<td class="tl"><input type="text" name="provinceName" class="easyui-textbox"/></td>
				<input type="hidden" name="searchKeyId" id="searchKeyId"/>
			</tr>
			<tr>
				<td colspan="8">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="6">&nbsp;</td>
				<td class="tc" colspan="2">
					<a href="#" class="easyui-linkbutton" id="taobao-shop-export" style="width:80px;display:none;">导出</a>
					<a href="#" class="easyui-linkbutton" id="taobao-shop-list-search-btn" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
					<a href="#" class="easyui-linkbutton" id="taobao-shop-list-reset-btn" data-options="iconCls:'icon-back'" style="width:80px">重置</a>
				 </td>
			</tr>
		</table>
	</form>
	<div id="taobao-shop-grid"></div>
	<div id="taobao-shop-add-dialog"></div>
</body>
</html>