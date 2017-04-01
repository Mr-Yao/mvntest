package com.mvn.user.controller;

import com.mvn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * mvntest
 *
 * @author Created by LiYao on 2017-03-07 20:11.
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	@ResponseBody
	public String login() {
		this.userService.selectUsers();
		System.out.println(2 / 0);
		return "OK";
	}

}
