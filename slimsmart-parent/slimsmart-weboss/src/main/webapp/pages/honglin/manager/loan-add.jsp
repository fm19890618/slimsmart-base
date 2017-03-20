	<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
	<div style="margin: 10px 10px 10px 10px;">
	<form id="usercenter-loan-add-form" enctype="multipart/form-data" method="post">
		<input type="hidden" name ="id" />
		<table style="width: 100%; margin-bottom: 20px;">
			<tr>
				<td class="tr">名称：</td>
				<td class="tl">
					<input type="text" name="name"  class="easyui-textbox" data-options="required:true,validType:'length[1,20]'"/>
				</td>
				<td class="tr">申请人数：</td>
				<td class="tl">
					<input type="text" name="applyNum"  class="easyui-textbox" data-options="required:true,validType:'length[1,20]'"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td class="tr">利率：</td>
				<td class="tl">
					<input type="text" name="rate"  class="easyui-textbox" data-options="required:true,validType:'length[1,20]'"/>
				</td>
				<td class="tr">描述信息：</td>
				<td class="tl">
					<textarea  rows="3" cols="30" name="description"  data-options="required:false,validType:'length[1,200]'"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td class="tr">logo：</td>
				<td colspan="3" class="tl">
					<input class="easyui-filebox" name="file" label="width: 80%" labelPosition="top" style="width:80%">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>