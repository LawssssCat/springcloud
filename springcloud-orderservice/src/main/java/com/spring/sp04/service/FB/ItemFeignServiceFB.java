package com.spring.sp04.service.FB;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.sp01.pojo.Item;
import com.spring.sp01.util.JsonResult;
import com.spring.sp04.service.feign.ItemFeignService;

@Component
public class ItemFeignServiceFB implements ItemFeignService {

	// 模拟缓存数据
	@Override
	public JsonResult<List<Item>> getItems(String orderId) {
		if (Math.random() < 0.5) {
			return JsonResult.ok().data(Arrays.asList(new Item[] {
					new Item(1, "缓存1" , 22) , 
					new Item(2, "缓存2" , 33) , 
					new Item(3, "缓存3" , 44) , 
					new Item(4, "缓存4" , 66) , 
					new Item(5, "缓存5" , 99)  
			}));
		}
		return JsonResult.err("无法获取订单列表");
	}

	@Override
	public JsonResult decreaseNumber(List<Item> items) {
		return JsonResult.err("无法修改商品库存");
	}

}
