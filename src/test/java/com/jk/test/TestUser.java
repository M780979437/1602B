package com.jk.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.jk.model.User;
import com.jk.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class TestUser {

	@Autowired
	private IUserService userService;
	
	/**
	 * <pre>insertUser(添加用户)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月3日 下午2:12:23    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月3日 下午2:12:23    
	 * 修改备注： </pre>
	 */
	@Test
	public void insertUser() {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setName("admin");
		user.setPwd("admin");
		user.setCreatedatetime(new Date());
		user.setModifydatetime(new Date());
		try {
			userService.insertUser(user);
			System.out.println("添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>deleteUser(删除用户信息)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月3日 下午2:27:52    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月3日 下午2:27:52    
	 * 修改备注： </pre>
	 */
	@Test
	public void deleteUser() {
		User user = new User();
		user.setId("697ab715-c4a5-45cd-a22a-378a12a3f25a");
		try {
			userService.deleteUser(user);
			System.out.println("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>updateUser(修改用户信息)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月3日 下午2:41:06    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月3日 下午2:41:06    
	 * 修改备注： </pre>
	 */
	@Test
	public void updateUser() {
		User user = new User();
		user.setId("feef4721-23c0-4a11-8907-8658cd5c4491");
		user.setPwd("123456");
		user.setModifydatetime(new Date());
		try {
			userService.updateUser(user);
			System.out.println("修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>userList(用户列表查询)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月3日 下午2:41:32    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月3日 下午2:41:32    
	 * 修改备注： </pre>
	 */
	@Test
	public void userList() {
		User user = new User();
		try {
			List<User> userList = userService.userList(user);
			System.out.println(JSON.toJSONStringWithDateFormat(userList, "yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>userPaginationList(用户列表，分页展示)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月3日 下午4:28:06    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月3日 下午4:28:06    
	 * 修改备注： </pre>
	 */
//	@Test
//	public void userPaginationList() {
//		User user = new User();
//		user.setPage(3);
//		user.setRows(2);
//		try {
//			List<User> userPaginationList = userService.userPaginationList(user);
//			System.out.println(JSON.toJSONStringWithDateFormat(userPaginationList, "yyyy-MM-dd HH:mm:ss"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
