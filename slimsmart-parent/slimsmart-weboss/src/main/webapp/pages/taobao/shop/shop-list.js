/**
 * 后台用户管理
 */
(function() {
	var BackUserList = function() {
		//函数构造，调用初始化
		this.init();
	};
	BackUserList.prototype = {
		cache : {
			//缓存数据
			grid : null
		},
		init : function() {
			this.render();
			this.loadGrid();
		},
		render : function(){
			//渲染页面样式
		},
		loadGrid : function(){ //表格定义
			var _thisref = this;
			var toolbar = [];
			//定义表格属性
			var options = {
					//表格渲染的div id
					renderId : "taobao-shop-grid",
					//查询列表data的url
					url:REQUEST_URL+"/taobao/shop/list.do",
					//查询条件的form id
					searchFormId:"taobao-shop-list-form",
					//查询按钮Id
					searchBtnId : "taobao-shop-list-search-btn",
					//重置按钮Id
					searchResetId : "taobao-shop-list-reset-btn",
					//表格高度
					height : $(window).height()-100,
					//定义列
					columns:[[{
						field:'shopName',
						title:'店铺名称',
						align:"center",
						width:140
					},{
						field:'wangwang',
						title:'旺旺id',
						align:"center",
						width:120
					},{
						field:'shopUrl',
						title:'店铺地址',
						align:"center",
						width:120
					},{
						field:'sellNum',
						title:'店铺销量',
						align:"center",
						width:120
					},{
						field:'productNum',
						title:'宝贝数量',
						align:"center",
						width:120
					},{
						field:'provinceName',
						title:'省份',
						align:"center",
						width:120
					},{
						field:'level',
						title:'店铺等级',
						align:"center",
						width:120,
						formatter: function(value,row,index){
							if(value.indexOf('tianmao')>=0){
								return '天猫店';
							}else{
								
								return value.replace("rank seller-rank-","");
							}
						}
					},{
						field:'telphone',
						title:'联系电话',
						align:"center",
						width:300
					},{
						field:'goodratePercent',
						title:'好评率',
						align:"center",
						width:120
					},{
						field:'searchKey',
						title:'关键词',
						align:"center",
						width:120
					}]],
					renderDialogId : 'usercenter-backuser-add-dialog',
					buttons : [{
						action : "update",
						title: '编辑',
					    width: 600,
					    height: 340,
					    formId : 'usercenter-backuser-add-form',
						url : REQUEST_URL+'/pages/usercenter/backuser/backuser-add.jsp',
						detailUrl : REQUEST_URL+"/usercenter/backUser/detail.do",
						updateUrl : REQUEST_URL+"/usercenter/backUser/update.do",
						onLoad : function(id){ //页面加载完成后
							$("tr[name='usercenter-backuser-password-tr']","#usercenter-backuser-add-form").each(function(j){
								 $(this).remove();
							 });
							 $("#loginName","#usercenter-backuser-add-form").textbox('readonly',true);
						}
						/*提交之前
						,
						beforeSubmit : function(param){
						}，
						//对话框打开之前
						onBeforeOpen : function(){
						},
						//数据渲染完毕
						renderComplete : function(){
						},
						//对话框关闭之前
						onBeforeClose : function(){
						},
						//提交失败处理
						error : function(){
						},
						//提交成功处理
						success : function(data,dialog){
						}*/
					},{
						action : "detail",
						title: '详情',
					    width: 600,
					    height: 340,
					    formId : 'usercenter-backuser-add-form',
						url : REQUEST_URL+'/pages/usercenter/backuser/backuser-add.jsp',
						detailUrl : REQUEST_URL+"/usercenter/backUser/detail.do",
						onLoad : function(id){ //页面加载完成后
							$("tr[name='usercenter-backuser-password-tr']","#usercenter-backuser-add-form").each(function(j){
								 $(this).remove();
							 });
							 $("#loginName","#usercenter-backuser-add-form").textbox('readonly',true);
						}
						/*,
						//对话框打开之前
						onBeforeOpen : function(){
						},
						//数据渲染完毕
						renderComplete : function(){
						},
						//对话框关闭之前
						onBeforeClose : function(){
						}*/
					},{
						action : "del",
						delUrl : REQUEST_URL+"/usercenter/backUser/delete.do"
						/*
						 //删除成功
						 success : function(data){
						 },
						 */
					}],
					//指定工具栏
					toolbar :toolbar
			};
			//创建slimgrid对象,放到缓存中
			_thisref.cache.grid = new slimgrid(options);
		},
		resetPassword : function(id){
			$.messager.confirm('提示', '您确认要重置该用户密码吗？', function(r){
				if (r){
					$.ajax({
						url : REQUEST_URL+"/usercenter/backUser/resetPwd.do",
						data:{
							id : id 
						},
						type:'post',    
					    cache:false,    
					    dataType:'json',    
					    success:function(data) {
					    	if((typeof data =="string" && data=== "success") || data.code == "0"){
					    		backUserList.cache.grid.reloadData();
								$.messager.success("重置成功，该用户的重置密码为："+data.data);
							}else{
								$.messager.error(data.message || data);
								backUserList.cache.grid.unselectRow(backUserList.cache.grid.getRowIndex(id));
							}
		    			},    
					     error : function() {    
					    	 $.messager.error("操作失败");
					     }    
					});
				}else{
					backUserList.cache.grid.unselectRow(backUserList.cache.grid.getRowIndex(id));
				}
			});
		},
		changeStatus : function(id,status){
			var msg = "";
			if(status == 0){
				msg ="解锁";
			}else if(status ==1){
				msg ="锁定";
			}else if(status ==2){
				msg ="注销";
			}else{
				$.messager.error("您操作有误");
				return ;
			}
			$.messager.confirm('提示', '您确认要'+msg+'该用户吗？', function(r){
				if (r){
					$.ajax({
						url : REQUEST_URL+"/usercenter/backUser/update.do",
						data:{
							id : id ,
							status : status
						},
						type:'post',    
					    cache:false,    
					    dataType:'json',    
					    success:function(data) {
					    	if((typeof data =="string" && data=== "success") || data.code == "0"){
					    		backUserList.cache.grid.reloadData();
								$.messager.success(msg+"成功");
							}else{
								$.messager.error(data.message || data);
								backUserList.cache.grid.unselectRow(backUserList.cache.grid.getRowIndex(id));
							}
		    			},    
					     error : function() {    
					    	 $.messager.error("操作失败");
					     }    
					});
				}else{
					backUserList.cache.grid.unselectRow(backUserList.cache.grid.getRowIndex(id));
				}
			});
		},
		clickSearchHisKry:function(id){
			$("#searchKeyId").attr("value",id);
			$("#taobao-shop-list-search-btn").click();
			$("#taobao-shop-export").show();
			$("#taobao-shop-export").attr("href","javascript:backUserList.chooseExportColumn(\""+$("#searchKeyId").val()+"\")");
		},
		chooseExportColumn: function(id){
			$('#taobao-choose-column-dialog').dialog({
				title: '选择导出项目',
			    width: 400,
			    height: 240
			});
			$('#searchKeyIdColumn').attr('value',id);
		},
		downloadExcel: function(){
			var value = $('#taobao-choose-column-form').serialize();
			window.location.href=REQUEST_URL+'/taobao/shop/exportExcel.do?'+value;
			$('#taobao-choose-column-dialog').dialog('close')
		},
		//加载历史搜索的关键词
		loadHistorySearchKey: function(){
			$.ajax({
				url : REQUEST_URL+"/taobao/shop/getListSearchKey.do",
				type:'post',    
			    cache:false,    
			    dataType:'json',    
			    success:function(data) {
			    	var html = '';
			    	for(var i = 0 ; i < data.length; i ++){
			    		html += '<a id="'+data[i].id+'" href="javascript:backUserList.clickSearchHisKry(\''+data[i].id+'\')">'+data[i].searchKey+'</a>&nbsp;'
			    	}
			    	$("#search_key_list").children().remove();
			    	$("#search_key_list").append(html);
    			},    
			     error : function() {    
			    	 $.messager.error("操作失败");
			     }    
			});
		}
	};
	$(document).ready(function() {
		//由于整个js类是闭包的方式实例化，外界无法访问，故实例化改对象，将其实体暴露外界，外面可以通过backUserList直接访问。
		 window.backUserList = new BackUserList();
		 backUserList.loadHistorySearchKey();
		 
		 $("#taobao-shop-export-download").bind('click',function(){
			 backUserList.downloadExcel();
		 });
		 $('#taobao-shop-search-key-btn').bind('click',function(){
			 if(!$("#searchKey").val()){
				 $.messager.error("请输入搜索关键词");
				 return;
			 }
			 $.ajax({
					url : REQUEST_URL+"/taobao/shop/location.do",
					data:{
						key: $("#searchKey").val()
					},
					type:'post',    
				    cache:false,    
				    dataType:'json',    
				    success:function(data) {
				    	if(data == "0"){
				    		$("#searchKey").val('');
				    		$.messager.alert('温馨提示','正在后台执行搜索任务，点击刷新按钮查看最新搜索数据！');
				    		backUserList.loadHistorySearchKey();
						}
	    			},    
				     error : function() {    
				    	 $.messager.error("操作失败");
				     }    
				});
		 });
		 
	});
})();
