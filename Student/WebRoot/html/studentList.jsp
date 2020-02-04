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
		<table class="layui-table">
		    <tbody>
		     
		      <tr>
		        <td class="tdbck">学生姓名</td>
		        <td><span id="txtstuname"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">学号</td>
		        <td><span id="txtstunum"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">性别</td>
		        <td><span id="txtagend"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">出生日期</td>
		        <td><span id="txtbirthday" lay-data="{templet:'#titlrTpl'}"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">电话</td>
		        <td><span id="txtphone"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">邮箱</td>
		        <td><span id="txtemail"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">身份证号</td>
		        <td><span id="txtstucard"></span></td>
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
			    <label class="layui-form-label">选择院系:</label>
						<div class="layui-inline">
							<select id="slcollege" name="slcollege" lay-filter="slcollege">							
							
							</select>
						</div>
				</div>
				<div class="layui-input-inline">
			    <label class="layui-form-label">选择专业:</label>
						<div class="layui-inline">
							<select id="slmajor" name="slmajor" lay-filter="slmajor">							
							
							</select>
						</div>
				</div>
				<div class="layui-input-inline">
			    <label class="layui-form-label">选择班级:</label>
						<div class="layui-inline">
							<select id="slclass" name="slclass" lay-filter="slclass">							
							
							</select>
						</div>
				</div>
			  	<div class="layui-input-inline">
					<input type="text" name="userName" id="userName" placeholder="请输入用户名或真实姓名" class="layui-input" autocomplete="off">
			    </div>
			    
			    
			    <div class="layui-inline">
	     	   		<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
			    </div>
				
			</form>
		</blockquote>
		<!-- 条件筛选框End -->

		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>

		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="seluser">查看</a>
			
		</script>

		
		
	</div>
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script type="text/html" id="titleTpl">
    {{d.date.substr(0,10)}}
</script>
	<script>
	layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
		//调用方法加载select管理员角色
		loaduserby("adduserid",form,"../college/loacduser?roleID=1");
		
		
		
		loadcollege("slcollege",form,"../college/loadcollege");
		
		form.on('select(slcollege)', function(data)
				{
				var paretid = $("#slcollege").val();
			 	//调用方法加载select管理员角色
				loadmajor("slmajor", form, "../college/loadmajor?collegeid="+paretid);
				});
				
		form.on('select(slmajor)', function(data)
				{
				var paretid = $("#slmajor").val();
			 	//调用方法加载select管理员角色
				loadclass("slclass", form, "../college/loadclass?majorid="+paretid);
				});
				
				
		
		loadcollege("addcollege",form,"../college/loadcollege");
		
		form.on('select(addcollege)', function(data)
				{
				var paretid = $("#addcollege").val();
			 	//调用方法加载select管理员角色
				loadmajor("addmajor", form, "../college/loadmajor?collegeid="+paretid);
				});
				
		form.on('select(addmajor)', function(data)
				{
				var paretid = $("#addmajor").val();
			 	//调用方法加载select管理员角色
				loadclass("addclass", form, "../college/loadclass?majorid="+paretid);
				});
		
		
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'adminUserid',
			url : '../student/getstudent',
			title : '管理员用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					
				}, {
     				field : 'stuname',
     				align : 'center',
     				title : '姓名',
   
    			},{
     				field : 'stunum',
     				align : 'center',
     				title : '学号',
   
    			},{
     				field : 'agend',
     				align : 'center',
     				title : '性别',
   
    			},{
     				field : 'birthday',
     				align : 'center',
     				title : '出生日期',
     				pattern:'yyyy/MM/dd',
   
    			},{
     				field : 'phone',
     				align : 'center',
     				title : '电话',
   
    			},{
     				field : 'email',
     				align : 'center',
     				title : '邮箱',
   
    			},{
     				field : 'stucard',
     				align : 'center',
     				title : '身份证号',
   
    			},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				}]
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
			var slclass=$("#slclass").val();
			var slcollege=$("#slcollege").val();
			var slmajor=$("#slmajor").val();
			
			table.reload('adminUserid', {
				method : 'post',
				where : {
					'noticename' : slnoticename,
					'classid' : slclass,
					'collegeid' : slcollege,
					'majorid' : slmajor,
					
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
			$("#addclassName").val("");
			$("#adduserid").val("");
			$("#addmajor").val("");
			
			
			layer.open({
				type : 1,
				title : '公告添加',
				area : [ '560px', '500px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var addclassName = $("#addclassName").val().trim();
					var adduserid = $("#adduserid").val();
					var addmajor = $("#addmajor").val();
					
					if(addclassName == "") {
						layer.tips('不能为空', '#addclassName');
						return;
					} 
					if(addmajor == "") {
						layer.tips('不能为空', '#addmajor');
						return;
					} 

					if(adduserid == "") {
						layer.tips('不能为空', '#adduserid');
						return;
					} 
					
					$.ajax({
						type : 'get',
						url : '../college/addclass?calssName=' + addclassName +'&userid='+adduserid+'&majorid='+addmajor,
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
							layer.confirm('添加成功', {
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
			$("#txtstuname").text(data.stuname);
			$("#txtstunum").text(data.stunum);
			$("#txtagend").text(data.agend);
			$("#txtbirthday").text(data.birthday);
			$("#txtphone").text(data.phone);
			$("#txtemail").text(data.email);
			$("#txtstucard").text(data.stucard);
			
			
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
				
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../del/delcollege?collegeid="+data.collegeid,
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