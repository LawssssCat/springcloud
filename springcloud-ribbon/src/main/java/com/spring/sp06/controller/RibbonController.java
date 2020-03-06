package com.spring.sp06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.sp01.pojo.Item;
import com.spring.sp01.pojo.Order;
import com.spring.sp01.pojo.User;
import com.spring.sp01.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RibbonController {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 请求后台的产品服务 http://localhost:8001/{orderId}
	 */
	@GetMapping("/item-service/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable("orderId") String orderId) {
		//  这里服务器路径用 service-id 代替，ribbon 会向服务的多台集群服务器分发请求
		// 另外在Eureka中，服务名称不区分大小写
		return restTemplate.getForObject("http://ITEM-SERVICE/{1}", JsonResult.class, orderId);
	}

	/**
	 * http://localhost:8001/decreaseNumber
	 */
	@PostMapping("/item-service/decreaseNumber")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
		return restTemplate.postForObject("http://ITEM-SERVICE/decreaseNumber", items, JsonResult.class);
	}

	////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/user-service/{userId}")
	public JsonResult<User> getUser(@PathVariable("userId") Integer userId) {
		return restTemplate.getForObject("http://USER-SERVICE/{1}", JsonResult.class, userId);
	}

	@GetMapping("/user-service/{userId}/score")
	public JsonResult addScore(@PathVariable("userId") Integer userId, Integer score) {
		return restTemplate.getForObject("http://USER-SERVICE/{1}/score?score={2}", JsonResult.class, userId, score);
	}

	//////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/order-service/{orderId}")
	public JsonResult<Order> getOrder(@PathVariable("orderId") String orderId) {
		return restTemplate.getForObject("http://ORDER-SERVICE/{1}", JsonResult.class, orderId);
	}

	@GetMapping("/order-service")
	public JsonResult addOrder() {
		return restTemplate.getForObject("http://ORDER-SERVICE/", JsonResult.class);
	}
}
