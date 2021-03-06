<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="testConversionServiceConverer" method="post">
		<!-- lastName-email-gender-department.id 例如：GG-gg@qq.com-0-105 -->
		Employee:<input type="text" name="employee">
		<input type="submit">
	</form>
	<br><br>
	<!-- 
		1.WHY 使用form标签？
		可以更快速地开发出表单页面，而且可以更方便地进行表单值回显
		2.注意
		可以通过modelAttrbute属性指定绑定的模型属性
		若没有指定该属性，则默认从request域对象读取command的表单bean
		如果该属性值也不存在，则会发生错误
	 -->
	 <form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
	 	
	 	<c:if test="${employee.id==null }">
	 	<!-- path属性对应html表单标签的name属性值 -->
	 	LastName:<form:input path="lastName"/>
	 	<form:errors path="lastName"></form:errors>
	 	</c:if>
	 	<c:if test="${employee.id!=null }">
	 		<form:hidden path="id"/>
	 		<input type="hidden" name="_method" value="PUT">
	 		<%-- 对于_method不能使用form:hidden标签，因为modelAttribute对应的bean中没有_method这个属性 
	 			<form:hidden path="_method" value="PUT"/>
	 		--%>
	 	</c:if>
	 	<br>
	 	Email:<form:input path="email"/>
	 	<form:errors path="email"></form:errors>
	 	<br>
	 	<%
	 		Map<String,String> genders=new HashMap<String,String>();
	 		genders.put("1", "男");
	 		genders.put("0", "女");
	 		request.setCharacterEncoding("UTF-8");
	 		response.setCharacterEncoding("UTF-8");
	 		request.setAttribute("genders", genders);
	 	%>
	 	Gender:
	 	<br>
	 	<form:radiobuttons path="gender" items="${genders }" delimiter="<br>"/>
	 	<br>
	 	Department:<form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select>
	 	<br>
	 	<!-- 
	 		1.数据类型转换
	 		2.数据类型格式化
	 		3.数据校验
	 			1)如何校验?2)注解?
	 				①.使用JSR 303验证标准
	 				②.需要加入hibernate validator验证框架
	 				③.在SpringMVC配置文件中添加<mvc:annotation-driven />
	 				④.需要在bean的属性上添加对应的注解
	 				⑤.在目标方法bean类型的前面添加@valid注解
	 			2)验证出错转向到哪一个页面?
	 			注意:需校验的Bean对象和其绑定结果对象或错误对象时成对出现，它们之间不允许声明其他的入参
	 			3)错误消息?如何显示,如何把错误消息进行国际化
	 	 -->
	 	Birth:<form:input path="birth"/>
	 	<form:errors path="birth"></form:errors>
	 	<br>
	 	Salary:<form:input path="salary"/>
	 	<input type="submit" value="submit">
	 </form:form>
</body>
</html>