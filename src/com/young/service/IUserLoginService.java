package com.young.service;

import com.young.entity.User;

import java.util.List;

/**
 * @author Young
 * @version1.0
 */
public interface IUserLoginService {
	public List<User> stuLogin(User user);
	public List<User> teaLogin(User user);
	public List<User> adminLogin(User user);



}
