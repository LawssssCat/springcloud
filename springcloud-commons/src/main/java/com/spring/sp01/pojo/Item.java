package com.spring.sp01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
	private Integer id ; 
	private String name ;
	/**商品库存 or 选择数量*/
	private Integer number ;
}
