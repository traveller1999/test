package com.qa.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.OrderinfoMapper;
import com.qa.springboot.pojo.Orderinfo;
@Service
public class OrderInfoServiceImpl implements OrderInfoService{

	@Autowired
	OrderinfoMapper om;
	
	@Override
	public List<Orderinfo> queryUserinfo(int userid) {
		
		return om.selectOrderinfoByUserid(userid);
	}

	@Override
	public Orderinfo queryOrderinfo(int ofstate) {
		// TODO Auto-generated method stub
		return om.selectOrderinfoByOfstate(ofstate);
	}

	@Override
	public void addOrderinfo(Orderinfo orderinfo) {
		
		om.insert(orderinfo);
	}

}	
