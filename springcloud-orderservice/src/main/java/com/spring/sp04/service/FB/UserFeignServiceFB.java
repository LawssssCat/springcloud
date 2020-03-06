package com.spring.sp04.service.FB;

import org.springframework.stereotype.Component;

import com.spring.sp01.pojo.User;
import com.spring.sp01.util.JsonResult;
import com.spring.sp04.service.feign.UserFeignService;

@Component
public class UserFeignServiceFB implements UserFeignService {

	// 模拟缓存
	@Override
	public JsonResult<User> getUser(Integer userId) {
		if (Math.random() < 0.4) {
			return JsonResult.ok().data(new User(userId, "缓存name" + userId, "缓存pwd" + userId));
		}
		return JsonResult.err("无法获取用户信息");
	}

	@Override
	public JsonResult addScore(Integer userId, Integer score) {
		return JsonResult.err("无法添加用户积分");
	}

}
