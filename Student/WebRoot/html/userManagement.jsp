<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>网站用户管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="../layui/css/layui.css" media="all">
	<style>
		.blogUser-con .layui-table-view {
			border: none;
		}
		
		.blogUser-con .layui-table-box {
			margin-top: 10px;
		}
		
		.blogUser-con {
			padding: 0 15px 15px 15px;
			margin-bottom:50px;
		}
		.blogUser-con  .layui-table-tool-self{
			display:none;
		}
		.blogUser-con .not_border_left {
			border-left: none !important;
		}
		
		.blogUser-con .blogUser dl dd.layui-this {
			background-color: #1E9FFF !important;
		}
		
		.blogUser-con .hide {
			display: none;
		}
		
		.blogUser-con .show {
			display: block;
		}
		
		.blogUser-con .btn_size {
			height: 28px !important;
			line-height: 28px !important;
		}
		
		.blogUser-con .layui-table-body table tbody .layui-table-hover {
			background: #fffdd3 !important;
		}
		
		.blogUser-con .layui-table-body table tbody .layui-table-click {
			background: #fdef9b !important;
		}
		
		.blogUser-con .layui-table, .layui-table-view {
			border: none;
			margin-top: 0;
		}
		
		#add-blogUser {
			display: none;
			z-index: 999 !important;
		}
		
		#add-blogUser .artTypeLayer {
			width: 90%;
			margin-left: auto;
			margin-right: auto;
			padding-top: 20px;
		}
		.adminuserdetail{
			padding:20px;
			display: none;
		}
		.adminuserdetail table tr td{
			padding: 15px;text-align: center;
		}
		.adminuserdetail .tdbck{
			background: #f2f2f2;
			width: 30%;
		}
	</style>
