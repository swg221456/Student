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
		var calssid="";		
		form.on('select(slclass)', function(data)
				{
				 calssid = $("#slclass").val();
			 	//调用方法加载select管理员角色
				loadcourseby("slcouser", form, "../curr/loacdcourseby?classid="+calssid);
				});
		form.on('select(slcouser)', function(data)
				{
				var courseid = $("#slclass").val();
			 	//调用方法加载select管理员角色
				addsheet(calssid,courseid);
				select(calssid,courseid);
				});
		
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'adminUserid',
			url : '../student/getsheets',
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
     				field : 'className',
     				align : 'center',
     				title : '班级名称',
   
    			},{
     				field : 'curriculumName',
     				align : 'center',
     				title : '课程名称',
   
    			},{
     				field : 'teaName',
     				align : 'center',
     				title : '教师名称',
   
    			},{
     				field : 'stuname',
     				align : 'center',
     				title : '学生名称',
   
    			},{
     				field : 'fraction',
     				align : 'center',
     				title : '成绩',
     				edit: 'text',
   
    			},{
     				field : 'evaluate',
     				align : 'center',
     				title : '评价',
     				edit: 'text',
   
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
			var slcouser=$("#slcouser").val();
			table.reload('adminUserid', {
				method : 'post',
				where : {
					'classid' : slclass,
					'couserid' : slcouser
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
		    
		    upsheet(data.sheetid,data.fraction,data.evaluate,data.courseid,data.stuinfoid);
		  });
	
		  
		  function upsheet(id,fraction,evaluate,courseid,stuinfoid) {
				$.ajax({
					type: 'get',
					url: "../student/upsheet?sheetid="+id+"&fraction="+fraction+"&evaluate="+evaluate+"&courseid="+courseid+"&stuinfoid="+stuinfoid,
					datatype: 'json',
					success: function(data) {
						
					},
					error: function() {
						layer.msg('修改失败！', function(){});
					}
				});
				
			}
		
		
		function addsheet(classid, courseid) {
			$.ajax({
				type: 'get',
				url: "../student/addsheet?classid="+classid+"&courseid="+courseid,
				datatype: 'json',
				success: function(data) {
					
				},
				error: function() {
					layer.msg('未获取到用户信息！', function(){});
				}
			});
			
		}
		
		function select(classid, courseid) {
			
			table.reload('adminUserid', {
				method : 'post',
				where : {
					'classid' : classid,
					'couserid' : courseid
						},
				page : {
					curr : 1
					}
			});
		}
	
	});