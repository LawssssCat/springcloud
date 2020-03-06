package com.spring.sp09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sp01.pojo.Item;
import com.spring.sp01.pojo.Order;
import com.spring.sp01.pojo.User;
import com.spring.sp01.util.JsonResult;
import com.spring.sp09.service.ItemFeignService;
import com.spring.sp09.service.OrderFeignService;
import com.spring.sp09.service.UserFeignService;

@RestController
public class FeignController {

	@Autowired
	private ItemFeignService itemFeignService;

	@GetMapping("/item-service/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable("orderId") String orderId) {
		return itemFeignService.getItems(orderId);
	}

	@PostMapping("/item-service/decreaseNumber")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
		return itemFeignService.decreaseNumber(items);
	}

	///////////////////////////////////////////////////////////////

	@Autowired
	private UserFeignService userFeignService;

	@GetMapping("/user-service/{userId}")
	JsonResult<User> getUser(@PathVariable("userId") String id) {
		return userFeignService.getUser(id);
	}

	@GetMapping("/user-service/{userId}/score")
	JsonResult addScore(@PathVariable("userId") Integer id, @RequestParam("score") Integer score) {
		return userFeignService.addScore(id, score);
	}

	///////////////////////////////////////////////////////////////

	@Autowired
	private OrderFeignService orderFeignService;

	@GetMapping("/order-service/{orderId}")
	public JsonResult<Order> getOrder(@PathVariable("orderId") String orderId) {
		return orderFeignService.getOrder(orderId);
	}

	@GetMapping("/order-service/")
	public JsonResult addOrder() {
		return orderFeignService.addOrder();
	};

}
