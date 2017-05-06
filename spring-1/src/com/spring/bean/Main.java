package com.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/*HelloWorld helloWorld=new HelloWorld();
		helloWorld.setName("cheney");*/
		/*
		 * 1.创建Spring的IOC容器对象
		 * 2.从IOC容器中获取bean实例
		 * 3.调用hello方法
		 * */
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld=(HelloWorld) ctx.getBean("helloWorld");
		helloWorld.hello();
	}
}
