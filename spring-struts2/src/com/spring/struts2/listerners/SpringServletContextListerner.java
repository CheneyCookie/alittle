package com.spring.struts2.listerners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebListener
public class SpringServletContextListerner implements ServletContextListener {

    public SpringServletContextListerner() {
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	//1.获取Spring配置文件的名称
    	ServletContext servletContext=arg0.getServletContext();
    	String config=servletContext.getInitParameter("configLocation");
    	
    	/*
    	 * 1.创建IOC容器
    	 * 2.把IOC容器放在ServletContext的一个属性中。
    	 * */
    	ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
    	servletContext.setAttribute("applicationContext", ctx);
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    }
	
}
