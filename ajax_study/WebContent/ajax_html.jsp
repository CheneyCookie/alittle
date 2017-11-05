<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		var aNodes=document.getElementsByTagName("a");
		
		for(var i=0;i<aNodes.length;i++){
			aNodes[i].onclick=function(){
				var requset=new XMLHttpRequest();
				var method="GET";
				var url=this.href;
				
				requset.open(method, url);
				requset.send(null);
				
				
				requset.onreadystatechange=function(){
					if(requset.readyState==4){
						if(requset.status==200||requset.status==304){
							document.getElementById("details").innerHTML=requset.responseText;
						}
					}
				}
				
				return false;
			}
		}
	}
</script>

</head>
<body>
	<h1>People</h1>
	<ul>
		<li>
			<a href="files/andy.html">Andy</a>
		</li>
		<li>
			<a href="files/richard.html">Richard</a>
		</li>
		<li>
			<a href="files/jeremy.html">Jeremy</a>
		</li>
	</ul>
	<div id="details"></div>
	
</body>
</html>