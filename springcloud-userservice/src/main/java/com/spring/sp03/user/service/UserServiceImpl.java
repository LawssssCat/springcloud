package com.spring.sp03.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.spring.sp01.pojo.User;
import com.spring.sp01.service.UserService;
import com.spring.sp01.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	@Value("${sp.user-service.users}")
	private String userJson ;
	
	@Override
	public User getUser(Integer id) {
		log.info("users json string : {}", userJson);
		List<User> list = JsonUtil.from(userJson, new TypeReference<List<User>>() {});
		for (User user : list) {
			if(user.getId().equals(id)) {
				return user ;
			}
		}
		return new User(id, "name-"+id, "pwd-"+id);
	}

	@Override
	public void addScore(Integer id, Integer score) {
		// 这里添加积分
		log.info("user {} - 添加积分 {}", id, score);
	}

}
