<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jquery validate</title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="jquery.validate.js"></script>
<style type="text/css">
	form label{
		color: red;
		background-image: url("image/false.png");
		background-repeat: no-repeat;
		padding-left: 23px;
	}
	.ok{
		background-image: url("image/right.png");
		background-repeat: no-repeat;
		padding-left: 23px;
	}
</style>
<script type="text/javascript">
	$(function(){
		//自定义方法，完成手机号码验证
		//name：自定义方法的名称，method：函数体， message：错误消息
		//$.validator.addMethod(name,method,message);
		$.validator.addMethod("phone",function(value,element,param){
			//value:被验证的值，element：当前验证的dom对象,param：参数，如果有多个则是数组
			//alert(value+","+$(element).val()+","+param[0]+","+param[1])
			return new RegExp("/^1[3568]\d{9}&/").test(value);
		},"手机号码不正确");
		
		$.validator.addMethod("picture",function(value,element,param){
			param = typeof param == "string" ? param:"png|jpe?g|gif";
			return this.optional(element)||value.match(new RegExp(".("+param+")$","i"));
		},"图片格式为gif,jpg,jpeg,png")
		//让当前表单调用validate方法，实现表单验证功能
		$("#ff").validate({
			debug:true,		//调试模式，即使验证成功，也不会跳转到目标页面
			onkeyup:true,	//当丢失焦点的时候才出发验证请求
			errorElement:"label",
			success:'ok',	//成功的样式
			errorPlacement:function(error,element){      //定义错误消息存放的位置
				$(element).parent().next().html(error);
			},
			rules:{		//配置验证规则 key是验证的dom对象（文本框）,value：调用的验证方法
				sname:{
					required:true, 	//如果验证方法不需要参数，则配置为true
					rangelength:[4,20],
					remote:{
						url:'ajax_check',
						type:"post"
					}
				},
				spass:{
					required:true,
					rangelength:[6,12]
				},
				spass2:{
					required:true,
					equalTo:"#spass"
				},
				slike:{
					required:true,
				},
				address:{
					required:true,
				},
				semail:{
					required:true,
					email:true
				},
				image:{
					required:true,
					picture:'gif|jpeg|jpg|png'
				},
				phone:{
					required:true,
					phone:[1,2]
				}
			},
			messages:{
				sname:{
					required:"请填写用户名", 	//如果验证方法不需要参数，则配置为true
					rangelength:"用户名长度为4~20个字符",
					remote:"用户名已被占用"
				},
				spass:{
					required:"请填写密码",
					rangelength:$.validator.format("密码长度为{0}~{1}个字符")
				},
				spass2:{
					required:"请再次输入密码",
					equalTo:"两次密码不一致"
				},
				slike:{
					required:"请选中一项",
				},
				address:{
					required:"请选择地址",
				},
				semail:{
					required:"请填写邮箱",
					email:"请输入正确的邮箱地址"
				},
			},
		});
	});
</script>
</head>
<body>
	<ul>
		<li>搭建了validate的开发环境，演示基本验证方法的使用</li>
		<li>260行，有缺省的验证配置</li>
		<li>351行，有验证方法出错的消息</li>
	</ul>
	<form id="ff" action="http://www.hao123.com" method="post">
		<table border="1" width="500">
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="sname" /></td>
				<td></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input id="spass" type="text" name="spass" /></td>
				<td></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="text" name="spass2" /></td>
				<td></td>
			</tr>
			<tr>
				<td>爱好：</td>
				<td>
					<input type="checkbox" name="slike" value="上网" />上网
					<input type="checkbox" name="slike" value="睡觉" />睡觉
					<input type="checkbox" name="slike" value="旅游" />旅游
				</td>
				<td></td>
			</tr>
			<tr>
				<td>所在地：</td>
				<td>
					<select name="address">
					<option value="">---请选择---</option>
					<option value="北京">北京</option>
					<option value="上海">上海</option>
					</select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="semail" /></td>
				<td></td>
			</tr>
			<tr>
				<td>头像：</td>
				<td><input type="file" name="image"></td>
				<td></td>
			</tr>
			<tr>
				<td>手机号码：</td>
				<td><input type="text" name="phone"></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>