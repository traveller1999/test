package com.qa.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.qa.springboot.pojo.Goodsimage;
import com.qa.springboot.pojo.Goodsinfo;
import com.qa.springboot.pojo.Goodsprice;
import com.qa.springboot.pojo.Typeinfo;
import com.qa.springboot.service.GoodsImageService;
import com.qa.springboot.service.GoodsInfoService;
import com.qa.springboot.service.GoodsPriceService;
import com.qa.springboot.service.TypeinfoService;

@RestController
@RequestMapping("/searchGoodsController")
public class SearchGoodsController {

	@Autowired
	GoodsInfoService gs;
	
	@Autowired
	GoodsImageService gis;
	
	@Autowired
	GoodsPriceService gps;
	
	@Autowired
	TypeinfoService ts;
	
	@RequestMapping("/search")
	public Map<String, Object> search(@RequestParam(value="tet",required=false)String tet,@RequestParam(value="utid",required=false)Integer utid,@RequestParam(value="stid",required=false)Integer stid){
		
		Map<String, Object> map = new HashMap<>();
		List<Goodsinfo> goodsinfo2=null;
		if(stid!=null){
			goodsinfo2 = gs.queryGoodsinfo3(tet, stid);
		}else{
			goodsinfo2 = gs.queryGoodsinfo(tet);
		}
		
		List<Goodsimage> goodsimg2=new ArrayList<>();
		List<Double> yuanjia=new ArrayList<>();
		List<Double> zhehou=new ArrayList<>();
		Set<String> keyword=new HashSet<>();
		Set<String> allkeyword=new HashSet<>();
		for (Goodsinfo goodsinfo : goodsinfo2) {
			Integer gdid = goodsinfo.getGdid();
			
			Goodsimage queryGoodsImage = gis.queryGoodsImage(gdid);
			goodsimg2.add(queryGoodsImage);
			
			Double p1 = gps.queryPrice(gdid, utid);
			zhehou.add(p1);
			Double p2 = gps.queryPrice(gdid, 1);
			yuanjia.add(p2);
			
			//收集分类的关键字
			if(tet==null){
				List<Typeinfo> list = ts.querytypeinfo();
				for (Typeinfo typeinfo : list) {
					String tpname = typeinfo.getTpname();
					allkeyword.add(tpname);
				}
				map.put("keyword", allkeyword);
			}else{
				String gtkeywords = goodsinfo.getGtkeywords();
				String trim = gtkeywords.trim();
				String[] split = trim.split(" ");
				for (String s : split) {
					keyword.add(s);
				}
				map.put("keyword", keyword);
			}
			
		}
		
		map.put("goodsinfo2", goodsinfo2);
		map.put("goodsimg2", goodsimg2);
		map.put("yuanjia", yuanjia);
		map.put("zhehou", zhehou);
		
		
		
		
		
		return map;
		
	}
	@RequestMapping("/search2")
	public Map<String, Object> search2(@RequestParam(value="tet",required=false)String tet,@RequestParam(value="utid",required=false)Integer utid,@RequestParam(value="word",required=false)String word){
		Map<String, Object> map = new HashMap<>();
		List<Goodsinfo> goodsinfo2 = gs.queryGoodsinfo2(tet,word);
		List<Goodsimage> goodsimg2=new ArrayList<>();
		List<Double> yuanjia=new ArrayList<>();
		List<Double> zhehou=new ArrayList<>();
		Set<String> keyword=new HashSet<>();
		Set<String> allkeyword=new HashSet<>();
		for (Goodsinfo goodsinfo : goodsinfo2) {
			Integer gdid = goodsinfo.getGdid();
			
			Goodsimage queryGoodsImage = gis.queryGoodsImage(gdid);
			goodsimg2.add(queryGoodsImage);
			
			Double p1 = gps.queryPrice(gdid, utid);
			zhehou.add(p1);
			Double p2 = gps.queryPrice(gdid, 1);
			yuanjia.add(p2);
			
			//收集分类的关键字
			if(tet==null){
				List<Typeinfo> list = ts.querytypeinfo();
				for (Typeinfo typeinfo : list) {
					String tpname = typeinfo.getTpname();
					allkeyword.add(tpname);
				}
				map.put("keyword", allkeyword);
			}else{
				String gtkeywords = goodsinfo.getGtkeywords();
				String trim = gtkeywords.trim();
				String[] split = trim.split(" ");
				for (String s : split) {
					keyword.add(s);
				}
				map.put("keyword", keyword);
			}
			
		}
		
		map.put("goodsinfo2", goodsinfo2);
		map.put("goodsimg2", goodsimg2);
		map.put("yuanjia", yuanjia);
		map.put("zhehou", zhehou);
		
		
		
		
		
		return map;
		
	}
	@RequestMapping("/jiage")
	public Map<String, Object> jiage(@RequestParam("minj")Integer minj,@RequestParam("maxj")Integer maxj,@RequestParam("utid")Integer utid,@RequestParam("goodsinfos")String goodsinfos){
		Map<String, Object> map = new HashMap<>();
		
		List<Goodsinfo> j = (List<Goodsinfo>)JSONArray.parseArray(goodsinfos, Goodsinfo.class);
		
		List<Integer> gdids= new ArrayList<>();
		
		for (Goodsinfo goodsinfo : j) {
			Integer gdid = goodsinfo.getGdid();
			gdids.add(gdid);
		}
		List<Goodsprice> list = gps.queryGdidAndPrice(maxj, minj, utid, gdids);
		
		//goodsinfo集合
		List<Goodsinfo> goodsinfo = new ArrayList<>();
		//goodsimg集合
		List<Goodsimage> goodsimage = new ArrayList<>();
		//原价集合
		List<Double>yjia = new ArrayList<>();
		//折后价集合
		List<Double>zjia = new ArrayList<>();
		//关键字
		Set<String> word= new HashSet<>();
		
		for (Goodsprice gp : list) {
			Integer gdid = gp.getGdid();
			//存商品对象集合
			Goodsinfo gf = gs.queryGoodsInfoByGdid(gdid);
			goodsinfo.add(gf);
			//存商品图片对象集合
			Goodsimage queryGoodsImage = gis.queryGoodsImage(gdid);
			goodsimage.add(queryGoodsImage);
			//存折后价
			Double p1 = gp.getPrice();
			zjia.add(p1);
			//存原价
			Double p2 = gps.queryPrice(gdid, 1);
			yjia.add(p2);
			//存关键字
			String s = gf.getGtkeywords();
			String ss = s.trim();
			String[] split = ss.split(" ");
			for (String sss : split) {
				word.add(sss);
			}
		}
		map.put("goodsinfo2", goodsinfo);
		map.put("goodsimg2", goodsimage);
		map.put("yuanjia", yjia);
		map.put("zhehou", zjia);
		map.put("keyword", word);
		
		return map;
	}
}
