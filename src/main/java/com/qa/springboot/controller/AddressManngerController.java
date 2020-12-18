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
@RequestMapping("/addressManngerController")
public class AddressManngerController {
	
	@Autowired
	OrderInfoService os;
	
	@RequestMapping("/queryAddress")
	public Map<String, Object> address(Integer userid){
		Map<String, Object> map = new HashMap<>();
		
		List<Orderinfo> orderinfo = os.queryUserinfo(userid);
		
		
		
		map.put("orderinfo", orderinfo);
		
		return map;
	}
}
