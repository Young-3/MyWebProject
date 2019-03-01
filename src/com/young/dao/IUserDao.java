package com.young.dao;

import com.young.entity.User;

import java.util.List;

public interface IUserDao {
	public List<User> checkLogin(User user) ;
}
