package com.dream.dream.businesscenter.service.module.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dream.dream.businesscenter.service.module.user.mapper.UserMapper;
import com.dream.dream.businesscenter.service.module.user.model.User;
import com.dream.dream.businesscenter.service.module.user.service.UserService;

@Service("UserService")
@Transactional(rollbackFor = { Exception.class })
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getUser(){
		List<User> list = userMapper.getUser();
		return list;
	}
}
