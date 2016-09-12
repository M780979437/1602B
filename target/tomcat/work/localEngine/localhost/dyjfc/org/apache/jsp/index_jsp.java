package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>大眼睛房地产</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "inc.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"#dd\").show().dialog(\"open\");\r\n");
      out.write("\t\t$('#tt').tree({    \r\n");
      out.write("\t\t    url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/menuController/initTree.do',\r\n");
      out.write("\t\t    loadFilter: function(data){    \r\n");
      out.write("\t\t        if (data.success){    \r\n");
      out.write("\t\t            return data.object;    \r\n");
      out.write("\t\t        } else {    \r\n");
      out.write("\t\t            return data.msg;    \r\n");
      out.write("\t\t        }    \r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t    onLoadSuccess:function(node, data){\r\n");
      out.write("    \t\t\tvar t = $(this);\r\n");
      out.write("    \t\t\tif(data) {\r\n");
      out.write("    \t\t\t\t$(data).each(function(index, d){\r\n");
      out.write("    \t\t\t\t\tif(this.state == 'closed') {\r\n");
      out.write("    \t\t\t\t\t\tt.tree('expandAll');\r\n");
      out.write("    \t\t\t\t\t}\r\n");
      out.write("    \t\t\t\t});\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("\t\t\tonClick: function(node){\r\n");
      out.write("    \t\t\tconsole.info(node);\r\n");
      out.write("    \t\t\tvar url = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("' + node.attributes.url;\r\n");
      out.write("    \t\t\taddTab({\r\n");
      out.write("\t\t\t\t\ttitle:node.text,\r\n");
      out.write("\t\t\t\t\tclosable:true,\r\n");
      out.write("\t\t\t\t\tcontent:'<iframe src=\"' + url + '\" frameBorder=\"0\" style=\"border:0;width:100%;height:99%;\"></iframe>'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("    \t\t}\r\n");
      out.write("\t\t});  \r\n");
      out.write("\t})\r\n");
      out.write("\r\n");
      out.write("\tfunction login() {\r\n");
      out.write("\t\tvar data = $(\"#index_form\").serialize();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\turl: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/userController/login.do\",\r\n");
      out.write("\t\t\tdata: data,\r\n");
      out.write("\t\t\tdataType: \"json\",\r\n");
      out.write("\t\t\tsuccess: function(result) {\r\n");
      out.write("\t\t\t\tif (result.success) {\r\n");
      out.write("\t\t\t\t\t$(\"#dd\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\ttitle:'提示',\r\n");
      out.write("\t\t\t\t\t\tmsg: result.msg,\r\n");
      out.write("\t\t\t\t\t\ttimeout:3000,\r\n");
      out.write("\t\t\t\t\t\tshowType:'slide'\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\ttitle:'提示',\r\n");
      out.write("\t\t\t\t\t\tmsg: result.msg,\r\n");
      out.write("\t\t\t\t\t\ttimeout:3000,\r\n");
      out.write("\t\t\t\t\t\tshowType:'slide'\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function() {\r\n");
      out.write("\t\t\t\talert(\"系统错误，请联系管理员！\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}) \r\n");
      out.write("\t}\r\n");
      out.write("\t//创建一个tab页面，或者选中tabs页\r\n");
      out.write("\tfunction addTab(opts){\r\n");
      out.write("\t\tvar t = $('#index_tabs');\r\n");
      out.write("\t\tif(t.tabs('exists',opts.title)){\r\n");
      out.write("\t\t\tt.tabs('select',opts.title);\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tt.tabs('add', opts);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>  \r\n");
      out.write("<div id=\"cc\" class=\"easyui-layout\" data-options=\"fit:true\" >   \r\n");
      out.write("    <div data-options=\"region:'north',split:true\" style=\"height:100px;\"></div>   \r\n");
      out.write("    <div data-options=\"region:'south',split:true\" style=\"height:30px;\">\r\n");
      out.write("    \t<div style=\"text-align: center; background:#eee;\">RDIFramework.net(.net快速信息化开发系统框架)</div>\r\n");
      out.write("    </div>     \r\n");
      out.write("    <div data-options=\"region:'west',title:'导航菜单',iconCls:'icon-save',split:true\" style=\"width:200px;\">\r\n");
      out.write("    \t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/west.jsp", out, false);
      out.write("\r\n");
      out.write("    </div>   \r\n");
      out.write("    <div data-options=\"region:'center'\" style=\"padding:5px;background:#eee;\">\r\n");
      out.write("    \t<div id=\"index_tabs\" class=\"easyui-tabs\" data-options=\"fit: true\" style=\"width:500px;height:250px;\">  \r\n");
      out.write("    \t\t <div title=\"欢迎使用\" style=\"padding:5px;\">   \r\n");
      out.write("\t\t        <img title=\"金科教育宣传册\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/jk.png\" width=\"1140\" height=\"440\">\r\n");
      out.write("\t\t    </div>   \r\n");
      out.write("    \t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"dd\" class=\"easyui-dialog\" title=\"系统登录\" style=\"width:210px;height:140px; display: none;\"   \r\n");
      out.write("        data-options=\"iconCls:'icon-lock-login', modal:true, closable:false, buttons:'#bb'\">   \r\n");
      out.write("    <div id=\"p\" class=\"easyui-panel\" data-options=\"fit:true\" style=\"padding: 3px; \">  \r\n");
      out.write("    \t<form id=\"index_form\">\r\n");
      out.write("    \t\t<table>\r\n");
      out.write("    \t\t\t<tr>\r\n");
      out.write("    \t\t\t\t<td>\r\n");
      out.write("    \t\t\t\t\t<input class=\"easyui-textbox\" name=\"name\" data-options=\"iconCls:'icon-man'\" style=\"width: 183px;\"> \r\n");
      out.write("    \t\t\t\t</td>\r\n");
      out.write("    \t\t\t</tr>\r\n");
      out.write("    \t\t\t<tr>\r\n");
      out.write("    \t\t\t\t<td>\r\n");
      out.write("    \t\t\t\t\t<input class=\"easyui-textbox\" name=\"pwd\" data-options=\"iconCls:'icon-lock'\" style=\"width: 183px;\"> \r\n");
      out.write("    \t\t\t\t</td>\r\n");
      out.write("    \t\t\t</tr>\r\n");
      out.write("    \t\t</table>\r\n");
      out.write("    \t</form>\r\n");
      out.write("\t</div>   \r\n");
      out.write("</div>  \r\n");
      out.write("<div id=\"bb\">\r\n");
      out.write("\t<a href=\"#\" class=\"easyui-linkbutton\">注册</a>\r\n");
      out.write("\t<a href=\"javascript:login()\" class=\"easyui-linkbutton\" >登录</a>\r\n");
      out.write("</div>\r\n");
      out.write("</body> \r\n");
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
