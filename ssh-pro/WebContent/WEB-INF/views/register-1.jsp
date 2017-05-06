<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- 使用 sx:datetimrpicker 标签来显示日期，必须引入dojo插件，将struts2-dojo-plugin.jar加入 -->
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 必须设置 sx:head dojo 标签才能生效 -->
<sx:head debug="false" cache="false" compressed="false" parseContent="true" extraLocales="UTF-8"/>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

	
</script>
</head>
<body>
<h4>注册</h4>

	
	
	<s:form action="user-save" method="post" validate="true">
		<s:textfield name="username" label="用户名"></s:textfield>
		<s:password name="password" label="密码"></s:password>
		<sx:datetimepicker label="出生日期" name="birth" displayFormat="yyyy-MM-dd" language="UTF-8"></sx:datetimepicker>
		<s:radio name="gender" label="性别"  list="#{'男':'男','女':'女','保密':'保密' }" value="2"></s:radio>
		<s:textfield name="email" label="电子邮件"></s:textfield>
		<s:submit value="注册"></s:submit>
	</s:form>
	
</body>
</html>