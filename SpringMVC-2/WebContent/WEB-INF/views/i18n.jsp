<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<fmt:message key="i18n.user"></fmt:message>
	<br><br>
	<a href="i18n2">I18N2 PAGE</a>
	<br><br>
	<a href="i18n2?locale=zh_CN">中文</a>
	<br><br>
	<a href="i18n2?locale=en_US">英文</a>
</body>
</html>