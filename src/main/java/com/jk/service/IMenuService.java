package com.jk.service;

import java.util.List;

import com.jk.model.Menu;

public interface IMenuService {

	/**
	 * <pre>initTree(初始化加载树形结构信息)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月8日 上午11:08:09    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月8日 上午11:08:09    
	 * 修改备注： 
	 * @param id
	 * @return
	 * @throws Exception</pre>
	 */
	public List<Menu> initTree(String id) throws Exception;
}
