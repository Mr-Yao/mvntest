package com.mvn.user.service.impl;

import com.mvn.core.base.BaseServiceImpl;
import com.mvn.user.dao.UserMapper;
import com.mvn.user.entity.User;
import com.mvn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * mvntest
 *
 * @author Created by LiYao on 2017-03-07 20:10.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void selectUsers() {
		List<User> list = this.userMapper.selectUsers();
		for (User u : list) {
			System.out.println(u);
		}
	}
}
