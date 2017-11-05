<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//1.当整个HTML文档完全加载成功后出发window.onload事件
	window.onload=function(){
		//2.获取所有的button节点，并取得第一个元素
		var btn=document.getElementsByTagName("button")[0];
		//3.为button的Onclick事件赋值：当点击button时，执行函数体
		btn.onclick=function(){
			alert("helloworld");
		}
	}
</script>

</head>
<body>
	<button>ClickMe</button>
	<!-- 
	<button onclick="alert('helloworld...')">ClickMe</button>
	 -->
</body>
</html>
<!-- 在整个html文档加载后，获取其中的节点，把script节点放在html文档最后，但不符合写js代码的习惯 -->
<script type="text/javascript"></script>