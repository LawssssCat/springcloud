package com.spring.sp02.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sp01.pojo.Item;
import com.spring.sp01.service.ItemService;
import com.spring.sp01.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	// 注入目的。方便后面测试
	@Value("${server.port}")
	private int port;

	@GetMapping("/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable("orderId") String orderId) throws InterruptedException {
		log.info("port={}, order={}", port, orderId);

		//// --设置延迟
		if(Math.random()<0.6) {
			long t = new Random().nextInt(5000);
			log.info("item-server-{} -暂停 {}ms",port, t );
			Thread.sleep(t);
		}
		// ~

		List<Item> list = itemService.getItems(orderId);
		return JsonResult.ok(list).msg("port=" + port);
	}

	@PostMapping("/decreaseNumber")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
		itemService.decreaseNumbers(items);
		return JsonResult.ok();
	}

}
