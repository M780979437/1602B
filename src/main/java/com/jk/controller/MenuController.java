package com.jk.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jk.model.Json;
import com.jk.model.Menu;
import com.jk.service.IMenuService;

@Controller
@RequestMapping("/menuController")
public class MenuController extends BaseController {

	//日志打印
	private static Logger logger = Logger.getLogger(MenuController.class);
	
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping("/initTree")
	public void initTree(String id, HttpServletResponse response) {
		logger.info("初始化加载树形结构方法开始。。。。");
		Json j = new Json();
		try {
			List<Menu> initTree = menuService.initTree(id);
			j.setSuccess(true);
			j.setObject(initTree);
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("初始化加载树异常！");
			e.printStackTrace();
		}
		super.writeJson(j, response);
	}
}
