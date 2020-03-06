package com.spring.sp09.service.fb;

import org.springframework.stereotype.Component;

import com.spring.sp01.pojo.User;
import com.spring.sp01.util.JsonResult;
import com.spring.sp09.service.UserFeignService;

@Component
public class UserFeignServiceFB implements UserFeignService {

	@Override
	public JsonResult<User> getUser(String id) {
		return JsonResult.err("无法获取用户信息");
	}

	@Override
	public JsonResult addScore(Integer id, Integer score) {
		return JsonResult.err("无法添加用户积分");
	}

}
