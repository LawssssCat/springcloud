package com.spring.sp09.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.sp01.pojo.Order;
import com.spring.sp01.util.JsonResult;
import com.spring.sp09.service.fb.OrderFeignServiceFB;

@FeignClient(name = "order-service", fallback = OrderFeignServiceFB.class)
public interface OrderFeignService {

	@GetMapping("/{orderId}")
	public JsonResult<Order> getOrder(@PathVariable("orderId") String orderId);

	@GetMapping("/")
	public JsonResult addOrder();
}
