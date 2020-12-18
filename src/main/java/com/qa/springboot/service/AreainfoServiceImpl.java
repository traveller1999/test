package com.qa.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.AreainfoMapper;
import com.qa.springboot.pojo.Areainfo;
@Service
public class AreainfoServiceImpl implements AreainfoService{

	@Autowired
	AreainfoMapper am;
	
	@Override
	public List<Areainfo> queryAll() {
		
		return am.selectByExample(null);
	}

}
