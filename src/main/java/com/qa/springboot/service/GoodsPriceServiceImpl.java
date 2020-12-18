package com.qa.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.GoodspriceMapper;
import com.qa.springboot.pojo.Goodsprice;

@Service
public class GoodsPriceServiceImpl implements GoodsPriceService{
	
	@Autowired
	GoodspriceMapper gm;
	
	@Override
	public Double queryPrice(int gdid, int utid) {
		
		return gm.selectPrice(gdid, utid);
	}

	@Override
	public List<Goodsprice> queryGdidAndPrice(int maxj, int minj, int utid, List<Integer> gdids) {
		
		return gm.selectGoodsPriceByMaxAndMin(maxj, minj, utid, gdids);
	}

}
