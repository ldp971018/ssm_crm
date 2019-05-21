<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>员工管理页面</title>
<link rel="stylesheet" href="${path }/css/bootstrap.min.css">
</head>
<body>	
	<!-- 员工修改Modal -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">员工信息修改</h4>
	         </div>
		      <div class="modal-body">
		     	 <!-- 添加表单 -->
					 <form class="form-horizontal"  enctype="multipart/form-data" id="updateform">
					 	  <div class="form-group">
						    <label for="emp_add_upload" class="col-sm-2 control-label">员工照片</label>
						    <div class="col-sm-10">
						        <img id="emp_update_image" style="width: 140px;height:140px" class="img-circle" >
						      	<input type="file" name="uploadImage" id="emp_update_upload" onchange="previewImage('emp_update_image',this)" />
						      <!-- <p class="help-block">图片格式为.jpg文件</p> -->
						    </div>
						  </div>
						  	
					 		
						  <div class="form-group">
						    <label for="emp_add_lastname" class="col-sm-2 control-label">员工姓名</label>
							    <div class="col-sm-10">
							    	<p class="form-control-static" id="emp_p_lastname"></p>
							   	   <input type="hidden" class="form-control" name="lastname" id="emp_update_lastname" placeholder="请输入姓名">
							   	   <span class="help-block"></span>
							    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="emp_update_email" class="col-sm-2 control-label">员工邮箱</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" name="email" id="emp_update_email" placeholder="123@163.com">
						       <span class="help-block"></span>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="emp_add_birth" class="col-sm-2 control-label">员工生日</label>
						    <div class="col-sm-10">
						   <!-- <input type="date" class="form-control" name="birth" id="emp_add_birth" placeholder="请输入你的出生年月"> -->
						      <!--  <input type="text" class="form-control"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'}); " name="birth" id="emp_add_birth" placeholder="请输入你的出生年月"> -->
						  <!--   <input type="text" class="form-control" value="" name="birth" id="emp_add_createtime" placeholder="1997-10-18">	 -->
						   	<input type="text" style="width:120px;" name="birth" id="emp_update_birth"
                              onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});" placeholder="1997-10-18"/>
						    </div>
						  </div>
						  
						  <!--所属部门  -->
						 <div class="form-group">
						    <label for="emp_add_createtime" class="col-sm-2 control-label">所属部门</label>
							    <div class="col-sm-3">
							     <select name="departmentId" class="form-control" id="emp_update_dept">
								</select>
							    </div>
						 </div>
					  </form>
				      </div>
				      
	        <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
	      </div>
	    </div>
	  </div>
	</div>

	<!-- 员工添加Modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">员工信息添加</h4>
	         </div>
		      <div class="modal-body">
		     	 <!-- 添加表单 -->
					 <form class="form-horizontal"  enctype="multipart/form-data" id="myform">
						  <div class="form-group">
						    <label for="emp_add_lastname" class="col-sm-2 control-label">员工姓名</label>
							    <div class="col-sm-10">
							   	   <input type=text class="form-control" name="lastname" id="emp_add_lastname" placeholder="请输入姓名">
							   	     <span class="help-block"></span>
							    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="emp_add_email" class="col-sm-2 control-label">员工邮箱</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" name="email" id="emp_add_email" placeholder="123@163.com">
						       <span class="help-block"></span>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="emp_add_birth" class="col-sm-2 control-label">员工生日</label>
						    <div class="col-sm-10">
						   <!-- <input type="date" class="form-control" name="birth" id="emp_add_birth" placeholder="请输入你的出生年月"> -->
						      <!--  <input type="text" class="form-control"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'}); " name="birth" id="emp_add_birth" placeholder="请输入你的出生年月"> -->
						  <!--   <input type="text" class="form-control" value="" name="birth" id="emp_add_createtime" placeholder="1997-10-18">	 -->
						   	<input type="text" style="width:120px;" name="birth"
                              onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});" placeholder="1997-10-18"/>
						    </div>
						  </div>
						  
						<div class="form-group">
						    <label for="emp_add_createtime" class="col-sm-2 control-label">入职时间</label>
						    <div class="col-sm-10">
						       <input type="text" class="form-control" value="<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd HH:mm:ss"/>" name="createtime" id="emp_add_createtime" placeholder="1997-10-18">
						    </div>
						  </div>
						   
						  <div class="form-group">
						    <label for="emp_add_upload" class="col-sm-2 control-label">员工照片</label>
						    <div class="col-sm-10">
						      <input type="file" name="upload" id="emp_add_upload" onchange="previewImage('preview',this)" />
						      <img  id="preview" style="width: 140px;height:140px" class="img-circle">
						      <p class="help-block">图片格式为.jpg文件</p>
						    </div>
						  </div>
						  	
						  <!--所属部门  -->
						 <div class="form-group">
						    <label for="emp_add_createtime" class="col-sm-2 control-label">所属部门</label>
							    <div class="col-sm-3">
							        <select name="departmentId" class="form-control" id="emp_select_dept">
								 </select>
							    </div>
						 </div>
					  </form>
				      </div>
				      
	        <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="emp_save_btn">添加</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 显示区域 -->
	<div class="container">
		<!-- 标题  -->
		<div class="row">
			<div class="col-md-12">
				<h1 class="">SpringMVC-Spring-Mybatis-员工管理页面</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-10">
				<button class="btn btn-primary btn-sm" data-toggle="modal">
					<span class="glyphicon glyphicon-plus" id="emp_add_btn"/> 添加
				</button>
				<button class="btn btn-danger btn-sm">
					<span class="glyphicon glyphicon-trash" id="emp_delete_all_btn"/> 删除
				</button>
			</div>
		</div>
		<!-- 显示页面的表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover table-bordered" id="page_table">
					<thead align="center">
						<tr>
							<th>
								<input type="checkbox" id="check_all"/>
							</th>
							<th align="center">编号</th>
							<th>员工姓名</th>
							<th>员工邮箱</th>
							<th>员工生日</th>
							<th>入职时间</th>
							<th>所属部门</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody align="center">
					</tbody>
				</table>
			</div>
		</div>
		<!-- 分页条 -->
		<div class="row">
			<!-- 分页后的相关描述 -->
			<div class="col-md-6" id="page_info">
			</div>
			<!-- 分页的效果 -->
			<div class="col-md-6" id="page_nav">
			</div>
		</div>
	</div>
