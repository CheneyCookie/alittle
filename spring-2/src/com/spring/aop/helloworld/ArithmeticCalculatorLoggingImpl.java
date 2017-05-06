package com.spring.aop.helloworld;

public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator{

	@Override
	public int add(int i, int j) {
		System.out.println("The method add begin with["+i+","+j+"]");
		int result=i+j;
		System.out.println("The method add ends with "+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("The method sub begin with["+i+","+j+"]");
		int result=i-j;
		System.out.println("The method sub ends with "+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("The method mul begin with["+i+","+j+"]");
		int result=i*j;
		System.out.println("The method mul ends with "+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("The method div begin with["+i+","+j+"]");
		int result=i/j;
		System.out.println("The method div ends with "+result);
		return result;
	}

}
