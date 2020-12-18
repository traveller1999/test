package com.qa.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.pojo.Orderinfo;
import com.qa.springboot.service.OrderInfoService;

@RestController
@RequestMapping("/addOrderinfoController")
public class AddOrderinfoController {

	@Autowired
	OrderInfoService os;
	
	@RequestMapping("/add")
	public Map<String, Object> add(Orderinfo orderinfo){
		orderinfo.setOfid("o"+(int)(Math.random()*10000));
		Map<String, Object>map = new HashMap<>();
		
		os.addOrderinfo(orderinfo);
		
		List<Orderinfo> list = os.queryUserinfo(orderinfo.getUserid());
		
		map.put("orderinfo", list);
		return map;
	}
}
