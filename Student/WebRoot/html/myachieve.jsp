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
		        <td class="tdbck">班级名称</td>
		        <td><span id="txtclassName"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">课程名称</td>
		        <td><span id="txtcurriculumName"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">教师名称</td>
		        <td><span id="txtteaName"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">学生名称</td>
		        <td><span id="txtstuname" ></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">成绩</td>
		        <td><span id="txtfraction"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">评价</td>
		        <td><span id="txtevaluate"></span></td>
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
			    <label class="layui-form-label">选择学期:</label>
						<div class="layui-inline">
							<select id="slseme" name="slseme" lay-filter="slseme">							
							
							</select>
						</div>
				
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
	<script>
	layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
		
		//调用方法加载select管理员角色
		loadseme("slseme",form,"../curr/loacdseme");
		
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'adminUserid',
			url : '../student/getmysheet',
			title : '管理员用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					width : '6%',
					
					
				}, {
     				field : 'className',
     				align : 'center',
     				title : '班级名称',
     				width : '15%',
   
    			},{
     				field : 'curriculumName',
     				align : 'center',
     				title : '课程名称',
     				width : '15%',
   
    			},{
     				field : 'teaName',
     				align : 'center',
     				title : '教师名称',
     				width : '10%',
   
    			},{
     				field : 'stuname',
     				align : 'center',
     				title : '学生名称',
     				width : '12%',
   
    			},{
     				field : 'fraction',
     				align : 'center',
     				title : '成绩',
     				width : '10%',
   
    			},{
     				field : 'evaluate',
     				align : 'center',
     				title : '教师评价',
     				width : '12%',
   
    			},{
     				field : 'remakes',
     				align : 'center',
     				title : '学生反馈',
     				edit: 'text',
     				width : '10%',
   
    			},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center',
					width : '10%',
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
			
			var semester=$("#slseme").val();
			table.reload('adminUserid', {
				method : 'post',
				where : {
					
					'semesterid':semester,
					
						},
				page : {
					curr : 1
					}
			});
		});
		
		//监听单元格编辑
		  table.on('edit(blogUser)', function(obj){
		    var value = obj.value //得到修改后的值
		    ,data = obj.data //得到所在行所有键值
		    ,field = obj.field; //得到字段
		    
		    upsheet(data.sheetid,data.fraction,data.evaluate,data.courseid,data.stuinfoid,data.remakes);
		  });
		  
		  function upsheet(id,fraction,evaluate,courseid,stuinfoid,remakes) {
				$.ajax({
					type: 'get',
					url: "../student/upsheet?sheetid="+id+"&fraction="+fraction+"&evaluate="+evaluate+"&courseid="+courseid+"&stuinfoid="+stuinfoid+"&remakes="+remakes,
					datatype: 'json',
					success: function(data) {
						
					},
					error: function() {
						layer.msg('修改失败！', function(){});
					}
				});
				
			}
		
	
		//表格工具栏事件 
		table.on('tool(blogUser)', function(obj) {
			var data = obj.data;
			$("#txtclassName").text(data.className);
			$("#txtcurriculumName").text(data.curriculumName);
			$("#txtteaName").text(data.teaName);
			$("#txtstuname").text(data.stuname);
			$("#txtfraction").text(data.fraction);
			$("#txtevaluate").text(data.evaluate);
			
			
			switch (obj.event) {
				case 'seluser':
					layer.open({
				        type: 1, 
				        title: '成绩信息详情',
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
				
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../del/delcurr?id="+data.curriculumid,
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