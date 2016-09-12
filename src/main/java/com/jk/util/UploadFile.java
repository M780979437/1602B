package com.jk.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;


public class UploadFile {

	private static Logger logger = Logger.getLogger(UploadFile.class);
	
	public static void receiveData(HttpServletRequest request, HttpServletResponse response) throws Exception{  
		  
        PrintWriter out = null;  
        response.setContentType("text/html;charset=UTF-8");  
          
        Map map = new HashMap();  
        FileItemFactory factory = new DiskFileItemFactory();  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        File directory = null;    
        List<FileItem> items = new ArrayList();  
        try {  
            items = upload.parseRequest(request);  
            // 得到所有的文件  
            Iterator<FileItem> it = items.iterator();  
            while (it.hasNext()) {  
                FileItem fItem = (FileItem) it.next();  
                String fName = "";  
                Object fValue = null;  
                if (fItem.isFormField()) { // 普通文本框的值  
                    fName = fItem.getFieldName();  
//                  fValue = fItem.getString();  
                    fValue = fItem.getString("UTF-8");  
                    map.put(fName, fValue);  
                } else { // 获取上传文件的值  
                    fName = fItem.getFieldName();  
                    fValue = fItem.getInputStream();  
                    map.put(fName, fValue);  
                    String name = fItem.getName();  
                    if(name != null && !("".equals(name))) {  
                        name = name.substring(name.lastIndexOf(File.separator) + 1);  
                          
//                      String stamp = StringUtils.getFormattedCurrDateNumberString(); 
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
                        String timestamp_Str = sdf.format(new Date()); 
                        directory = new File("d://test");    
                        directory.mkdirs();  
                          
                        String filePath = ("d://test")+ timestamp_Str+ File.separator + name;  
                        map.put(fName + "FilePath", filePath);  
                          
                        InputStream is = fItem.getInputStream();  
                        FileOutputStream fos = new FileOutputStream(filePath);  
                        byte[] buffer = new byte[1024];  
                        while (is.read(buffer) > 0) {  
                            fos.write(buffer, 0, buffer.length);  
                        }  
                        fos.flush();  
                        fos.close();  
						map.put(fName + "FileName", name);  
                    }  
                }  
            }  
        } catch (Exception e) {  
            System.out.println("读取http请求属性值出错!");  
//          e.printStackTrace();  
            logger.error("读取http请求属性值出错");  
        }  
          
        // 数据处理  
        try {  
            out = response.getWriter();  
            out.print("{success:true, msg:'接收成功'}");  
            out.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
  
    }  
}
