<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<div style="width: 400px; height: 300px;">
		<form action="${pageContext.request.contextPath }/userController/login.do" method="post" enctype="multipart/form-data">
			用户名： <input type="text" name="name" /><br>
			密 码： <input type="text" name="pwd"><br>
			上传图片：<input type="file" name="file" /><br>
			<input type="submit" value="登录" /> <input type="button" value="注册"> 
		</form>
	</div>
</body>
</html>