package com.jk.dao;

import java.util.List;

import com.jk.model.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    /**
     * <pre>getMenuById(查询根节点信息)   
     * 创建人：杨志超 yangzhichao150@126.com    
     * 创建时间：2016年8月8日 上午11:11:45    
     * 修改人：杨志超 yangzhichao150@126.com     
     * 修改时间：2016年8月8日 上午11:11:45    
     * 修改备注： 
     * @param id
     * @return
     * @throws Exception</pre>
     */
    public List<Menu> getMenuById(String id) throws Exception;
    
    /**
     * <pre>getMenus(查询节点信息)   
     * 创建人：杨志超 yangzhichao150@126.com    
     * 创建时间：2016年8月8日 上午11:15:58    
     * 修改人：杨志超 yangzhichao150@126.com     
     * 修改时间：2016年8月8日 上午11:15:58    
     * 修改备注： 
     * @param id
     * @return
     * @throws Exception</pre>
     */
    public List<Menu> getMenus(String id) throws Exception;
}