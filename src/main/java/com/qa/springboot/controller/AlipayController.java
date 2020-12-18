package com.qa.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.qa.springboot.config.AlipayConfig;
import com.qa.springboot.pojo.Orderinfo;
import com.qa.springboot.pojo.Orderlist;
import com.qa.springboot.service.OrderInfoService;
import com.qa.springboot.service.OrderlistService;

@RestController
@RequestMapping("/alipayController")
public class AlipayController {
	
	@Autowired
	OrderlistService os;
	
	@Autowired
	OrderInfoService ois;
	
	@RequestMapping("/pay")
	public String abc(@RequestBody(required=false)Orderlist olist ){
		
		String out_trade_no="";
		int sum=0;
		
			
				
				os.addorderlist(olist);
				out_trade_no=olist.getOlid();
				sum+=olist.getPrice();
				
				
			//付款金额，必填
			String total_amount = sum+"";

		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		//商户订单号，商户网站订单系统中唯一订单号，必填
//		String out_trade_no ="";
//		//付款金额，必填
//		String total_amount = "";
		//订单名称，必填
		String subject = "我的订单";
		//商品描述，可空
		String body = "";
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//请求
		String result="";
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
