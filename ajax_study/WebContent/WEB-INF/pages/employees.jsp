<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery.blockUI.js"></script>
<!-- 
	1.获取#city,添加change响应函数
	2.使#department只保留第一个option子节点
	3.获取#city选择的值，若该值为"",即选择的是"请选择",此时不需要发送Ajax请求
	4.若值不为"",说明的确是#city发生了改变，准备Ajax请求
	4.1 url:EmployeeServlet?method=listDepartments
	4.2 args:locationId,time
	5.返回的是一个JSON数组，
	5.1 若返回的数组中的元素为0：提示："当前城市没有部门"
	5.2 若返回的数组中元素不为0：遍历，创建<option value="departmentId">departmentName</option>
		并把新创建的option节点加为#department的子节点
 -->
<script type="text/javascript">
	$(function(){
		
		//使用blockUI
		//$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
		$(document).ajaxStart(function(){
			$.blockUI({
				message:$('#loading'),
				css:{
					top:($(window).height()-400)/2 + 'px',
					left:($(window).width()-400)/2 + 'px',
					width:'150px',
					border:'none',
				},
				overlayCSS:{backgroundColor:'#fff'}
			})
		}).ajaxStop($.unblockUI);
		
		$("#city").change(function(){
			$("#department option:not(:first)").remove();
			$("#employee option:not(:first)").remove();
			$("#empdetails").hide();
			var city=$(this).val();
			
			if(city!=""){
				var url="EmployeeServlet?method=listDepartments";
				var args={"locationId":city,"time":new Date()};
				
				$.getJSON(url,args,function(data){
					if(data.length==0){
						alert("当前城市没有部门");
					}else{
						for(var i=0;i<data.length;i++){
							var deptId=data[i].departmentId;
							var deptName=data[i].departmentName;
							
							$("#department").append("<option value='"+deptId+"'>"+deptName+"</option>");
						}
					}
				});
			}
		})
		
		$("#department").change(function(){
			$("#employee option:not(:first)").remove();
			$("#empdetails").hide();
			var department=$(this).val();
			if(department!=""){
				var url="EmployeeServlet?method=listEmployees";
				var args={"departmentId":department,"time":new Date()};
				
				$.getJSON(url,args,function(data){
					if(data.length==0){
						alert("当前部门没有员工");
					}else{
						for(var i=0;i<data.length;i++){
							var empId=data[i].employeeId;
							var empName=data[i].lastName;
							
							$("#employee").append("<option value='"+empId+"'>"+empName+"</option>");
						}
					}
				});
			}
		})
		
		$("#employee").change(function(){
			$("#empdetails").hide();
			var employee=$(this).val();
			if(employee!=""){
				var url="EmployeeServlet?method=information";
				var args={"employeeId":employee,"time":new Date()}
				$.getJSON(url,args,function(data){
					var id=data.employeeId;
					var name=data.lastName;
					var email=data.email;
					var salary=data.salary;
					$("#id").html(id);
					$("#name").html(name);
					$("#email").html(email);
					$("#salary").html(salary);
					
					$("#empdetails").show();
				})
			}
		});
	})
</script>

</head>
<body>
	<img alt="" id="loading" src="${pageContext.request.contextPath }/images/loading.gif" style="display: none">
	<center>
		<br><br>
		City:
		<select id="city">
			<option value="">请选择...</option>
			<c:forEach items="${locations }" var="location">
				<option value="${location.locationId}">${location.city }</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		Department:
		<select id="department">
			<option value="">请选择...</option>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		Employee:
		<select id="employee">
			<option value="">请选择...</option>
		</select>
		
		<br><br>
		<table id="empdetails" border="1" cellspacing="0" cellpadding="5" style="display: none">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Salary</th>
			</tr>
			<tr>
				<th id="id"></th>
				<th id="name"></th>
				<th id="email"></th>
				<th id="salary" ></th>
			</tr>
		</table>
		
	</center>

</body>
</html>