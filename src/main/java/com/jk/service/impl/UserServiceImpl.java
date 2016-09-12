package com.jk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.UserMapper;
import com.jk.model.User;
import com.jk.service.IUserService;
import com.jk.util.CacheManager;
@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void insertUser(User user) throws Exception {
		userMapper.insert(user);
	}

	@Override
	public void deleteUser(User user) throws Exception {
		userMapper.deleteUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userMapper.updateUser(user);
	}

	@Override
	public List<User> userList(User user) throws Exception {
		Object obj = CacheManager.getInstance().getObj("datagrid1");
		 if (null == obj) {
			List<User> userList = userMapper.userList(user);
            obj = userList;
            CacheManager.getInstance().putObj("datagrid", obj);
            CacheManager.getInstance().putObj("datagrid1", obj);
            CacheManager.getInstance().putObj("datagrid2", obj);
         }
		
		return (List<User>) obj;
	}

	@Override
	public List<User> userPaginationList(User user) throws Exception {
		List<User> userPaginationList = userMapper.userPaginationList(user);
		return userPaginationList;
	}

	@Override
	public User login(User user) throws Exception {
		User user1 = userMapper.login(user);
		return user1;
	}

}
