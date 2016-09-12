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

public class RepairListener1 implements ServletContextListener, HttpSessionListener, ServletRequestListener{

	private static final Logger logger = Logger.getLogger(RepairListener.class);

	private static ApplicationContext ctx = null;
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		logger.info("修复数据库");
		ctx = WebApplicationContextUtils.getWebApplicationContext(evt.getServletContext());
		IRepairService repairService = (IRepairService) ctx.getBean("repairService");
//		repairService.repair();
	}

}
