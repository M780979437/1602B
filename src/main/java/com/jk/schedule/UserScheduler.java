package com.jk.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jk.model.Menu;
import com.jk.service.IMenuService;

@Service("userScheduler")
public class UserScheduler {

	@Autowired
	private IMenuService menuService;
	
	//@Scheduled(cron="*/20 * * * * ?")
	public void showMenu() {
		System.out.println("showMenu定时任务启动。。。");
		String id = null;
		try {
			List<Menu> initTree = menuService.initTree(id);
			System.out.println(JSON.toJSONStringWithDateFormat(initTree, "yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("showMenu定时任务结束。。。");
	}
}
