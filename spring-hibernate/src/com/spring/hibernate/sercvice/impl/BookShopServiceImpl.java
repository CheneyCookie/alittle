package com.spring.hibernate.sercvice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.dao.BookShopDao;
import com.spring.hibernate.sercvice.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService{

	@Autowired
	private BookShopDao bookShopDao;
	
	/*
	 * Spring hibernate事务流程
	 * 1.在方法开始之前
	 * 		1.获取Session
	 * 		2.把Session和当前线程绑定，这样就可以在Dao中使用SessionFactory的
	 * 		getCurrentSession()方法来获取Session了
	 * 		3.开启事务
	 * 2.若方法正常结束，即没有出现异常，则
	 * 		1.提交事务
	 * 		2.使和当前线程绑定的Session解除绑定
	 * 		3.关闭Session
	 * 3.若方法出现异常，则
	 * 		1.回滚事务
	 * 		2 使和当前线程绑定的Session解除绑定
	 * 		3.关闭Session
	 * */
	@Override
	public void purchase(String username, String isbn) {
		int price=bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}

}
