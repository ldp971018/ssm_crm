<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setAttribute("path", request.getContextPath());
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>员工管理页面</title>
<link rel="stylesheet" href="${path }/css/bootstrap.min.css">
<link rel="stylesheet" href="${path }/css/style.css" />
</head>
<body>	
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
				<button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-plus"/> 添加</button>
				<button class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"/> 删除</button>
			</div>
		</div>
		<!-- 显示页面的表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover table-bordered">
					<tbody align="center">
						<tr>
							<th align="center">编号</th>
							<th>员工姓名</th>
							<th>员工邮箱</th>
							<th>员工生日</th>
							<th>入职时间</th>
							<th>所属部门</th>
							<th>操作</th>
						</tr>	
				<c:forEach items="${pageInfo.list }" var="emp">
						<tr>
							<td>${emp.id}</td>
							<td>${emp.lastname }</td>
							<td>${emp.email }</td>
							<td><fmt:formatDate value="${emp.birth }" pattern="yyyy-MM-dd"/></td>
							<td><fmt:formatDate value="${emp.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${emp.department.departmentname }</td>
							<td>
								<button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-plus"/> 添加</button>
								<button class="btn btn-success btn-sm"><span class="glyphicon glyphicon-search"/> 查看</button>
								<button class="btn btn-info btn-sm"><span class="glyphicon glyphicon-pencil"/> 编辑 </button>
								<button class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"/> 删除</button>
							</td>
						</tr>	
				</c:forEach>				
					</tbody>
				</table>
			</div>			
		</div>
		<!-- 分页条 -->
		<div class="row">
			<div class="col-md-6">
				<p class="h5">当前${pageInfo.pageNum }页，总${pageInfo.pages }页，总共${pageInfo.total }记录</p>
			</div>
			<div class="col-md-6">
					<nav aria-label="Page navigation">
					  <ul class="pagination">
					 		  <li><a href="${path}/empAll?pageNum=1">首页</a></li>
					    <li>
					     <c:if test="${pageInfo.hasPreviousPage}">
						      <a href="${path}/empAll?pageNum=${pageInfo.pageNum - 1}" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
					      </c:if>
					      </li>
							    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
							    	<c:if test="${pageNum ==pageInfo.pageNum }">
							     		<li class="active"><a href="${path}/empAll?pageNum=${pageNum}">${pageNum}</a></li>
							    	</c:if>
							    	<c:if test="${pageNum !=pageInfo.pageNum }">
							     		<li><a href="${path}/empAll?pageNum=${pageNum}">${pageNum}</a></li>
							    	</c:if>
							    	
							    </c:forEach>
							<li>  
						   <c:if test="${pageInfo.hasNextPage}">
						      <a href="${path}/empAll?pageNum=${pageInfo.pageNum+1}" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
					      </c:if>
					      </li>
					      
						   	<li>
						     <a href="${path}/empAll?pageNum=${pageInfo.pages}">尾页</a>
							</li>
					  </ul>
				</nav>
			</div>
		</div>
	</div>
</body>
<script src="${path }/js/jquery.min.js"></script>
<script src="${path }/js/bootstrap.min.js"></script>
</html>