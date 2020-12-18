package com.qa.springboot.service;

import java.util.List;

import com.qa.springboot.pojo.Goodsinfo;

public interface GoodsInfoService {
	//根据商品ID查询商品对象
	Goodsinfo queryGoodsInfoByGdid(int gdid);
	//根据关键字查询商品
	List<Goodsinfo> queryGoodsinfo(String tet);
	
	//根据关键字与分类查询
	List<Goodsinfo> queryGoodsinfo2(String tet,String word);
	
	//根据关键字与店铺ID查询商品集合
	List<Goodsinfo> queryGoodsinfo3(String tet,int stid);
}
