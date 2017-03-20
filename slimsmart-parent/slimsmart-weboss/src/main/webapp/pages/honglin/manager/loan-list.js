/**
 * 角色管理
 */
(function() {
	var LoanList = function() {
		//函数构造，调用初始化
		this.init();
	};
	LoanList.prototype = {
		cache : {
			//缓存数据
			grid : null,
			systemData : null
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
			//检查权限
			if(checkBtnShowAuth("usercenter-loan-add")){
				toolbar.push({
					text:"新增",
					iconCls: 'icon-add',
					handler: function(){
						_thisref.cache.grid.add();
					}
				});
			}
			//定义表格属性
			var options = {
					//表格渲染的div id
					renderId : "usercenter-loan-grid",
					//查询列表data的url
					url:REQUEST_URL+"/loan/managerList.do",
					//查询条件的form id
					searchFormId:"usercenter-loan-list-form",
					//查询按钮Id
					searchBtnId : "usercenter-loan-list-search-btn",
					//重置按钮Id
					searchResetId : "usercenter-loan-list-reset-btn",
					//表格高度
					height : $(window).height()-80,
					//定义列
					columns:[[{
						field:'name',
						title:'名称',
						align:"center",
						width:160
					},{
						field:'description',
						title:'描述信息',
						align:"center",
						width:400
					},{
						field:'applyNum',
						title:'申请人数',
						align:"center",
						width:400
					},{
						field:'rate',
						title:'利率',
						align:"center",
						width:400
					},{
						field:'operation',
						title:'操作',
						align:"center",
						width:260,
						formatter: function(value,row,index){
							var str ="";
							if(checkBtnShowAuth("usercenter-loan-update")){
								str +="<a href='javascript:loanList.cache.grid.update(\""+row.id+"\");' >编辑</a> &nbsp;";
							}
							if(checkBtnShowAuth("usercenter-loan-delete")){
								str +="<a href='javascript:loanList.cache.grid.del(\""+row.id+"\");' >删除</a>&nbsp;";
							}
							
							return str;
						}
					}]],
					renderDialogId : 'usercenter-loan-add-dialog',
					buttons : [{
						action : "add",
						title: '新增',
					    width: 600,
					    height: 400,
					    formId : 'usercenter-loan-add-form',
						url : REQUEST_URL+'/pages/honglin/manager/loan-add.jsp',
						addUrl : REQUEST_URL+"/loan/save.do"
					},{
						action : "update",
						title: '编辑',
						width: 600,
					    height: 400,
					    formId : 'usercenter-loan-add-form',
						url : REQUEST_URL+'/pages/honglin/manager/loan-add.jsp',
						detailUrl : REQUEST_URL+"/loan/detail.do",
						updateUrl : REQUEST_URL+"/loan/update.do"
					},{
						action : "detail",
						title: '详情',
					    width: 400,
					    height: 200,
					    formId : 'usercenter-loan-add-form',
						url : REQUEST_URL+'/pages/honglin/manager/loan-add.jsp',
						detailUrl : REQUEST_URL+"/loan/detail.do"
					},{
						action : "del",
						delUrl : REQUEST_URL+"/loan/delete.do"
					}],
					//指定工具栏
					toolbar :toolbar
			};
			//创建slimgrid对象,放到缓存中
			_thisref.cache.grid = new slimgrid(options);
		}
	};
	$(document).ready(function() {
		//由于整个js类是闭包的方式实例化，外界无法访问，故实例化改对象，将其实体暴露外界，外面可以通过backUserList直接访问。
		 window.loanList = new LoanList();
	});
})();
