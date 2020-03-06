package com.spring.sp01.service;

import com.spring.sp01.pojo.Order;

public interface OrderService {
	/** 根据订单id获取订单 */
	Order getOrder(String orderId);

	/** 保存订单的操作 */
	void addOrder(Order order);
}
