<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var objectList = new Array();
	function Persion(name,age){
	    this.name=name;
	    this.age=age;
	    }
	objectList.push(new Persion('jack',20));
	objectList.push(new Persion('tony',25));
	objectList.push(new Persion('stone',26));
	objectList.push(new Persion('mandy',23));
	//按年龄从小到大排序
	objectList.sort(function(a,b){
	    return a.age-b.age});
	for(var i=0;i<objectList.length;i++){
	    document.writeln('<br />age:'+objectList[i].age+' name:'+objectList[i].name);
	    }
</script>
</head>
<body>

</body>
</html>