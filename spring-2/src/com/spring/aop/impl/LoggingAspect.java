package com.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Order(1)可以指定切面的优先级，值越小优先级越高
//把这个类声明为一个切面：把该类放到一个IOC容器中、再声明为一个切面
@Aspect
@Component
public class LoggingAspect {
	
	//定义一个方法，用于声明切入点表达式，一般地，该方法中再不需添入其他代码
	@Pointcut("execution(public int com.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void declareJointPointExpression(){
		
	}
	
	//声明该方法时是一个前置通知：在目标方法开始之前执行
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins with "+args);
	}
	
	//后置通知：在目标方法执行后（无论是否发生异常），执行的通知。
	@After("execution(public int com.spring.aop.impl.ArithmeticCalculator.*(int, int))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends");
	}
	
	//返回通知：在方法正常结束受执行的代码
	//返回通知是可以访问到方法的返回值的
	@AfterReturning(value="execution(public int com.spring.aop.impl.ArithmeticCalculator.*(int, int))",returning="result")
	public void afterReturnung(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+result);
	}
	
	
	//异常通知：在目标方法出现异常时会执行的代码
	//可以访问到异常对象；且可以指定在出现特定异常时再执行通知代码
	@AfterThrowing(value="execution(public int com.spring.aop.impl.ArithmeticCalculator.*(int, int))",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs with "+ex);
	}
	
	//环绕通知：需要携带PProceedingJoinPoint类型的参数
	//环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法
	//且环绕通知必须有返回值，返回值即为目标方法的返回值
	@Around("execution(public int com.spring.aop.impl.ArithmeticCalculator.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result=null;
		String methodName=pjd.getSignature().getName();
		//执行目标方法
		try {
			//前置通知
			System.out.println("The method "+methodName+" begins with "+Arrays.asList(pjd.getArgs()));
			result=pjd.proceed();
			//后置通知
			System.out.println("The method "+methodName+" ends with "+result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method "+methodName+" occurs exception:"+e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("The method "+methodName+" ends");
		return result;
	}
}
