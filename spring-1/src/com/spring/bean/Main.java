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
		//利用类型返回IOC容器的bean,但要求IOC容器中只能有一个该类型的bean
//		HelloWorld helloWorld=ctx.getBean(HelloWorld.class);
		System.out.println(helloWorld);
//		helloWorld.hello();
		
		Car car=(Car) ctx.getBean("car");
		System.out.println(car);
		car=(Car) ctx.getBean("car2");
		System.out.println(car);
		
		Person person=(Person) ctx.getBean("person");
		System.out.println(person);
	}
}
