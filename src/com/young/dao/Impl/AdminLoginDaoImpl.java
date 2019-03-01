package com.young.dao.Impl;

import com.young.dao.IUserDao;
import com.young.entity.User;

import java.util.List;

/**
 * @author Young
 * @version1.0
 */
public class AdminLoginDaoImpl implements IUserDao {
	public List<User> checkLogin(User user){
		System.out.println("StuLoginDaoImpl.checkLogin");
		List list = null;
		return list;
	}
}
