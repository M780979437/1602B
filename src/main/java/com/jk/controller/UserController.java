package com.jk.controller;

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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jk.model.Json;
import com.jk.model.User;
import com.jk.service.IUserService;
import com.jk.util.UploadFile;

@Controller
@RequestMapping("/userController")
public class UserController extends BaseController implements ServletContextAware{

	//日志记录
	private static Logger logger = Logger.getLogger(UserController.class);
	
	private ServletContext servletContext;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/login_file")
	public String login_file(String name, String pwd, @RequestParam("file") CommonsMultipartFile file) {
		
		if(!file.isEmpty()) {
            //获取本地存储路径
            String path = this.servletContext.getRealPath("/upload/");
            logger.info(path);
            String fileName = file.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            logger.info(fileType);
            File file2 = new File(path, new Date().getTime() + fileType);
            try {
                //将上传的文件写入到新建的文件中
                file.getFileItem().write(file2);
            } catch (Exception e) {
                return "upload_error";
            }
            return "upload_ok";
        } else {
            return "upload_error";
        }
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
//	@RequestMapping("/login")
//	public modelAndView login(User user) {
//		ModelAndView modelAndView = new ModelAndView();
//		user.setName("admin");
//		modelAndView.setViewName("main");
//		modelAndView.addObject("user", user);
//		return modelAndView;
//	}
	
	@RequestMapping("/login")
	public void login(User user, HttpServletRequest request, HttpServletResponse response) {
		Json j = new Json();
		try {
			User user1 = userService.login(user);
			request.getSession().setAttribute("sessionInfo", user1);
			if (user1 == null) {
				j.setSuccess(false);
				j.setMsg("用户名不存在！");
			} else {
				j.setSuccess(true);
				j.setMsg("登录成功！");
			}
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("登录失败！");
			e.printStackTrace();
		}
		super.writeJson(j, response);
	}

	@RequestMapping("/userList")
	public void userList(User user, HttpServletResponse response) {
		logger.info("用户信息查询");
		Json j = new Json();
		List<User> userList = null;
		try {
			userList = userService.userList(user);
			j.setSuccess(true);
			j.setObject(userList);
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("列表查询异常！");
			e.printStackTrace();
		}
		super.writeJson(userList, response);
	}
	
	@RequestMapping("/insertUser")
	public void insertUser(User user, String createDate, HttpServletResponse response) {
		Json j = new Json();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (null != createDate && !"".equals(createDate)) {
				user.setCreatedatetime(sdf.parse(createDate));
				user.setModifydatetime(sdf.parse(createDate));
			}
			userService.insertUser(user);
			j.setSuccess(true);
			j.setMsg("插入成功！");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("插入失败！");
			e.printStackTrace();
		}
//		super.writeJson(j, response);
	}
	
	@RequestMapping("/uploadFile")
	public void saveUpload(@RequestParam("file1") CommonsMultipartFile file1, HttpServletResponse response){
		Json j = new Json();
		if(!file1.isEmpty()) {
            //获取本地存储路径
            String path = this.servletContext.getRealPath("/upload/");
            logger.info(path);
            String fileName = file1.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            logger.info(fileType);
            File file3 = new File(path, new Date().getTime() + fileType);
            try {
                //将上传的文件写入到新建的文件中
                file1.getFileItem().write(file3);
                j.setSuccess(true);
                j.setMsg("上传成功！");
            } catch (Exception e) {
                e.printStackTrace();
                j.setSuccess(false);
                j.setMsg("上传失败！");
            }
        } 
		super.writeJson(j, response);
	} 
	
	/**
	 * <pre>userJsonPList(jsonp的ajax的跨域请求)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月26日 下午8:13:26    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月26日 下午8:13:26    
	 * 修改备注： </pre>
	 */
	@RequestMapping("/userJsonPList")
	public void userJsonPList(HttpServletRequest request, String callback, HttpServletResponse response) {
		String result =  "{\"ret\":true}";
        //加上返回参数
        result=callback+"("+result+")";
        super.outString(result, response);
	}
	
}
