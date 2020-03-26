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
		.layui-table-cell{
	  		font-size:20px;
	  		 height: auto;
		}
	</style>
</head>
<body>
	<!--弹框调用内容Start-->
	<div id="adminuserdetail" class="adminuserdetail">			
		<table class="layui-table">
		    <tbody>
		      <tr>
		        <td class="tdbck">学期</td>
		        <td><span id="txtsemesterName"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">任课班级</td>
		        <td><span id="txtclassName"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">课程名称</td>
		        <td><span id="txtcurriculumName"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">任课教师</td>
		        <td><span id="txtteaName"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">课程介绍</td>
		        <td><span id="txtintroduce"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">备注</td>
		        <td><span id="txtremarks"></span></td>
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
			    <label class="layui-form-label">选择班级:</label>
						<div class="layui-inline">
							<select id="slclass" name="slclass" lay-filter="slclass">							
							
							</select>
						</div>
				</div>
				<div class="layui-input-inline">
			    <label class="layui-form-label">选择教师:</label>
						<div class="layui-inline">
							<select id="slteacher" name="slteacher" lay-filter="slteacher">							
							
							</select>
						</div>
				</div>
			    
			    <div class="layui-inline">
	     	   		<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
			    </div>
				<button type="button" class="layui-btn layui-bg-blue" id="addartType" lay-event="addartType" lay-filter="addartType" style="margin-left: 10px;">新增教师任课</button>
			</form>
		</blockquote>
		<!-- 条件筛选框End -->

		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>

		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="seluser">查看</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="up">修改</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>

		<!-- 用户信息添加Start -->
		<div id="add-blogUser">
			<div class="artTypeLayer">
				<form class="layui-form" action="">
				
					<div class="layui-form-item">
						<label class="layui-form-label">选择班级:</label>
						<div class="layui-inline">
							<select id="addclass" name="slclass" lay-filter="slclass">							
							
							</select>
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">选择教师:</label>
						<div class="layui-inline">
							<select id="addteacher" name="addteacher" lay-filter="addteacher">							
							
							</select>
						</div>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">选择课程:</label>
						<div class="layui-inline">
							<select id="addcurr" name="addcurr" lay-filter="addcurr">							
							
							</select>
						</div>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">备注:</label>
						<div class="layui-input-block">
							<input type="text" name="remakes" id="remakes"  autocomplete="off" placeholder="" class="layui-input">
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
						<label class="layui-form-label">选择班级:</label>
						<div class="layui-inline">
							<select id="upclass" name="upclass" lay-filter="upclass">							
							
							</select>
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">选择教师:</label>
						<div class="layui-inline">
							<select id="upteacher" name="upteacher" lay-filter="upteacher">							
							
							</select>
						</div>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">选择课程:</label>
						<div class="layui-inline">
							<select id="upcurr" name="upcurr" lay-filter="upcurr">							
							
							</select>
						</div>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">备注:</label>
						<div class="layui-input-block">
							<input type="text" name="upremakes" id="upremakes"  autocomplete="off" placeholder="" class="layui-input">
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
		//调用方法加载select管理员角色
		loadclass("slclass", form, "../college/loadclass?majorid=0");
		loadteach("slteacher", form, "../admin2/loacdtea");
		
		loadclass("addclass", form, "../college/loadclass?majorid=0");
		loadteach("addteacher", form, "../admin2/loacdtea");
		loadcurr("addcurr", form, "../curr/loacdcurr");
		
		loadclass("upclass", form, "../college/loadclass?majorid=0");
		loadteach("upteacher", form, "../admin2/loacdtea");
		loadcurr("upcurr", form, "../curr/loacdcurr");
		
		
		
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'adminUserid',
			url : '../curr/getcourse',
			title : '管理员用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					width : 100,
					
				}, {
     				field : 'className',
     				align : 'center',
     				title : '班级名称',
   
    			},{
     				field : 'teaName',
     				align : 'center',
     				title : '教师名称',
   
    			},{
     				field : 'curriculumName',
     				align : 'center',
     				title : '课程名称',
   
    			},{
     				field : 'remakes',
     				align : 'center',
     				title : '备注',
   
    			},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				}]
			 ],
			  done : function(res, curr, count){
	        
			        tableList=res.data;
			       	$('th').css({'background-color': '#5792c6', 'color': '#fff','font-weight':'bold','font-size':'20px'})
	      
	    	},
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
			var slclass=$("#slclass").val();
			var slteacher=$("#slteacher").val();
			table.reload('adminUserid', {
				method : 'post',
				where : {
					'classid' : slclass,
					'teacherid' : slteacher,
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
			$("#addcurr").val("");
			$("#addclass").val("");
			$("#addteacher").val("");
			
			layer.open({
				type : 1,
				title : '公告添加',
				area : [ '460px', '435px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var remakes = $("#remakes").val().trim();
					var addclass = $("#addclass").val();
					var addteacher = $("#addteacher").val();
					var addcurr = $("#addcurr").val();
					
					if(addclass == "") {
						layer.tips('不能为空', '#addclass');
						return;
					} 

					if(addteacher == "") {
						layer.tips('不能为空', '#addteacher');
						return;
					} 
					if(addcurr == "") {
						layer.tips('不能为空', '#addcurr');
						return;
					}
					
					$.ajax({
						type : 'get',
						url : '../curr/addcourse?classid='+addclass+'&teacherid='+addteacher+'&curriculumid='+addcurr+'&remakes='+remakes,
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
			$("#txtsemesterName").text(data.semesterName);
			$("#txtclassName").text(data.className);
			$("#txtcurriculumName").text(data.curriculumName);
			$("#txtintroduce").text(data.introduce);
			$("#txtteaName").text(data.teaName);
			$("#txtremarks").text(data.remakes);
			
			
			set_select_checked("upcurr",data.curriculumid);
			set_select_checked("upclass",data.classid);
			set_select_checked("upteacher",data.teacherid);
			$("#upremakes").val(data.remakes);
			form.render("select");
			var courseid = data.courseid;
			
			switch (obj.event) {
				case 'seluser':
					layer.open({
				        type: 1, 
				        title: '管理员信息详情',
				        area: ['600px', '480px'],
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
					
					var upcurr = $("#upcurr").val();
					var upclass = $("#upclass").val();
					var upteacher = $("#upteacher").val();
					var upremarks = $("#upremakes").val();
					
					
					
					
					

					if(upcurr == "") {
						layer.tips('不能为空', '#upcurr');
						return;
					} 
					if(upclass == "") {
						layer.tips('不能为空', '#upclass');
						return;
					} 
					if(upteacher == "") {
						layer.tips('不能为空', '#upteacher');
						return;
					} 
					
					$.ajax({
						type : 'get',
						url : '../curr/upcourse?classid='+upclass+'&teacherid='+upteacher+'&curriculumid='+upcurr+'&remakes='+upremarks+'&courseid='+courseid,
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
			        		url: "../del/delcourse?id="+data.courseid,
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