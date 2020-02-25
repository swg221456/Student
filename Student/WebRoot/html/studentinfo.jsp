<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>网站用户管理</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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
<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>

<body>
	

	<div class="blogUser-con">
		<div class="layui-col-md12 layui-col-lg12 my-bloger">
                <div class="blogerArti layui-card">
                    <div class="blogeraerticle layui-card-header">
                        <span class="blueline"></span>
                         <p class="header_title">基本信息</p>
                         
                       
                    </div>
                    <div class="layui-card-body" >
                   
                        <table  class="layui-table" width="100%"  lay-even lay-skin="nob" lay-size="lg">
						    <tbody>
						      <tr>
						        <td width="10%"><i class="layui-icon layui-icon-username"></i><span class="user_txt"> &nbsp&nbsp姓名：&nbsp</span></td>
						        <td ><span id="stuname"></span></td>
						        <td width="10%"><i class="layui-icon layui-icon-list"></i><span class="user_txt">&nbsp&nbsp学院：&nbsp</span></td>
						        <td ><span id="collegeName"></span></td>
						      </tr>
						      <tr>
						        <td ><i class="layui-icon layui-icon-male"></i><span class="user_txt">&nbsp&nbsp性别：&nbsp</span></td>
						        <td ><span id="agend"></span></td>
						        <td ><i class="layui-icon layui-icon-tabs"></i><span class="user_txt">&nbsp&nbsp专业：&nbsp</span></td>
						        <td ><span id="majorName"></span></td>
						      </tr>
						       <tr>
						         <td ><i class="layui-icon layui-icon-log"></i><span class="user_txt">&nbsp&nbsp生日：&nbsp</span></td>
						        <td ><span id="birthday"></span></td>
						        <td ><i class="layui-icon layui-icon-release"></i><span class="user_txt">&nbsp&nbsp班级：&nbsp</span></td>
						        <td ><span id="className"></span></td>
						      </tr>
						      <tr>
						         <td ><i class="layui-icon layui-icon-cellphone"></i><span class="user_txt">&nbsp&nbsp电话：&nbsp</span></td>
						        <td ><span id="phone"></span></td>
						        <td ><i class="layui-icon layui-icon-cols"></i><span class="user_txt">&nbsp&nbsp学号：&nbsp</span></td>
						        <td ><span id="stunum"></span></td>
						      </tr>
						      <tr>
						        <td ><i class="layui-icon layui-icon-website"></i><span class="user_txt">&nbsp&nbsp邮箱：&nbsp</span></td>
						        <td ><span id="email"></span></td>
						        <td ><i class="layui-icon layui-icon-tips"></i><span class="user_txt">&nbsp&nbsp身份证号：&nbsp</span></td>
						        <td  ><span id="stucard"></span></td>
						      </tr>
						    </tbody>
						  </table>
						
                    </div>
                    
                </div>
               
            
                       
                        
            <!-- 用户信息修改Start -->
		<div id="add-blogUser">
			<div class="artTypeLayer">
				<form class="layui-form" action="">
				
					<div class="layui-form-item">
						<label class="layui-form-label">姓名:</label>
						<div class="layui-input-block">
							<input type="text" name="addstuname" id="addstuname"
								lay-verify="addstuname" autocomplete="off"  class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">性别:</label>
						<div class="layui-input-block">
							<input type="text" name="addagend" id="addagend"  autocomplete="off"  class="layui-input">
						</div>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">生日:</label>
						<div class="layui-input-block">
							<input type="text" name="addbirthday" id="addbirthday" autocomplete="off" placeholder="" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">学号:</label>
						<div class="layui-input-block">
							<input type="text" name="addstunum" id="addstunum" autocomplete="off" placeholder="" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">身份证号:</label>
						<div class="layui-input-block">
							<input type="text" name="addstucard" id="addstucard" autocomplete="off" placeholder="" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">电话:</label>
						<div class="layui-input-block">
							<input type="text" name="addphone" id="addphone" autocomplete="off" placeholder="" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">邮箱:</label>
						<div class="layui-input-block">
							<input type="text" name="addemail" id="addemail" autocomplete="off" placeholder="" class="layui-input">
						</div>
					</div>
					
					
				</form>
			</div>
		</div>
		<!-- 用户信息修改End -->
		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>
		
		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="seluser">编辑</a>
			
		</script>
		
		
	</div>
	
	<script>
	layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
	
		//日期选择器
		laydate.render({ 
		  elem: '#addbirthday'
		  //,type: 'date' //默认，可不填
		});
	
		$.ajax({
						type : 'get',
						url : '../student/getmystu',
						datatype : 'json',
						success : function(data) {
						var stu = data.data;
						
							if (data.code == "0") {
								$("#stuname").text(stu[0].stuname),
								$("#collegeName").text(stu[0].collegeName),
								$("#agend").text(stu[0].agend),
								$("#majorName").text(stu[0].majorName),
								$("#birthday").text(stu[0].birthday),
								$("#className").text(stu[0].className),
								$("#phone").text(stu[0].phone),
								$("#stunum").text(stu[0].stunum),
								$("#email").text(stu[0].email),
								$("#stucard").text(stu[0].stucard)
							}else{
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:2
								});
							}
						},
						error : function() {
							layer.confirm('请求异常', {
			        				icon: 6,
									  btn: ['确定']
								});
						}
		});
		
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'adminUserid',
			url : '../student/getmystudent',
			title : '管理员用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					field : 'collegeName',
					align : 'center',
					title : '学院'
				},{
					field : 'majorName',
					align : 'center',
					title : '专业'
				},{
					field : 'className',
					align : 'center',
					title : '班级'
				},{
					field : 'stuname',
					title : '姓名',
					align : 'center'
				},{
					field : 'agend',
					align : 'center',
					title : '性别'
				},{
					field : 'birthday',
					align : 'center',
					title : '生日'
				},{
					field : 'phone',
					align : 'center',
					title : '电话'
				},{
					field : 'stunum',
					align : 'center',
					title : '学号'
				},{
					field : 'email',
					align : 'center',
					title : '邮箱'
				},{
					field : 'stucard',
					align : 'center',
					title : '身份证'
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
		
		//表格工具栏事件 
		table.on('tool(blogUser)', function(obj) {
			var data = obj.data;
			$("#addstuname").val(data.stuname);
			
			$("#addagend").val(data.agend);
			
			$("#addbirthday").val(data.birthday);
			
			$("#addphone").val(data.phone);
			$("#addstunum").val(data.stunum);
			$("#addemail").val(data.email);
			$("#addstucard").val(data.stucard);
			
			var id = data.stuinfoid;
			
			switch (obj.event) {
				case 'seluser':
					layer.open({
				        type: 1, 
				        title : '个人信息修改',
				area : [ '760px', '725px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var stuname = $("#addstuname").val();
					var agend = $("#addagend").val();
					var birthday = $("#addbirthday").val().trim();
					var phone = $("#addphone").val().trim();
					var stunum = $("#addstunum").val().trim();
					var email = $("#addemail").val().trim();
					var stucard = $("#addstucard").val().trim();
					
					
					

					if(stuname == "") {
						layer.tips('不能为空', '#stuname');
						return;
					} 
					if(agend == "") {
						layer.tips('不能为空', '#agend');
						return;
					} 
					if(phone == "") {
						layer.tips('不能为空', '#phone');
						return;
					} 
					if(birthday == "") {
						layer.tips('不能为空', '#birthday');
						return;
					} 
					
					if(email == "") {
						layer.tips('不能为空', '#email');
						return;
					} 
					if(stucard == "") {
						layer.tips('不能为空', '#stucard');
						return;
					} 
					
					$.ajax({
						type : 'get',
						url : '../student/upstudent?stuname='+stuname+'&agend='+agend+'&birthday='+birthday+'&phone='+phone+'&stunum='+stunum+'&email='+email+'&stucard='+stucard+'&id='+id,
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
				break;
				
				
				
			}
			;
		});
		
		 
		
	
		
	});
	</script>
</body>
</html>