package com.qa.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.TypeinfoMapper;
import com.qa.springboot.pojo.Typeinfo;
@Service
public class TypeinfoServiceImpl implements TypeinfoService{

	@Autowired
	TypeinfoMapper tm;
	
	@Override
	public List<Typeinfo> querytypeinfo() {
		
		return tm.selectByExample(null);
	}

}
