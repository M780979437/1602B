package com.jk.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.jk.model.Menu;
import com.jk.service.IMenuService;

public class UserQueryLogin {

	@Autowired
	private IMenuService menuService;
	
	public void excute() {
		System.out.println("自动催办定时器运动启动。。。");
		String id = null;
		//TODO 去调用数据信息
		try {
			List<Menu> initTree = menuService.initTree(id);
			System.out.println(JSON.toJSONStringWithDateFormat(initTree, "yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("自动催办定时器运动结束。。。");
	}
}
