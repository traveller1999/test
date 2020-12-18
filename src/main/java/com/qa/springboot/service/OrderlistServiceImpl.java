package com.qa.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.OrderlistMapper;
import com.qa.springboot.pojo.Orderlist;

@Service
public class OrderlistServiceImpl implements OrderlistService{

	@Autowired
	OrderlistMapper om;
	
	@Override
	public void addorderlist(Orderlist orderlist) {
		
		om.insert(orderlist);
	}

}
