package com.qa.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.pojo.Areainfo;
import com.qa.springboot.pojo.Orderinfo;
import com.qa.springboot.service.AreainfoService;
import com.qa.springboot.service.OrderInfoService;

@RestController
@RequestMapping("/areainfoController")
public class AreainfoController {

	@Autowired
	AreainfoService as;
	
	@Autowired
	OrderInfoService os;
	
	@RequestMapping("/query")
	public Map<String, Object> query(){
		Map<String, Object> map =new HashMap<>();
		
		List<Areainfo> list = as.queryAll();
		System.out.println(list.size());
		
		Orderinfo orderinfo = os.queryOrderinfo(1);
		
		map.put("areainfo", list);
		
		map.put("defaultorder", orderinfo);
		return map;
	}
}
