	<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>公告管理</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
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
		<table class="layui-table">
		    <tbody>
		      <tr>
		        <td class="tdbck">标题</td>
		        <td><span id="txtnoticeName"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">内容</td>
		        <td><span id="txtnoticecontent"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">备注</td>
		        <td><span id="txtremarks"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">创建人</td>
		        <td><span id="txtuserid"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">创建时间</td>
		        <td><span id="txtcreatedate"></span></td>
		      </tr>
		    </tbody>
		  </table>
	</div>
	<!--弹框调用内容END-->	

	<div class="blogUser-con">
		<!-- 条件筛选框Start -->
		<blockquote class="layui-elem-quote not_border_left">
			<form class="layui-form" action="">
			  	<div class="layui-input-inline">
					<input type="text" name="userName" id="userName" placeholder="请输入标题" class="layui-input" autocomplete="off">
			    </div>
			    
			    <div class="layui-inline">
	     	   		<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
			    </div>
			    
				<button type="button" class="layui-btn layui-bg-blue" id="addartType" lay-event="addartType" lay-filter="addartType" style="margin-left: 10px;">新增公告</button>
				
			</form>
		</blockquote>
		<!-- 条件筛选框End -->

		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>

		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="seluser">查看</a>
			<a class="layui-btn layui-btn-danger  layui-btn-xs" lay-event="up">修改</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	
		</script>

		<!-- 用户信息添加Start -->
		<div id="add-blogUser">
			<div class="artTypeLayer">
				<form class="layui-form" action="">
				
					<div class="layui-form-item">
						<label class="layui-form-label">标题:</label>
						<div class="layui-input-block">
							<input type="text" name="addnoticeName" id="addnoticeName"
								lay-verify="addnoticeName" autocomplete="off" placeholder="请输入标题" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">内容:</label>
						<div class="layui-input-block">
							<input type="text" name="addnoticecontent" id="addnoticecontent"  autocomplete="off"  class="layui-input">
						</div>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">备注:</label>
						<div class="layui-input-block">
							<input type="text" name="addremarks" id="addremarks" autocomplete="off" placeholder="" class="layui-input">
						</div>
					</div>
					
				</form>
			</div>
		</div>
		<!-- 用户信息添加End -->
		
		<!-- 用户信息修改Start -->
		<div id="up-blogUser" style="display:none;">
			<div class="artTypeLayer">
				<form class="layui-form" action="">
				
					<div class="layui-form-item">
						<label class="layui-form-label">标题:</label>
						<div class="layui-input-block">
							<input type="text" name="upnoticeName" id="upnoticeName"
								lay-verify="upnoticeName" autocomplete="off" placeholder="请输入标题" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">内容:</label>
						<div class="layui-input-block">
							<input type="text" name="upnoticecontent" id="upnoticecontent"  autocomplete="off"  class="layui-input">
						</div>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">备注:</label>
						<div class="layui-input-block">
							<input type="text" name="upremarks" id="upremarks" autocomplete="off" placeholder="" class="layui-input">
						</div>
					</div>
					
					
				</form>
			</div>
		</div>
		<!-- 用户信息修改End -->
		
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
	
		
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'adminUserid',
			url : '../admin2/getnotice',
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
					field : 'noticeName',
					title : '标题',
					align : 'center'
				}, {
					field : 'noticecontent',
					align : 'center',
					title : '内容'
				},{
					field : 'remarks',
					align : 'center',
					title : '备注'
				},{
					field : 'userid',
					align : 'center',
					title : '创建人'
				},{
					field : 'createdate',
					align : 'center',
					title : '创建时间'
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
			var slnoticename=$("#userName").val().trim();
			table.reload('adminUserid', {
				method : 'post',
				where : {
					'noticename' : slnoticename,
					
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
			$("#addnoticeName").val("");
			$("#addnoticecontent").val("");
			$("#addremarks").val("");
			layer.open({
				type : 1,
				title : '公告添加',
				area : [ '460px', '335px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var noticeName = $("#addnoticeName").val().trim();
					var noticecontent = $("#addnoticecontent").val().trim();
					var remarks = $("#addremarks").val().trim();
					

					if(noticeName == "") {
						layer.tips('不能为空', '#noticeName');
						return;
					} 
					
					$.ajax({
						type : 'get',
						url : '../admin2/addnotice?noticeName=' + noticeName +'&noticecontent='+noticecontent+'&remarks='+remarks,
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
							layer.confirm('修改失败', {
			        				icon: 6,
									  btn: ['确定']
								});
						}
					});						
				},
				btn2 : function() {layer.closeAll();}
			});
		});
	
		//表格工具栏事件 
		table.on('tool(blogUser)', function(obj) {
			var data = obj.data;
			$("#txtnoticeName").text(data.noticeName);
			$("#txtnoticecontent").text(data.noticecontent);
			$("#txtremarks").text(data.remarks);
			$("#txtuserid").text(data.userid);
			$("#txtcreatedate").text(data.createdate);
			$("#txtadmincreatetime").text(data.createtime);
			
			$("#upnoticeName").val(data.noticeName);
			$("#upnoticecontent").val(data.noticecontent);
			$("#upremarks").val(data.remarks);
			var noticeid = data.noticeid;
			
			switch (obj.event) {
				case 'seluser':
					layer.open({
				        type: 1, 
				        title: '管理员信息详情',
				        area: ['600px', '430px'],
				        shade: 0.8,
				        content: $('#adminuserdetail'),
				        btn: ['返回'], 
				        yes: function(){
				          layer.closeAll();
				          $(".adminuserdetail").css("display","none");
				        },
				        cancel: function(){ 
						  $(".adminuserdetail").css("display","none");
						}
				    });
				break;
				//修改操作
				case 'up':
					layer.open({
				        type: 1, 
				        title : '个人信息修改',
				area : [ '460px', '425px' ],
				shade : 0.4,
				content : $('#up-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var noticeName = $("#upnoticeName").val().trim();
					var noticecontent = $("#upnoticecontent").val().trim();
					var remarks = $("#upremarks").val().trim();
					
					
					
					

					if(noticeName == "") {
						layer.tips('不能为空', '#noticeName');
						return;
					} 
					if(noticecontent == "") {
						layer.tips('不能为空', '#noticecontent');
						return;
					} 
					
					$.ajax({
						type : 'get',
						url : '../admin2/upnotice?noticeid='+noticeid+'&noticeName='+noticeName+'&noticecontent='+noticecontent+'&remarks='+remarks,
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
							layer.confirm('修改失败', {
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
			        		url: "../del/delnotice?id="+data.noticeid,
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