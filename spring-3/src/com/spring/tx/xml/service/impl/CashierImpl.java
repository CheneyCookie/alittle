package com.spring.tx.xml.service.impl;

import java.util.List;

import com.spring.tx.xml.service.BookShopService;
import com.spring.tx.xml.service.Cashier;

public class CashierImpl implements Cashier{

	private BookShopService bookShopService; 
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	/*
	 * 添加事务注解
	 * 1.使用propagation指定事务的传播行为，即当前事务方法被另一个事务方法调用时
	 * 如何使用事务，默认取值为REQUIRED,即调用方法的事务
	 * REQUIRED_NEW:使用自己的事务，调用的事务方法的事务被挂起。
	 * 2.使用isolation指定事务的隔离级别，最常用的取值为READ_COMMITTED
	 * 3.默认情况下Spring的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置。 
	 * 4.使用readOnly指定事务是否为只读,表示这个事物只读取数据但不更新数据
	 * 这样可以帮助数据库引擎优化事务，若真的是一个只读取数据库值的方法，应设置readOnly=true
	 * 5.使用timeOut指定强制回滚之前事务可以占用的时间
	 * */
	@Override
	public void checkout(String username, List<String> isbns) {
		for(String isbn:isbns){
			bookShopService.purchase(username, isbn);
		}
	}

}
