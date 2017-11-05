<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("a").click(function(){
			var url=this.href;
			var args={"time":new Date()};
			
			/*
				url:
				args:JSON格式
				function:回调函数:当响应结束时，回调函数被触发。响应结果在data中
			*/
			
			//$.get(url,args,function(data){
			$.post(url,args,function(data){
				var name=$(data).find("name").text();
				var email=$(data).find("email").text();
				var website=$(data).find("website").text();
				
				//alert(name)
				//alert(email)
				//alert(website)
				
				$("#details").empty()
							.append("<h2><a href='mailto:"+email+"'>"+name+"</a></h2>")
							.append("<a href='"+website+"'>"+website+"</a>");
			});
			return false;
		})
	})
</script>

</head>
<body>
	<h1>People</h1>
	<ul>
		<li>
			<a href="files/andy.xml">Andy</a>
		</li>
		<li>
			<a href="files/richard.xml">Richard</a>
		</li>
		<li>
			<a href="files/jeremy.xml">Jeremy</a>
		</li>
	</ul>
	<div id="details"></div>
	
</body>
</html>