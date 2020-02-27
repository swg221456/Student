
		layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
			
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
			
			//日期选择器
			laydate.render({ 
			  elem: '#addbirthday'
			  //,type: 'date' //默认，可不填
			});
			/* 点击登录 */
			$("#login-button").click(function(){
				var username=$("#user_name").val().trim();
				var password=$("#user_password").val().trim();
		
				if(username==null || username=="" || username==undefined){
				layer.tips('用户名不能为空！', '#user_name', {
					tips : [ 1, '#3595CC' ],
					time : 3000
				});
					$("#user_name").focus();
					return;
				}
				if(password==null || password=="" || password==undefined){
				layer.tips('密码不能为空！', '#user_password', {
					tips : [ 1, '#3595CC' ],
					time : 3000
				});
					$("#user_password").focus();
					return;
				}
				if(password.length<6 || password.length>18){
				layer.tips('密码长度不符合规范！', '#user_password', {
					tips : [ 1, '#3595CC' ],
					time : 3000
				});
					return;
				}
				
				//var enpwd = hex_md5(fix(username,password));
				//$("#inppassword").val(enpwd);
				
				//alert(enpwd);
				$.ajax({
					type : 'get',
					url : '../admin/adminlogin?userid='+username+'&pwd='+password,
					datatype : 'json',
					beforeSend:function(){
					//layer.load(0, {shade: false});
					},
					success : function(data) {
						if (data.code == 0) {
						layer.msg(data.msg);
						//layer.alert(data.msg, {icon: 1});
						if (top.location !== self.location) {
   							 top.location = "index.jsp";//跳出框架，并回到首页
			         	}else{
			         		window.location.href = "../html/index.jsp";
			         	}
						
						} else {
							layer.alert(data.msg, {icon: 2});
							$("input").val("");
						}
					},
					error:function(){
					
	    	        	layer.alert("后台报错", {icon: 2});
	    	        },
	    	       /* complete:function(){
	    	        layer.alert("操作完成");
	    	        }*/
				});
			
			});
			
			$("#add-button").click(function(){
				
			window.location.href = "../html/add.html";
			
			});
			
			
			/* 添加一个用户 */
		$("#adduser").click(function(){
			//加载角色类型
			loadRoleType('addusertype',form);
			$("#addnoticeName").val("");
			$("#addnoticecontent").val("");
			$("#addremarks").val("");
			layer.open({
				type : 1,
				title : '用户注册',
				area : [ '460px', '345px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '下一步', '返回' ],
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
						url : '../admin/adduser?userid='+addUserName+'&pwd='+pwd+'&roleid='+usertype+'&realname='+realname,
						datatype : 'json',
						success : function(data) {
							if (data.code == "0") {
								if(usertype != 12){
									var laji = layer.open({
										type : 1,
										title : '教师用户添加',
										area :  [ '460px', '400px' ],
										shade : 0.4,
										content : $('#add-teacher'),
										btn : [ '保存'],
										yes: function(){
											var addteaName = $("#addteaName").val().trim();
											var addteaphone = $("#addteaphone").val().trim();
											var addteasex = $("#addteasex").val();
						
											if(addteaName == "") {
												layer.tips('不能为空', '#addteaName');
												return;
											} 
											if(addteaphone==""){
												layer.tips('不能为空', '#addteaphone');
												return;
											}
											
											$.ajax({
												type : 'get',
												url : '../admin/addteach?teaName='+addteaName+'&teaphone='+addteaphone+'&teasex='+addteasex,
												datatype : 'json',
												success : function(data) {
													if (data.code == "0") {
														layer.confirm(data.msg, {
														  btn: ['确定'],
														  icon:1
														  
														}, function(){
															
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
									});
								
								}else{
									var laji = layer.open({
										type : 1,
										title : '学生用户添加',
										area :  [ '560px', '665px' ],
										shade : 0.4,
										content : $('#add-stu'),
										btn : [ '保存'],
										yes: function(){
											var stuname = $("#addstuname").val();
											var agend = $("#addagend").val();
											var birthday = $("#addbirthday").val().trim();
											var phone = $("#addphone").val().trim();
											var stunum = $("#addstunum").val().trim();
											var email = $("#addemail").val().trim();
											var stucard = $("#addstucard").val().trim();
											var classid = $("#slclass").val().trim();
						
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
												url : '../admin/addstu?stuname='+stuname+'&agend='+agend+'&birthday='+birthday+'&phone='+phone+'&stunum='+stunum+'&email='+email+'&stucard='+stucard+'&classid='+classid,
												datatype : 'json',
												success : function(data) {
													if (data.code == "0") {
														layer.confirm(data.msg, {
														  btn: ['确定'],
														  
														  icon:1
														}, function(){
															$.ajax({
																	type : 'get',
																	url : '../admin/adminlogin?userid='+addUserName+'&pwd='+pwd,
																	datatype : 'json',
																	beforeSend:function(){
																	//layer.load(0, {shade: false});
																	},
																	success : function(data) {
																		if (data.code == 0) {
																		layer.msg(data.msg);
																		//layer.alert(data.msg, {icon: 1});
																		if (top.location !== self.location) {
												   							 top.location = "index.jsp";//跳出框架，并回到首页
															         	}else{
															         		window.location.href = "../html/index.jsp";
															         	}
																		
																		} else {
																			layer.alert(data.msg, {icon: 2});
																			$("input").val("");
																		}
																	},
																	error:function(){
																	
													    	        	layer.alert("后台报错", {icon: 2});
													    	        },
													    	       /* complete:function(){
													    	        layer.alert("操作完成");
													    	        }*/
																});
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
									});
									
								
								}
								
								
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
			
			
		
			
		
			
	});
