<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大眼睛房地产</title>
<jsp:include page="inc.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$("#dd").show().dialog("open");
		$('#tt').tree({    
		    url:'${pageContext.request.contextPath}/menuController/initTree.do',
		    loadFilter: function(data){    
		        if (data.success){    
		            return data.object;    
		        } else {    
		            return data.msg;    
		        }    
		    },
		    onLoadSuccess:function(node, data){
    			var t = $(this);
    			if(data) {
    				$(data).each(function(index, d){
    					if(this.state == 'closed') {
    						t.tree('expandAll');
    					}
    				});
    			}
    		},
			onClick: function(node){
    			console.info(node);
    			var url = '${pageContext.request.contextPath}' + node.attributes.url;
    			addTab({
					title:node.text,
					closable:true,
					content:'<iframe src="' + url + '" frameBorder="0" style="border:0;width:100%;height:99%;"></iframe>'
				});
    		}
		});  
	})

	function login() {
		var data = $("#index_form").serialize();
		$.ajax({
			type: "post",
			url: "${pageContext.request.contextPath}/userController/login.do",
			data: data,
			dataType: "json",
			success: function(result) {
				if (result.success) {
					$("#dd").dialog("close");
					$.messager.show({
						title:'提示',
						msg: result.msg,
						timeout:3000,
						showType:'slide'
					});
				} else {
					$.messager.show({
						title:'提示',
						msg: result.msg,
						timeout:3000,
						showType:'slide'
					});
				}
			},
			error: function() {
				alert("系统错误，请联系管理员！");
			}
		}) 
	}
	//创建一个tab页面，或者选中tabs页
	function addTab(opts){
		var t = $('#index_tabs');
		if(t.tabs('exists',opts.title)){
			t.tabs('select',opts.title);
		}else{
			t.tabs('add', opts);
		}
	}
</script>
</head>
<body>  
<div id="cc" class="easyui-layout" data-options="fit:true" >   
    <div data-options="region:'north',split:true" style="height:100px;"></div>   
    <div data-options="region:'south',split:true" style="height:30px;">
    	<div style="text-align: center; background:#eee;">RDIFramework.net(.net快速信息化开发系统框架)</div>
    </div>     
    <div data-options="region:'west',title:'导航菜单',iconCls:'icon-save',split:true" style="width:200px;">
    	<jsp:include page="/layout/west.jsp"></jsp:include>
    </div>   
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
    	<div id="index_tabs" class="easyui-tabs" data-options="fit: true" style="width:500px;height:250px;">  
    		 <div title="欢迎使用" style="padding:5px;">   
		        <img title="金科教育宣传册" src="${pageContext.request.contextPath }/images/jk.png" width="1140" height="440">
		    </div>   
    	</div>
    </div>
</div>

<div id="dd" class="easyui-dialog" title="系统登录" style="width:210px;height:140px; display: none;"   
        data-options="iconCls:'icon-lock-login', modal:true, closable:false, buttons:'#bb'">   
    <div id="p" class="easyui-panel" data-options="fit:true" style="padding: 3px; ">  
    	<form id="index_form">
    		<table>
    			<tr>
    				<td>
    					<input class="easyui-textbox" name="name" data-options="iconCls:'icon-man'" style="width: 183px;"> 
    				</td>
    			</tr>
    			<tr>
    				<td>
    					<input class="easyui-textbox" name="pwd" data-options="iconCls:'icon-lock'" style="width: 183px;"> 
    				</td>
    			</tr>
    		</table>
    	</form>
	</div>   
</div>  
<div id="bb">
	<a href="#" class="easyui-linkbutton">注册</a>
	<a href="javascript:login()" class="easyui-linkbutton" >登录</a>
</div>
</body> 
</html>