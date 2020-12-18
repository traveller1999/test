package com.qa.springboot.service;

import java.util.List;

import com.qa.springboot.pojo.Goodsprice;

public interface GoodsPriceService {
	//根据商品ID和用户等级查询商品价格
	Double queryPrice(int gdid,int utid);
	
	//根据商品ID和商品价格区间，和用户等级 查询商品的ID与价格
	List<Goodsprice> queryGdidAndPrice(int maxj,int minj,int utid,List<Integer> gdids);
}
