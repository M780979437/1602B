package com.jk.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jk.service.IRepairService;

/**
 * 在系统启动时，修复数据库
 * 
 * @author 杨志超
 * 
 */
public class RepairListener implements ServletContextListener, HttpSessionListener, ServletRequestListener {

	private static final Logger logger = Logger.getLogger(RepairListener.class);

	private static ApplicationContext ctx = null;
	
    public RepairListener() {
        
    }

    public void requestDestroyed(ServletRequestEvent arg0)  { 
         
    }

    public void contextInitialized(ServletContextEvent evt) {
		logger.info("修复数据库");
		ctx = WebApplicationContextUtils.getWebApplicationContext(evt.getServletContext());
		IRepairService repairService = (IRepairService) ctx.getBean("repairService");
//		repairService.repair();
	}

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 

    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 

    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 

    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 

    }
	
}
