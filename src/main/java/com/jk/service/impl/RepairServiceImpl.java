package com.jk.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.model.User;
import com.jk.service.IRepairService;
import com.jk.service.IUserService;
import com.jk.util.SHA1;
@Service("repairService")
public class RepairServiceImpl implements IRepairService {

	@Autowired
	private IUserService userService;
	
	@Override
	public void repair() {
		System.out.println("修复开始操作。。。");
		User u = new User();
		u.setName("admin");
		User u1 = null;
		try {
			u1 = userService.login(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setName("admin");
		user.setPwd(SHA1.getDigestOfString("admin".getBytes()));
		user.setCreatedatetime(new Date());
		user.setModifydatetime(new Date());
		if (u1 == null) {
			try {
//				userService.insertUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
