package com.qa.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.GoodsinfoMapper;
import com.qa.springboot.pojo.Goodsinfo;
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService{

	@Autowired
	GoodsinfoMapper gm;
	
	@Override
	public Goodsinfo queryGoodsInfoByGdid(int gdid) {
		
		return gm.selectByPrimaryKey(gdid);
	}

	@Override
	public List<Goodsinfo> queryGoodsinfo(String tet) {
		// TODO Auto-generated method stub
		return gm.selectGoodsinfoBySearchName(tet);
	}

	@Override
	public List<Goodsinfo> queryGoodsinfo2(String tet, String word) {
		
		return gm.selectGoodsinfoBySearchName2(tet, word);
	}

	@Override
	public List<Goodsinfo> queryGoodsinfo3(String tet, int stid) {
		
		return gm.selectGoodsinfoBySearchName3(tet, stid);
	}

}
