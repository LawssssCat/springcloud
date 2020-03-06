package com.spring.sp01.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
	/**如:UUI,按一定规则生成*/
	private String id ; 
	/**谁的订单*/
	private User user ;
	/**购买了什么商品*/
	private List<Item> items ;
}
