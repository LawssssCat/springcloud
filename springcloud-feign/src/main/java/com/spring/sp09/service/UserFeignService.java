package com.spring.sp09.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sp01.pojo.User;
import com.spring.sp01.util.JsonResult;
import com.spring.sp09.service.fb.UserFeignServiceFB;

@FeignClient(name="user-service", fallback = UserFeignServiceFB.class)
public interface UserFeignService {

	@GetMapping("/{userId}")
	JsonResult<User> getUser(@PathVariable("userId") String id);

	@GetMapping("/{userId}/score")
	JsonResult addScore(@PathVariable("userId") Integer id, @RequestParam("score") Integer score);

}
