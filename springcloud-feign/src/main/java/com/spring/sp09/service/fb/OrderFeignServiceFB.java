package com.spring.sp09.service.fb;

import org.springframework.stereotype.Component;

import com.spring.sp01.pojo.Order;
import com.spring.sp01.util.JsonResult;
import com.spring.sp09.service.OrderFeignService;

@Component
public class OrderFeignServiceFB implements OrderFeignService {

	@Override
	public JsonResult<Order> getOrder(String orderId) {
		return JsonResult.err("无法获取商品订单");
	}

	@Override
	public JsonResult addOrder() {
		return JsonResult.err("无法保存订单");
	}

}
