package org.apache.jsp.employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>员工管理列表展示</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../inc.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$('#sex').combobox({    \r\n");
      out.write("\t\t    url:'combobox_data.json',    \r\n");
      out.write("\t\t    valueField:'id',    \r\n");
      out.write("\t\t    textField:'text',\r\n");
      out.write("\t\t    mode: 'remote'\r\n");
      out.write("\t\t});  \r\n");
      out.write("\t\t$('#orgName').combotree({    \r\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/menuController/initTree.do',\r\n");
      out.write("\t\t    loadFilter: function(data){    \r\n");
      out.write("\t\t        if (data.success){    \r\n");
      out.write("\t\t            return data.object;    \r\n");
      out.write("\t\t        } else {    \r\n");
      out.write("\t\t            return data.msg;    \r\n");
      out.write("\t\t        }    \r\n");
      out.write("\t\t    },    \r\n");
      out.write("\t\t    required: true   \r\n");
      out.write("\t\t}); \r\n");
      out.write("\t\t$('#employeeAdd_dialog').dialog({    \r\n");
      out.write("\t\t\tbuttons:[{\r\n");
      out.write("\t\t\t\ttext:'保存',\r\n");
      out.write("\t\t\t\thandler:function(){\r\n");
      out.write("\t\t\t\t\tvar data = $(\"#employeeList_form\").serialize(); \r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\t\t\t\turl: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/userController/addUser.do\",\r\n");
      out.write("\t\t\t\t\t\tdata: data,\r\n");
      out.write("\t\t\t\t\t\tsuccess: function() {\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\ttext:'关闭',\r\n");
      out.write("\t\t\t\thandler:function(){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}]\r\n");
      out.write("\t\t}).dialog(\"close\"); \r\n");
      out.write("\t\t$('#dg').datagrid({    \r\n");
      out.write("\t\t\ttitle: '员工（职员）列表',\r\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/userController/userList.do', \r\n");
      out.write("\t\t\trownumbers: true,\r\n");
      out.write("\t\t\ttoolbar: \"#toolbar\",\r\n");
      out.write("\t\t\tfit: true,\r\n");
      out.write("\t\t\tstriped: true,\r\n");
      out.write("\t\t\tpagination: true,\r\n");
      out.write("\t\t\tfitColumns: true,\r\n");
      out.write("\t\t    columns:[[    \r\n");
      out.write("\t\t\t\t{field:'ids',checkbox: true,title:'序号',width:100,align:'center'},\r\n");
      out.write("\t\t        {field:'id',title:'编号',width:380,align:'center'},    \r\n");
      out.write("\t\t        {field:'name',title:'姓名',width:100,align:'center'},    \r\n");
      out.write("\t\t        {field:'pwd',title:'密码',width:380,align:'center'},\r\n");
      out.write("\t\t        {field:'modifydatetime',title:'修改时间',width:180,align:'center'},\r\n");
      out.write("\t\t        {field:'createdatetime',title:'创建时间',width:180,align:'center'},\r\n");
      out.write("\t\t    ]]\r\n");
      out.write("\t\t});  \r\n");
      out.write("\t})\r\n");
      out.write("\tvar editor;\r\n");
      out.write("\tKindEditor.ready(function(K) {\r\n");
      out.write("\t\teditor = K.create('textarea[name=\"content\"]', {\r\n");
      out.write("\t\t\tuploadJson : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jslib/kindeditor-4.1.10/jsp/upload_json.jsp\",\r\n");
      out.write("\t\t\tfileManagerJson : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jslib/kindeditor-4.1.10/jsp/file_manager_json.jsp\",\r\n");
      out.write("\t\t\tallowFileManager : true,\r\n");
      out.write("\t\t\tafterBlur: function () { this.sync(); }//同步KindEditor的值到textarea文本框。\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction addEmployee() {\r\n");
      out.write("\t\t$('#employeeAdd_dialog').dialog(\"open\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"employeeList_layout\" class=\"easyui-layout\" data-options=\"fit: true\" >   \r\n");
      out.write("    <div data-options=\"region:'west',title:'组织机构',split:true, iconCls: 'icon-sitemap-color'\" style=\"width:200px;\"></div>   \r\n");
      out.write("    <div data-options=\"region:'center',title:'员工管理', iconCls: 'icon-group'\">\r\n");
      out.write("    \t<table id=\"dg\" border=\"0\"></table>\r\n");
      out.write("    \t<div id=\"toolbar\">\r\n");
      out.write("\t        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\" onclick=\"newUser()\">刷新</a>\r\n");
      out.write("\t        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" onclick=\"addEmployee()\">添加</a>\r\n");
      out.write("\t        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onclick=\"editUser()\">修改</a>\r\n");
      out.write("\t        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onclick=\"destroyUser()\">删除</a>\r\n");
      out.write("\t        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" onclick=\"newUser()\">导入</a>\r\n");
      out.write("\t        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" onclick=\"newUser()\">导出</a>\r\n");
      out.write("\t    </div>\r\n");
      out.write("    </div>   \r\n");
      out.write("</div> \r\n");
      out.write("<div id=\"employeeAdd_dialog\" class=\"easyui-dialog\" title=\"新增员工（职员）\" style=\"width:960px;height:400px;\"   \r\n");
      out.write("        data-options=\"iconCls:'icon-save',resizable:true,modal:true\">   \r\n");
      out.write("   <div id=\"tt\" class=\"easyui-tabs\" data-options=\"fit: true\" >   \r\n");
      out.write("\t    <div title=\"基本信息\" style=\"padding:3px;\">   \r\n");
      out.write("\t       <div class=\"easyui-panel\"  data-options=\"fit:true\">  \r\n");
      out.write("\t           <form id=\"employeeList_form\" method=\"post\">   \r\n");
      out.write("\t\t\t\t  <table>\r\n");
      out.write("\t\t\t\t  \t<tr>\r\n");
      out.write("\t\t\t\t  \t\t<td><label>员工姓名：</label></td>\r\n");
      out.write("\t\t\t\t  \t\t<td><input class=\"easyui-validatebox\" type=\"text\" name=\"employeeName\" style=\"width: 183px;\" data-options=\"required:true,validType:'minLength[5]',missingMessage:'员工姓名为必输项'\" />   </td>\r\n");
      out.write("\t\t\t\t  \t\t<td><label>员工编号：</label>   </td>\r\n");
      out.write("\t\t\t\t  \t\t<td><input class=\"easyui-validatebox\" type=\"text\" name=\"employeeNo\" style=\"width: 183px;\" data-options=\"required:true\" />   </td>\r\n");
      out.write("\t\t\t\t  \t</tr>\r\n");
      out.write("\t\t\t\t  \t<tr>\r\n");
      out.write("\t\t\t\t  \t\t<td><label>性别：</label></td>\r\n");
      out.write("\t\t\t\t  \t\t<td><input id=\"sex\" type=\"text\" name=\"sex\" style=\"width: 183px;\" data-options=\"required:true\"/>   </td>\r\n");
      out.write("\t\t\t\t  \t\t<td><label>组织机构：</label>   </td>\r\n");
      out.write("\t\t\t\t  \t\t<td><input id=\"orgName\" type=\"text\" name=\"orgName\" style=\"width: 183px;\" data-options=\"\" />   </td>\r\n");
      out.write("\t\t\t\t  \t</tr>\r\n");
      out.write("\t\t\t\t  \t<tr>\r\n");
      out.write("\t\t\t\t  \t\t<td><label>出生日期：</label></td>\r\n");
      out.write("\t\t\t\t  \t\t<td><input id=\"birthday\" type=\"text\" name=\"birthday\" onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})\" style=\"width: 183px;\" readonly=\"readonly\"/>   </td>\r\n");
      out.write("\t\t\t\t  \t\t<td><label>年龄：</label>   </td>\r\n");
      out.write("\t\t\t\t  \t\t<td><input class=\"easyui-validatebox\" type=\"text\" name=\"age\" style=\"width: 183px;\" data-options=\"required:true\" maxlength=\"\"/>   </td>\r\n");
      out.write("\t\t\t\t  \t</tr>\r\n");
      out.write("\t\t\t\t  \t<tr>\r\n");
      out.write("\t\t\t\t  \t\t<td><label>出生日期：</label></td>\r\n");
      out.write("\t\t\t\t  \t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t  \t\t\t<textarea name=\"content\" style=\"width: 200px; height: 100px;visibility:hidden;\"></textarea>\r\n");
      out.write("\t\t\t\t  \t\t</td>\r\n");
      out.write("\t\t\t\t  \t</tr>\r\n");
      out.write("\t\t\t\t  </table>  \r\n");
      out.write("\t\t\t\t</form> \r\n");
      out.write("\t\t   </div> \r\n");
      out.write("\t    </div>   \r\n");
      out.write("\t    <div title=\"工作相关\" data-options=\"closable:true\" style=\"overflow:auto;padding:20px;display:none;\">   \r\n");
      out.write("\t        tab2    \r\n");
      out.write("\t    </div>   \r\n");
      out.write("\t    <div title=\"家庭相关\" data-options=\"closable:true\" style=\"padding:20px;display:none;\">   \r\n");
      out.write("\t        tab3    \r\n");
      out.write("\t    </div>   \r\n");
      out.write("\t</div>  \r\n");
      out.write("</div> \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
