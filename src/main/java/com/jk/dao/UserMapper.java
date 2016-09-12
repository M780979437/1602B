package com.jk.dao;

import java.util.List;
import java.util.Map;

import com.jk.model.User;

public interface UserMapper {
   /**
    * <pre>insert(添加用户)   
    * 创建人：杨志超 yangzhichao150@126.com    
    * 创建时间：2016年8月3日 下午2:07:59    
    * 修改人：杨志超 yangzhichao150@126.com     
    * 修改时间：2016年8月3日 下午2:07:59    
    * 修改备注： 
    * @param user
    * @throws Exception</pre>
    */
   public void insert(User user) throws Exception;
   
   /**
    * <pre>deleteUser(删除用户信息)   
    * 创建人：杨志超 yangzhichao150@126.com    
    * 创建时间：2016年8月3日 下午2:13:28    
    * 修改人：杨志超 yangzhichao150@126.com     
    * 修改时间：2016年8月3日 下午2:13:28    
    * 修改备注： 
    * @param user
    * @throws Exception</pre>
    */
   public void deleteUser(User user) throws Exception;
   
   /**
    * <pre>updateUser(修改用户信息)   
    * 创建人：杨志超 yangzhichao150@126.com    
    * 创建时间：2016年8月3日 下午2:20:33    
    * 修改人：杨志超 yangzhichao150@126.com     
    * 修改时间：2016年8月3日 下午2:20:33    
    * 修改备注： 
    * @param user
    * @throws Exception</pre>
    */
   public void updateUser(User user) throws Exception;
   
   /**
    * <pre>userList(这里用一句话描述这个方法的作用)   
    * 创建人：杨志超 yangzhichao150@126.com    
    * 创建时间：2016年8月3日 下午2:33:13    
    * 修改人：杨志超 yangzhichao150@126.com     
    * 修改时间：2016年8月3日 下午2:33:13    
    * 修改备注： 
    * @param user
    * @return
    * @throws Exception</pre>
    */
   public List<User> userList(User user) throws Exception;
   
   /**
    * <pre>userPaginationList(用户列表分页查询)   
    * 创建人：杨志超 yangzhichao150@126.com    
    * 创建时间：2016年8月3日 下午4:15:17    
    * 修改人：杨志超 yangzhichao150@126.com     
    * 修改时间：2016年8月3日 下午4:15:17    
    * 修改备注： 
    * @param user
    * @return
    * @throws Exception</pre>
    */
   public List<User> userPaginationList(User user) throws Exception;
   
   /**
    * <pre>login(用户登录)   
    * 创建人：杨志超 yangzhichao150@126.com    
    * 创建时间：2016年8月6日 下午4:07:40    
    * 修改人：杨志超 yangzhichao150@126.com     
    * 修改时间：2016年8月6日 下午4:07:40    
    * 修改备注： 
    * @param user
    * @return
    * @throws Exception</pre>
    */
   public User login(User user) throws Exception;
   
   
}