</body>
<script src="${path }/js/jquery.min.js"></script>
<script src="${path }/js/date.js"></script>
<script src="${path }/js/bootstrap.min.js"></script>
<script src="${path}/js/WdatePicker.js"></script>
<script type="text/javascript">

 	//定义一个全局的总记录数
 	var totalRecord,currentPage;
	//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
	$(function(){
		//去首页
		to_page(1);
	});
	
	/* 页面加载之后发送Ajax请求 */
	function to_page(pageNum){
		$.ajax({
			   type: "GET",
			   url:"${path}/empAll",
			   data:"pageNum="+pageNum,
			   success: function(result){
				   	//解析并显示员工数据
				   emp_table(result);
				   	//显示分页信息
				   page_info(result);
				   	//显示分页条数据
				   page_nav(result);
			   }
			});
	}
	
	//显示员工表格信息
	function emp_table(result){
		$("#page_table tbody").empty();
		var emps = result.extend.pageInfo.list;
		//第一个参数表示要遍历的参数，index表示索引下表，emp表示当前遍历 到的数据
		$.each(emps,function(index,emp){
			//添加选择框
			var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
			//将emp中的取出
			var id=$("<td></td>").append(emp.id);
			var lastname=$("<td></td>").append(emp.lastname);
			var email=$("<td></td>").append(emp.email);
			var birth=transferTime(emp.birth);
			var birth=$("<td></td>").append(birth);
			var createtime=transferTime(emp.createtime);
			var createtime=$("<td></td>").append(createtime);
			var departmentname=$("<td></td>").append(emp.department.departmentname);
			/* <button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-plus"/> 添加</button>
			<button class="btn btn-success btn-sm"><span class="glyphicon glyphicon-search"/> 查看</button>
			<button class="btn btn-info btn-sm"><span class="glyphicon glyphicon-pencil"/> 编辑 </button>
			<button class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"/> 删除</button> */
			var btn_add=$("<button></button>").addClass("btn btn-primary btn-sm empAdd")
			.append("<span></span>").addClass("glyphicon glyphicon-plus").append(" 添加");
			 var btn_search=$("<button></button>").addClass("btn btn-success btn-sm empView")
			.append("<span></span>").addClass("glyphicon glyphicon-search").append(" 查看");
			var btn_pencil=$("<button></button>").addClass("btn btn-info btn-sm empEdit")
			.append("<span></span>").addClass("glyphicon glyphicon-pencil").append(" 编辑");
			//为编辑按钮提供一个属性值，即为员工的id值，便于后期的查询
			btn_pencil.attr("edit-id",emp.id);
			var btn_trash=$("<button></button>").addClass("btn btn-danger btn-sm empDelete")
			.append("<span></span>").addClass("glyphicon glyphicon-trash").append(" 删除");
			//为删除按钮提供一个属性值，即为员工的id值，便于后期的删除
			btn_trash.attr("delete-id",emp.id);
			var caozuo=$("<td></td>").append(btn_add).append(btn_search).append(btn_pencil).append(btn_trash);
			var tr=$("<tr></tr>").append(checkBoxTd)
			 .append(id)
			 .append(lastname)
			 .append(email)
			 .append(birth)
			.append(createtime)
			.append(departmentname)
			.append(departmentname)
			.append(caozuo)
			.appendTo("#page_table tbody");
		});
	}
	
	/* 显示分页条信息 */
	function page_info(result){
		$("#page_info").empty();
		$("#page_info").append("当前"+result.extend.pageInfo.pageNum+" 页，总"+result.extend.pageInfo.pages+" 页，总共 "+result.extend.pageInfo.total+"记录");
		totalRecord = result.extend.pageInfo.total;
		currentPage = result.extend.pageInfo.pageNum;
	}
	
	/* 显示分页条数据 */
	function page_nav(result){
		//page_nav
		$("#page_nav").empty();
		var ul = $("<ul></ul>").addClass("pagination");
		//构建元素
		var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if(result.extend.pageInfo.hasPreviousPage == false){
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		}else{
			//为元素添加点击翻页的事件
			firstPageLi.click(function(){
				to_page(1);
			});
			prePageLi.click(function(){
				to_page(result.extend.pageInfo.pageNum -1);
			});
		}
		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
		if(result.extend.pageInfo.hasNextPage == false){
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		}else{
			nextPageLi.click(function(){
				to_page(result.extend.pageInfo.pageNum +1);
			});
			lastPageLi.click(function(){
				to_page(result.extend.pageInfo.pages);
			});
		}
		
		//添加首页和前一页 的提示
		ul.append(firstPageLi).append(prePageLi);
		//1,2，3遍历给ul中添加页码提示
		$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
			
			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if(result.extend.pageInfo.pageNum == item){
				numLi.addClass("active");
			}
			numLi.click(function(){
				to_page(item);
			});
			ul.append(numLi);
		});
		
		//添加下一页和末页 的提示
		ul.append(nextPageLi).append(lastPageLi);
		
		//把ul加入到nav
		var navEle = $("<nav></nav>").append(ul);
		
		navEle.appendTo("#page_nav");
	}
	          //改变时间
	 function transferTime(cTime) {
	        //将json串的一串数字进行解析
	        var jsonDate = new Date(parseInt(cTime));
	        //为Date对象添加一个新属性，主要是将解析到的时间数据转换为我们熟悉的“yyyy-MM-dd hh:mm:ss”样式
		        Date.prototype.format = function(format) {
			        var o = {
			        //获得解析出来数据的相应信息，可参考js官方文档里面Date对象所具备的方法
			        "y+" : this.getFullYear(),//得到对应的年信息
			        "M+" : this.getMonth() + 1, //得到对应的月信息，得到的数字范围是0~11，所以要加一
			        "d+" : this.getDate(), //得到对应的日信息
			        "h+" : this.getHours(), //得到对应的小时信息 
			        "m+" : this.getMinutes(), //得到对应的分钟信息
			        "s+" : this.getSeconds(), //得到对应的秒信息
			        }
			      //将年转换为完整的年形式
				     if (/(y+)/.test(format)) {
					    format = format.replace(RegExp.$1,
					    (this.getFullYear() + "")
					   .substr(4 - RegExp.$1.length));
				    }
			    //连接得到的年月日 时分秒信息
			   for ( var k in o) {
				   if (new RegExp("(" + k + ")").test(format)) {
				   format = format.replace(RegExp.$1,
				   RegExp.$1.length == 1 ? o[k] : ("00" + o[k])
				  .substr(("" + o[k]).length));
				   }
			   }
			    return format;
		    }
	 	/* 開始转换 */
		 var newDate = jsonDate.format("yyyy-MM-dd");
		 return newDate;
	 }   
	 //清空表单中数据以及提示信息的样式和数据
	function reset_form(ele){
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
   }    
	 //清空表单中数据以及提示信息的样式和数据
	function reset_updateform(ele){
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
   }    
	 
	 //打开添加的模态框
	 $("#emp_add_btn").click(function(){
		 //每次弹出模态框，清除上一次的记录
		 reset_form("#myform");
		 //调用查询部门信息的方法
		 deptAll("#emp_select_dept");
		 $("#addModal").modal({
			 backdrop:'static'
		 });
	 });
	 
	 //查询出部门信息到下拉框
	 function deptAll(ele){
		 $.ajax({
			 url:"${path}/deptAll",
			 type:"GET",
			 success:function(result){
				 $(ele).empty();
				 //往emp_select_dept中添加数据
				// $("#emp_select_dept").append()
				$.each(result.extend.depts,function(index,dept){
					var option=$("<option></option>").append(dept.departmentname).attr("value",dept.id);
					option.appendTo(ele);
				});
			 }
		 });
	 }
	 
	 //校验照片格式
	  function previewImage(preImageId, imageFile) {
	        var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
	        if (!pattern.test(imageFile.value)) {
	            alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
	            imageFile.focus();
	            $(imageFile).val("");
	            return false;
	        } else {
	            var path;
	            if (document.all)//IE
	            {
	                imageFile.select();
	                path = document.selection.createRange().text;
	            }
	            else//FF
	            {
	                path = URL.createObjectURL(imageFile.files[0]);
	            }
	            $('#' + preImageId).attr('src', path);
	        }
	    }
	 
	 //jQuery表单校验表单数据
		function validate_add_form(){
			//1、拿到要校验的数据，使用正则表达式
			var empName = $("#emp_add_lastname").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regName.test(empName)){
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#emp_add_lastname", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
				return false;
			}else{
				show_validate_msg("#emp_add_lastname", "success", "");
			};
			
			//2、校验邮箱信息
			var email = $("#emp_add_email").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				//alert("邮箱格式不正确");
				//应该清空这个元素之前的样式
				show_validate_msg("#emp_add_email", "error", "邮箱格式不正确");
				/* $("#email_add_input").parent().addClass("has-error");
				$("#email_add_input").next("span").text("邮箱格式不正确"); */
				return false;
			}else{
				show_validate_msg("#emp_add_email", "success", "");
			}
			return true;
		}
	 
	 //1.显示校验结果的提示信息
		function show_validate_msg(ele,status,msg){
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if("success"==status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error" == status){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
	 //2.添加员工之前还需要校验是否存在该用户
	 $("#emp_add_lastname").change(function(){
		 var lastname=this.value; //获取输入的框中的值
		 //发送ajax请求到服务器
		 $.ajax({
			 url:"${path}/checkLastname",
			 type:"POST",
			 data:"lastname="+lastname,
			 success:function(result){
				 if(result.code==100){
					 show_validate_msg("#emp_add_lastname", "success", "");
					 $("#emp_save_btn").attr("ajax-check","success");
				 }else{
					 show_validate_msg("#emp_add_lastname", "error",result.extend.checkname_msg);
					 $("#emp_save_btn").attr("ajax-check","error");
				 }
			 }
		 });
	 });
	 //添加客户信息
	 $("#emp_save_btn").click(function(){
		 
		 //1、先对要提交给服务器的数据进行校验
	 	if(!validate_add_form()){
				return false;
			};
			
			//1、判断之前的ajax用户名校验是否成功。如果成功。
			if($(this).attr("ajax-check")=="error"){
				return false;
			}
		  
		 //发送ajax请求到服务器保存数据
		/*  alert($("#addModal form").serialize()); */
		 var form = new FormData(document.getElementById("myform"));
		 $.ajax({
			 url:"${path}/emp",
			 processData: false,
		     contentType: false,
			 type:"POST",
			 data:form,
			 success:function(result){
				//判断返回的状态信息，进行相应的操作 100表示成功，200表示错误
				if(result.code==100){
					 alert(result.msg);
					 //关闭模态框
					 $("#addModal").modal('hide');
					 //跳转到页面最后一条记录
					 to_page(totalRecord);
				}else{
					//显示失败信息
					//console.log(result);
					//有哪个字段的错误信息就显示哪个字段的；
					if(undefined != result.extend.errorFields.email){
						//显示邮箱错误信息
						show_validate_msg("#email_add_input", "error", result.extend.errorFields.email);
					}
					
					if(undefined != result.extend.errorFields.lastname){
						//显示员工名字的错误信息
						show_validate_msg("#empName_add_input", "error", result.extend.errorFields.lastname);
					}
				}
			 }
		 });
	 });
	 
	 
	 //给添加按钮绑定事件
	 $(document).on("click",".empAdd",function(){
		 //每次弹出模态框，清除上一次的记录
		 reset_form("#myform");
		 //调用查询部门信息的方法
		 deptAll("#emp_select_dept");
		 $("#addModal").modal({
			 backdrop:'static'
		 });
	 });
	 
	 //给编辑按钮绑定事件
	 $(document).on("click",".empEdit",function(){
		 //获取到编辑按钮的属性值
		 var id=$(this).attr("edit-id");
		 //将编辑按钮上的属性值传递到更新按钮上，设置属性并赋值
		 $('#emp_update_btn').attr("edit-id",id);
		 //每次弹出模态框，清除上一次的记录
			  reset_updateform("#updateform"); 
		 //0.调用查询部门信息的方法
		 	deptAll("#emp_update_dept");
		 //1.查询出员工的数据
		 	getEmp(id);
		  //弹出模态框
		 $("#updateModal").modal({
			 backdrop:'static'
		 });
	 });
	 
	 //给删除按钮绑定事件
	  $(document).on("click",".empDelete",function(){
		//1、弹出是否确认删除对话框
			var lastname = $(this).parents("tr").find("td:eq(2)").text();
			var empId = $(this).attr("delete-id");
			//alert($(this).parents("tr").find("td:eq(1)").text());
			if(confirm("确认删除【"+lastname+"】吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${path}/emp/"+empId,
					type:"DELETE",
					success:function(result){
						alert("删除成功");
						//回到本页
						to_page(currentPage);
					}
				});
			}
	  });
	 
		//完成全选/全不选功能
		$("#check_all").click(function(){
			//attr获取checked是undefined;
			//我们这些dom原生的属性；attr获取自定义属性的值；
			//prop修改和读取dom原生属性的值
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		
		//check_item
		$(document).on("click",".check_item",function(){
			//判断当前选择中的元素是否5个
			var flag = $(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag);
		});

	  //改变时间
	 function transferTime1(cTime) {
	        //将json串的一串数字进行解析
	        var jsonDate = new Date(parseInt(cTime));
	        //为Date对象添加一个新属性，主要是将解析到的时间数据转换为我们熟悉的“yyyy-MM-dd hh:mm:ss”样式
		        Date.prototype.format = function(format) {
			        var o = {
			        //获得解析出来数据的相应信息，可参考js官方文档里面Date对象所具备的方法
			        "y+" : this.getFullYear(),//得到对应的年信息
			        "M+" : this.getMonth() + 1, //得到对应的月信息，得到的数字范围是0~11，所以要加一
			        "d+" : this.getDate(), //得到对应的日信息
			        "h+" : this.getHours(), //得到对应的小时信息 
			        "m+" : this.getMinutes(), //得到对应的分钟信息
			        "s+" : this.getSeconds(), //得到对应的秒信息
			        }
			      //将年转换为完整的年形式
				     if (/(y+)/.test(format)) {
					    format = format.replace(RegExp.$1,
					    (this.getFullYear() + "")
					   .substr(4 - RegExp.$1.length));
				    }
			    //连接得到的年月日 时分秒信息
			   for ( var k in o) {
				   if (new RegExp("(" + k + ")").test(format)) {
				   format = format.replace(RegExp.$1,
				   RegExp.$1.length == 1 ? o[k] : ("00" + o[k])
				  .substr(("" + o[k]).length));
				   }
			   }
			    return format;
		    }
	 	/* 開始转换 */
		 var newDate = jsonDate.format("yyyy-MM-dd hh:mm:ss");
		 return newDate;
	 }   
	 //查询数据到静态框中
	 function getEmp(id){
		 
		 $.ajax({
			 url:"${path}/emp/"+id,
			 type:"GET",
			 success:function(result){
				 var emp=result.extend.emp;
				 var birth=transferTime1(emp.birth);//将日期格式化
				 $('#emp_update_image').attr("src","${path}/"+emp.empImage);
				 $('#emp_p_lastname').text(emp.lastname);  
				 $('#emp_update_lastname').val(emp.lastname);  
				 $('#emp_update_email').val(emp.email);  
				 $('#emp_update_birth').val(birth);  
				 $('#updateform select').val(emp.department.id);
			 }
		 });
	 }
	 
	 //设置更新点击的事件
	 $("#emp_update_btn").on("click",function(){
		 //1.获取到更新按钮上的id值
			 var id=$(this).attr("edit-id"); 
		 //2.获取到表单中值
		     var form = new FormData(document.getElementById("updateform"));
		 //3.验证修改后的邮箱格式是否正确
		    var email = $("#emp_update_email").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				show_validate_msg("#emp_update_email", "error", "邮箱格式不正确");
				return false;
			}else{
					show_validate_msg("#emp_update_email", "success", "");
			}
		//4、发送ajax请求保存更新的员工数据
			$.ajax({
				url:"${path}/empUpdate/"+id,
				 processData: false,
			    contentType: false,
				type:"POST",
				data:form,
				success:function(result){
					//1、关闭对话框
					$("#updateModal").modal("hide");
					//2、回到本页面
					to_page(currentPage);
				}
			});
	 });
			
	 //点击删除按钮进行批量删除的操作
	 $("#emp_delete_all_btn").click(function(){
		 //
			var empNames = "";
			var del_idstr = "";
			$.each($(".check_item:checked"),function(){
				//this
				empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
				//组装员工id字符串
				del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			//去除empNames多余的,
			empNames = empNames.substring(0, empNames.length-1);
			//去除删除的id多余的-
			del_idstr = del_idstr.substring(0, del_idstr.length-1);
			if(confirm("确认删除【"+empNames+"】吗？")){
				//发送ajax请求删除
				$.ajax({
					url:"${path}/emp/"+del_idstr,
					type:"DELETE",
					success:function(result){
						alert("删除成功");
						//回到当前页面
						to_page(currentPage);
					}
				});
			}
	 });
	 
</script>
</html>