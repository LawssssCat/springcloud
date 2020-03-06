package com.spring.sp04.service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.sp01.pojo.Item;
import com.spring.sp01.util.JsonResult;
import com.spring.sp04.service.FB.ItemFeignServiceFB;

@FeignClient(name = "item-service", fallback = ItemFeignServiceFB.class)
public interface ItemFeignService {
	@GetMapping("/{orderId}")
	JsonResult<List<Item>> getItems(@PathVariable("orderId") String orderId) ;
	@PostMapping("/decreaseNumber") 
	JsonResult decreaseNumber(@RequestBody List<Item> items) ;
}
