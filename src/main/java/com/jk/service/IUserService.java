package com.jk.service;

import java.util.List;
import java.util.Map;

import com.jk.model.User;

public interface IUserService {

	/**
	 * <pre>insertUser(添加用户信息)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月3日 上午10:36:17    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月3日 上午10:36:17    
	 * 修改备注： 
	 * @param user
	 * @throws Exception</pre>
	 */
	public void insertUser(User user) throws Exception;
	
	/**
	 * <pre>deleteUser(删除用户信息)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月3日 下午2:15:53    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月3日 下午2:15:53    
	 * 修改备注： 
	 * @param user
	 * @throws Exception</pre>
	 */
	public void deleteUser(User user) throws Exception;
	
	/**
	 * <pre>updateUser(修改用户信息)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月3日 下午2:27:18    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月3日 下午2:27:18    
	 * 修改备注： 
	 * @param user
	 * @throws Exception</pre>
	 */
	public void updateUser(User user) throws Exception;
	
	/**
	 * <pre>userList(查询用户列表信息)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月3日 下午2:39:45    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月3日 下午2:39:45    
	 * 修改备注： 
	 * @param user
	 * @throws Exception</pre>
	 */
	public List<User> userList(User user) throws Exception;
	
	/**
	 * <pre>userPaginationList(用户列表，分页展示)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月3日 下午4:26:56    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月3日 下午4:26:56    
	 * 修改备注： 
	 * @param user
	 * @return
	 * @throws Exception</pre>
	 */
	public List<User> userPaginationList(User user) throws Exception;
	
	/**
	 * <pre>login(用户登录)   
	 * 创建人：杨志超 yangzhichao150@126.com    
	 * 创建时间：2016年8月6日 下午4:09:57    
	 * 修改人：杨志超 yangzhichao150@126.com     
	 * 修改时间：2016年8月6日 下午4:09:57    
	 * 修改备注： 
	 * @param user
	 * @return
	 * @throws Exception</pre>
	 */
	public User login(User user) throws Exception;
}
