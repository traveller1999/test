package com.qa.springboot.service;

import java.util.List;

import com.qa.springboot.pojo.Orderinfo;

public interface OrderInfoService {
	//根据用户ID查询订单
	List<Orderinfo> queryUserinfo(int userid);
	//查询默认地址
	Orderinfo queryOrderinfo(int ofstate);
	
	//地址添加
	void addOrderinfo(Orderinfo orderinfo);
}
