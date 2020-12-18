package com.qa.springboot.service;

import java.util.List;

import com.qa.springboot.pojo.Areainfo;

public interface AreainfoService {

	//获取所有areainfo对象
	List<Areainfo> queryAll();
}
