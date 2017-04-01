package com.mvn.user.dao;

import com.mvn.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mvntest
 *
 * @author Created by LiYao on 2017-03-03 21:16.
 */
@Repository
public interface UserMapper {

	// @Select("select * from user")
	List<User> selectUsers();

}
