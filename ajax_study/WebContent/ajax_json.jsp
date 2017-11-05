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
							//1.结果为xml格式，所以需要使用responseXML来获取
							var result=requset.responseText;
							var object=eval("("+ result +")");
							
							//2.结果不能直接使用，必须先创建对应的节点，再把节点加入到#details中
							//目标格式为：
							/*<h2><a href="mailto:andy@qq.com">Andy</a></h2>
							<a href="http://andy.com">http://andy.com</a>
							*/
							var name=object.person.name;
							var website=object.person.website;
							var email=object.person.email;
							
							//alert(name)
							//alert(website)
							//alert(email)
							
							var aNode=document.createElement("a");
							aNode.appendChild(document.createTextNode(name));
							aNode.href="mailto"+email;
							
							var h2Node=document.createElement("h2");
							h2Node.appendChild(aNode);
							
							var aNode2=document.createElement("a");
							aNode2.appendChild(document.createTextNode(website));
							aNode2.href=website;
							
							var detailsNode=document.getElementById("details");
							
							detailsNode.innerHTML="";
							detailsNode.appendChild(h2Node);
							detailsNode.appendChild(aNode2);
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
			<a href="files/andy.json">Andy</a>
		</li>
		<li>
			<a href="files/richard.json">Richard</a>
		</li>
		<li>
			<a href="files/jeremy.json">Jeremy</a>
		</li>
	</ul>
	<div id="details"></div>
	
</body>
</html>