</head>
<body>
	<!--弹框调用内容Start-->
	<div id="adminuserdetail" class="adminuserdetail">			
		
		  <div class="artTypeLayer">
				<form class="layui-form" action="">
				<div class="layui-form-item">
				      <label class="layui-form-label">用户类型:</label>
				      <div class="layui-input-block">
				       	<select id="txtusertype">
						  <option value="">请选择用户类型</option> 
						</select> 
				      </div>
				    </div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户名:</label>
						<div class="layui-input-block">
							<input type="text" name="txtuserid" id="txtuserid"
								lay-verify="txtuserid" autocomplete="off" placeholder="请输入用户名" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户密码:</label>
						<div class="layui-input-block">
							<input type="password" name="txtpassword" id="txtpassword"  autocomplete="off" placeholder="请输入用户密码" class="layui-input">
						</div>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">真实姓名:</label>
						<div class="layui-input-block">
							<input type="text" name="realname" id="textrealname" lay-verify="textrealname" autocomplete="off" placeholder="请输入真实姓名" class="layui-input">
						</div>
					</div>
					
				</form>
			</div>
	</div>
	<!--弹框调用内容END-->	

	<div class="blogUser-con">
		<!-- 条件筛选框Start -->
		<blockquote class="layui-elem-quote not_border_left">
			<form class="layui-form" action="">
			  	<div class="layui-input-inline">
					<input type="text" name="userName" id="userName" placeholder="请输入用户名或真实姓名" class="layui-input" autocomplete="off">
			    </div>
			    <div class="layui-inline">
					<select id="usertype"  lay-filter="usertype" lay-search>
						<option value="">请选择用户类型</option>
					</select>
				</div>
			    <div class="layui-inline">
	     	   		<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
			    </div>
				<button type="button" class="layui-btn layui-bg-blue" id="addartType" lay-event="addartType" lay-filter="addartType" style="margin-left: 10px;">新增用户</button>
			</form>
		</blockquote>
		<!-- 条件筛选框End -->

		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>
		<script type="text/html" id="switchTpl">
		  <input type="checkbox" lay-filter="open" name="status" value="{{d.userid}}" {{ d.auditstatus == "0" ? 'checked' : '' }} lay-skin="switch" lay-text="启用|停用">
		</script>

		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs layui-btn-xs" lay-event="up">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>

		<!-- 用户信息添加Start -->
		<div id="add-blogUser">
			<div class="artTypeLayer">
				<form class="layui-form" action="">
				<div class="layui-form-item">
				      <label class="layui-form-label">用户类型:</label>
				      <div class="layui-input-block">
				       	<select id="addusertype">
						  <option value="">请选择用户类型</option> 
						</select> 
				      </div>
				    </div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户名:</label>
						<div class="layui-input-block">
							<input type="text" name="addUserName" id="addUserName"
								lay-verify="addUserName" autocomplete="off" placeholder="请输入用户名" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户密码:</label>
						<div class="layui-input-block">
							<input type="password" name="addpwd" id="addpwd"  autocomplete="off"  class="layui-input">
						</div>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">真实姓名:</label>
						<div class="layui-input-block">
							<input type="text" name="realname" id="realname" lay-verify="realname" autocomplete="off" placeholder="请输入真实姓名" class="layui-input">
						</div>
					</div>
					
				</form>
			</div>
		</div>
		<!-- 用户信息添加End -->
		
	</div>
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script>
	layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
	
		//加载角色类型
		loadRoleType('usertype',form);
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'adminUserid',
			url : '../admin/getuser',
			title : '管理员用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					width : 80
				}, {
					field : 'userid',
					title : '用户名',
					align : 'center'
				}, {
					field : 'account',
					align : 'center',
					title : '真实姓名'
				},{
					field : 'roleName',
					align : 'center',
					title : '用户类型'
				},{
					field:'usertype', 
					title:'是否授权',
					align : 'center',
					templet: '#switchTpl', 
					unresize: true
					
				},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				} ] 
			 ],
			 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [10, 20, 30, 40, 50],
					theme: '#1E9FFF',						
			 },
		});
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function(){
			var useridornickname=$("#userName").val().trim();
			table.reload('adminUserid', {
				method : 'post',
				where : {
					'realname' : useridornickname,
					'roleid' : '',
						},
				page : {
					curr : 1
					}
			});
		});
		
		/* 添加一个网站用户 */
		$("#addartType").click(function(){
			//加载角色类型
			loadRoleType('addusertype',form);
			$("#addUserName").val("");
			$("#realname").val("");
			$("#addpwd").val("");
			layer.open({
				type : 1,
				title : '管理员用户添加',
				area : [ '460px', '335px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var addUserName = $("#addUserName").val().trim();
					var realname = $("#realname").val().trim();
					var pwd = $("#addpwd").val().trim();
					var usertype = $("#addusertype").val();

					if(addUserName == "") {
						layer.tips('不能为空', '#addUserName');
						return;
					} 
					if(realname==""){
						layer.tips('不能为空', '#realname');
						return;
					}
					if(pwd == "") {
						layer.tips('不能为空', '#pwd');
						return;
					}
					if(usertype==""){
						layer.tips('请选择用户类型', '#usertype');
						return;
					}
					$.ajax({
						type : 'get',
						url : '../admin/addadminuser?userid='+addUserName+'&pwd='+pwd+'&roleid='+usertype+'&realname='+realname,
						datatype : 'json',
						success : function(data) {
							if (data.code == "0") {
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:1
								}, function(){
									table.reload("adminUserid", { //此处是上文提到的 初始化标识id
						                where: {
						                	keyword:data.code=='10001'
						                }
						            });	
									layer.closeAll();
								});
							}else{
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:2
								});
							}
						},
						error : function() {
							layer.confirm('出现错误，请重试！', {
			        				icon: 6,
									  btn: ['确定']
								});
						}
					});						
				},
				btn2 : function() {layer.closeAll();}
			});
		});
		
		/* 修改教师是否启用 */
		form.on('switch(open)', function(data){
		
  	 		if(data.elem.checked){
  	 			//data.value
  	 			$.ajax({
				type : 'get',
				url : '../admin2/changeuser?userid=' + this.value,
				datatype : 'json',
				success : function(data) {
					if (data.code == "0") {		
						layer.msg('启用成功！请刷新页面', {icon: 1}); 
					} else {
	    	        	layer.msg('启用失败！', {icon: 2});
					}
				},
				error : function() {
					layer.msg('启用失败！请重试', {icon: 2});		
				}
				});
  	 		}else{
  	 			$.ajax({
				type : 'get',
				url : '../admin2/changeuser?userid=' + this.value,
				datatype : 'json',
				success : function(data) {
					if (data.code == "0") {		
						layer.msg('取消启用成功！请刷新页面', {icon: 1}); 
					} else {
	    	        	layer.msg('取消启用失败！', {icon: 2});
					}
				},
				error : function() {
					layer.msg('取消失败！请重试', {icon: 2});		
				}
				});
  	 		}
		});
	
		//表格工具栏事件 
		table.on('tool(blogUser)', function(obj) {
			loadRoleType('txtusertype',form);
			var data = obj.data;
			$("#txtuserid").val(data.userid);
			$("#textrealname").val(data.account);
			$("#txtpassword").val(data.pwd);
			$("#txtusertype").val(data.roleId);
			
			
			switch (obj.event) {
				case 'up':
					layer.open({
				    type: 1, 
				    title: '用户信息修改',
				    area : [ '460px', '365px' ],
					shade : 0.4,
					content : $('#adminuserdetail'),
					btn : [ '保存', '返回' ],
					yes : function() {
					var txtUserName = $("#txtuserid").val().trim();
					var txtrealname = $("#textrealname").val().trim();
					var txtpwd = $("#txtpassword").val().trim();
					var usertype = $("#txtusertype").val();

					if(txtUserName == "") {
						layer.tips('不能为空', '#txtUserName');
						return;
					} 
					if(txtrealname==""){
						layer.tips('不能为空', '#txtrealname');
						return;
					}
					if(txtpwd == "") {
						layer.tips('不能为空', '#txtpwd');
						return;
					}
					
					$.ajax({
						type : 'get',
						url : '../admin/upadminuser?userid='+txtUserName+'&pwd='+txtpwd+'&roleid='+usertype+'&realname='+txtrealname,
						datatype : 'json',
						success : function(data) {
							if (data.code == "0") {
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:1
								}, function(){
									table.reload("adminUserid", { //此处是上文提到的 初始化标识id
						                where: {
						                	keyword:data.code=='10001'
						                }
						            });	
									layer.closeAll();
								});
							}else{
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:2
								});
							}
						},
						error : function() {
							layer.confirm('出现错误，请重试！', {
			        				icon: 6,
									  btn: ['确定']
								});
						}
					});						
				},
				btn2 : function() {layer.closeAll();}
				    });
				break;
				
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../admin/deladminuser?userid="+data.userid,
			        		dataType: 'json',
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("adminUserid", { //此处是上文提到的 初始化标识id
							                where: {
							                	keyword:data.code=='0'
							                }
							            });	
										layer.closeAll();
									});          				 
			        			}
			        			else{
			        				layer.confirm(data.msg, {
			        				icon: 7,
										  btn: ['确定']
									});
			        			}
			        		},
			        		error:function(){
			        			layer.confirm('出现错误，删除失败，请重试！', {
			        				icon: 6,
									  btn: ['确定']
								});
			        		},
			        	});   
					}, function(){ 
						layer.closeAll();
					});
				break;
				
			}
			;
		});
	
	});
	</script>
</body>
</html>