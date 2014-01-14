package net.wincn.mybatis.service;

import net.wincn.mybatis.mapper.UserMapper;
import net.wincn.mybatis.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooService {
	@Autowired
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public User getUser(){
		return userMapper.getUserByID(1);
	}
}
