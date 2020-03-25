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
	<link rel="stylesheet" href="layui/css/layui.css" media="all">
	<link rel="stylesheet" href="css/mystyle.css">
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
<script src="js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="js/loadselect.js" charset="utf-8"></script>
	<script src="layui/layui.js" charset="utf-8"></script>

<body>
	

	<div >
	<div class="layui-row layui-col-space30">
		<div class="layui-col-md3 layui-col-lg3">
                <div class="bloger">
                    <img src="../upload1/${stuinfo.photopath}" class="blogerphoto">
                </div>
                <div class="layui-upload inline-flex-center">
            	
            	
                <button type="button" class="layui-btn upselfhead-btn" style="background:#3AACDA;"
                    id="grzpup">上传头像</button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img upselfhead" id="demo1">
                </div>
                <p id="demoText" style="margin:0;"></p>
            	</div>
               
                <div class="layui-card">
                    <div class="layui-card-body">
                    <div class="stu_name">
                                <p>姓名：${stuinfo.stuname }
                               
                                </p>
                     </div>
                     <p><span class="yinh_left">性别：“</span> ${stuinfo.agend}<span class="yinh_left">”</span></p>
                     
                </div>
                </div>
              
            </div>
		<div class="layui-col-md8 layui-col-lg8 my-bloger">
                <div class="blogerArti layui-card">
                    <div class="blogeraerticle layui-card-header">
                        <span class="blueline"></span>
                         <p class="header_title">基本信息</p>
                          
                       
                    </div>
                    <button class="layui-btn  layui-btn layui-btn-sm myinfoedit" style="background:#3AACDA;"
                        id="up"    data-method="myjiben">编辑</button>
                    <div class="layui-card-body" >
                   
                       <div class="blogerArti layui-card">
                    
                    <div class="layui-card-body">
                        <div class="layui-row layui-col-space30">
                            <div class="layui-col-lg6 layui-col-md6">
                            	 <p class="user_info"><i class="layui-icon layui-icon-username"></i><span class="user_txt">姓名：${stuinfo.stuname }</span></p>
                                 <p class="user_info"><i class="layui-icon layui-icon-male"></i><span class="user_txt">性别：${stuinfo.agend }</span></p>
                                 <p class="user_info"><i class="layui-icon layui-icon-cellphone"></i><span class="user_txt">电话：${stuinfo.phone }</span></p>
                                 
                                 
                                 <p class="user_info"><i class="layui-icon layui-icon-notice"></i><span class="user_txt">生日：${stuinfo.birthday }</span></p>
                                 <p class="user_info"><i class="layui-icon layui-icon-date"></i><span class="user_txt">学号：${stuinfo.stunum }</span></p>
                              
                            </div>
                            <div class="layui-col-lg6 layui-col-md6">
                              		<p class="user_info"><i class="layui-icon layui-icon-home"></i><span class="user_txt">学院：${stuinfo.collegeName }</span></p>
                                    <p class="user_info"><i class="layui-icon layui-icon-list"></i><span class="user_txt">专业：${stuinfo.majorName }</span></p>
                                    
                                    <p class="user_info"><i class="layui-icon layui-icon-tabs"></i><span class="user_txt">班级：${stuinfo.className }</span></p>
                                    <p class="user_info"><i class="layui-icon layui-icon-website"></i><span class="user_txt">邮箱：${stuinfo.email }</span></p>
                                    <p class="user_info"><i class="layui-icon layui-icon-slider"></i><span class="user_txt">身份证：${stuinfo.stucard }</span></p>
                            </div>
                        </div>
                    </div>
                </div>
						
                    </div>
                    
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
							<input type="text"  id="userid"  style="display:none;">
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
		
		
		
	</div>
	<script src="js/my.js"></script>
	
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
	
		
		
		
		
		/* 添加一个网站用户 */
		$("#up").click(function(){
			//加载角色类型
			$("#addstuname").val('${stuinfo.stuname }');
			
			$("#addagend").val('${stuinfo.agend }');
			
			$("#addbirthday").val('${stuinfo.birthday }');
			
			$("#addphone").val('${stuinfo.phone }');
			$("#addstunum").val('${stuinfo.stunum }');
			$("#addemail").val('${stuinfo.email }');
			$("#addstucard").val('${stuinfo.stucard }');
			
			var id = ${stuinfo.stuinfoid };
			
			layer.open({
				type : 1,
				title : '个人信息修改',
				area : ['660px', '665px'  ],
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
						url : 'student/upstudent?stuname='+stuname+'&agend='+agend+'&birthday='+birthday+'&phone='+phone+'&stunum='+stunum+'&email='+email+'&stucard='+stucard+'&id='+id+'&classid=0',
						datatype : 'json',
						success : function(data) {
							if (data.code == "0") {
								window.location.reload();
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
				btn2 : function() {layer.closeAll();
				
				}
				
			});
			
		});
		
		
		
		 
		
	
		
	});
	</script>
</body>
</html>