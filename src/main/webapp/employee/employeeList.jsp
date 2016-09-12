<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理列表展示</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$('#sex').combobox({    
		    url:'combobox_data.json',    
		    valueField:'id',    
		    textField:'text',
		    mode: 'remote'
		});  
		$('#orgName').combotree({    
			url:'${pageContext.request.contextPath}/menuController/initTree.do',
		    loadFilter: function(data){    
		        if (data.success){    
		            return data.object;    
		        } else {    
		            return data.msg;    
		        }    
		    },    
		    required: true   
		}); 
		$('#employeeAdd_dialog').dialog({    
			buttons:[{
				text:'保存',
				handler:function(){
					var data = $("#employeeList_form").serialize(); 
					$.ajax({
						type: "post",
						url: "${pageContext.request.contextPath}/userController/addUser.do",
						data: data,
						success: function() {
							
						}
					})
				}
			},{
				text:'关闭',
				handler:function(){
					
				}
			}]
		}).dialog("close"); 
		$('#dg').datagrid({    
			title: '员工（职员）列表',
			url:'${pageContext.request.contextPath}/userController/userList.do', 
			rownumbers: true,
			toolbar: "#toolbar",
			fit: true,
			striped: true,
			pagination: true,
			fitColumns: true,
		    columns:[[    
				{field:'ids',checkbox: true,title:'序号',width:100,align:'center'},
		        {field:'id',title:'编号',width:380,align:'center'},    
		        {field:'name',title:'姓名',width:100,align:'center'},    
		        {field:'pwd',title:'密码',width:380,align:'center'},
		        {field:'modifydatetime',title:'修改时间',width:180,align:'center'},
		        {field:'createdatetime',title:'创建时间',width:180,align:'center'},
		    ]]
		});  
	})
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			uploadJson : "${pageContext.request.contextPath}/jslib/kindeditor-4.1.10/jsp/upload_json.jsp",
			fileManagerJson : "${pageContext.request.contextPath}/jslib/kindeditor-4.1.10/jsp/file_manager_json.jsp",
			allowFileManager : true,
			afterBlur: function () { this.sync(); }//同步KindEditor的值到textarea文本框。
		});
	});
	function addEmployee() {
		$('#employeeAdd_dialog').dialog("open");
	}
	
</script>
</head>
<body>
<div id="employeeList_layout" class="easyui-layout" data-options="fit: true" >   
    <div data-options="region:'west',title:'组织机构',split:true, iconCls: 'icon-sitemap-color'" style="width:200px;"></div>   
    <div data-options="region:'center',title:'员工管理', iconCls: 'icon-group'">
    	<table id="dg" border="0"></table>
    	<div id="toolbar">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="newUser()">刷新</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addEmployee()">添加</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">导入</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">导出</a>
	    </div>
    </div>   
</div> 
<div id="employeeAdd_dialog" class="easyui-dialog" title="新增员工（职员）" style="width:960px;height:400px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true">   
   <div id="tt" class="easyui-tabs" data-options="fit: true" >   
	    <div title="基本信息" style="padding:3px;">   
	       <div class="easyui-panel"  data-options="fit:true">  
	           <form id="employeeList_form" method="post">   
				  <table>
				  	<tr>
				  		<td><label>员工姓名：</label></td>
				  		<td><input class="easyui-validatebox" type="text" name="employeeName" style="width: 183px;" data-options="required:true,validType:'minLength[5]',missingMessage:'员工姓名为必输项'" />   </td>
				  		<td><label>员工编号：</label>   </td>
				  		<td><input class="easyui-validatebox" type="text" name="employeeNo" style="width: 183px;" data-options="required:true" />   </td>
				  	</tr>
				  	<tr>
				  		<td><label>性别：</label></td>
				  		<td><input id="sex" type="text" name="sex" style="width: 183px;" data-options="required:true"/>   </td>
				  		<td><label>组织机构：</label>   </td>
				  		<td><input id="orgName" type="text" name="orgName" style="width: 183px;" data-options="" />   </td>
				  	</tr>
				  	<tr>
				  		<td><label>出生日期：</label></td>
				  		<td><input id="birthday" type="text" name="birthday" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 183px;" readonly="readonly"/>   </td>
				  		<td><label>年龄：</label>   </td>
				  		<td><input class="easyui-validatebox" type="text" name="age" style="width: 183px;" data-options="required:true" maxlength=""/>   </td>
				  	</tr>
				  	<tr>
				  		<td><label>出生日期：</label></td>
				  		<td colspan="3">
				  			<textarea name="content" style="width: 200px; height: 100px;visibility:hidden;"></textarea>
				  		</td>
				  	</tr>
				  </table>  
				</form> 
		   </div> 
	    </div>   
	    <div title="工作相关" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">   
	        tab2    
	    </div>   
	    <div title="家庭相关" data-options="closable:true" style="padding:20px;display:none;">   
	        tab3    
	    </div>   
	</div>  
</div> 
</body>
</html>