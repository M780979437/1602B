package com.jk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.MenuMapper;
import com.jk.model.Menu;
import com.jk.service.IMenuService;
@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> initTree(String id) throws Exception{
		List<Menu> menus = new ArrayList<Menu>();
		if (id == null) {
			menus = menuMapper.getMenuById(id);
		} else {
			menus = menuMapper.getMenus(id);
		}
		
		for (int i = 0; i < menus.size(); i++) {
			if (getChildrenTreeNode(menus.get(i))) {
				menus.get(i).setState("closed");
			}
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("url", menus.get(i).getUrl());
			menus.get(i).setAttributes(attributes);
		}
		return menus;
	}
	
	public boolean getChildrenTreeNode(Menu menu) throws Exception {
		boolean flag = false;
		List<Menu> menus = menuMapper.getMenus(menu.getId());
		if (menus.size() > 0) {
			flag = true;
		}
		return flag;
	}
}
