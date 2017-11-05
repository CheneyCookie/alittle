package com.briup.pattern.behavior.Strategy;

//实现类
public class Plus extends AbstractCalculator implements ICalculator {  
    public int calculate(String exp) {  
        int arrayInt[] = split(exp,"[+]");  
        return arrayInt[0]+arrayInt[1];  
    }  
} 
