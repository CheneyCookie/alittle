package com.ssh.dao;

import org.hibernate.Query;

import com.ssh.entities.User;

public class UserDao extends BaseDao{
	public void saveOrUpdate(User user){
		getSession().saveOrUpdate(user);
	}
	public User getUserByName(String name){
		String hql="from User u where u.username=?";
		Query query=getSession().createQuery(hql).setString(0, name);
		return (User) query.uniqueResult();
		
	}
}
