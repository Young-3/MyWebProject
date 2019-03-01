package com.young.service.Impl;

import com.young.dao.IUserDao;
import com.young.dao.Impl.AdminLoginDaoImpl;
import com.young.dao.Impl.StuLoginDaolmpl;
import com.young.dao.Impl.TeaLoginDaoImpl;
import com.young.servlet.LoginCheckServlet;
import com.young.entity.User;
import com.young.service.IUserLoginService;

import java.util.List;

/**
 * @author Young
 * @version1.0
 */
public class UserLoginServiceImpl implements IUserLoginService {
	public List<User> stuLogin(User user){
		System.out.println("service-login");
		IUserDao stuDao = new StuLoginDaolmpl();
		List list = stuDao.checkLogin(user);
		return list;
	}

	public List<User> teaLogin(User user){
		System.out.println("service-login");
		IUserDao teaDao = new TeaLoginDaoImpl();
		List list = teaDao.checkLogin(user);
		return list;
	}

	public List<User> adminLogin(User user){
		System.out.println("service-login");
		IUserDao adminDao = new AdminLoginDaoImpl();
		List list = adminDao.checkLogin(user);
		return list;
	}


}
