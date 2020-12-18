package com.qa.springboot.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

			// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
			public static String app_id = "2016102400750725";
			
			// 商户私钥，您的PKCS8格式RSA2私钥
			public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCV1iWF6XyKjlCHyEjq8mhSeUEeyIi0TgUIpes0Bp6KDq6zX9cr4GEyQL0pVCyMbkZRWI1e2qn03GnAgHWanfT+OGqdA882gT+DuuTMzJCiQDUzgXz6SC80EFGdYb12iwiG3fcBIYmHwR6ruYnyDPsRTsbo0ueiyKJLdC6rw62DH9A/hwFYmCjy+2vnfCOJqgPEjDxceJTu14CbELRJnqZP6SP/7prCU09yH9iYGoA/DIwaabGD75D8OApfWEPbMSlzKFO808a2K/OAGDoX38t098j9JTkRMwe9PTiUKp/hIbn/KTFHKYhXOz4DKLLH9k6f5Ma1BtOjoT5KfEKbuAXVAgMBAAECggEAb67T/zGe2+PiEKNv/ne63KZ2rIxKoSJ6TAzn+LpqV3tEKn1oc9Lmf7+Tf4e3QOE9VorLrQUNo27bAFp/zkSohQjmJqzdOcIy5mxa+HAN6nIzdXWyAxfk30i+nLFquD4/l89Auj4WNfLzeopsUNfuF+OBDa+Oal5j4hvyYaMT5OSYurGxcGQ7XOJZ0A3O1Yb1dVSGAC01Bl9j2IIAi0X3l/WaBRNiyqSY9M0pP20/KFCwbabEl1XB2Y+kY6eUSnTzkxqIHOuQMTRfbBD5bRm1A/LzB1+C+pvZZqfDy2zm+tJOEzpJD2TBXzsgUAUNQL4JE/kniNZxHjvZpvVTxqkeLQKBgQD3K+zH2lg3HLY1AeKMv2JCypn9/i08tyDvQSVdW4VEiqTQyQSYQlpwC9ya95MuAT3JHxhyISuwF/xW0sif9+xQRk5V424CISNHDSisErR2uWUihpLL1+fUTS3Cf6vutDrkiXC0vHGPt9OcUsL/9s+F8tf7iKAdeX/4LQZcXl2ZrwKBgQCbMDbQbwGpNNQni3/nvZVTaf3BbYXEJUOQ6AUg5HQlLxW5s7/OvkFPlXAzLex3wEDTVKn8b6O7PxEO/HbyUwDbKpZGsmyyCBF1ekPtLejHjTrlVrNozikG06cTad3Sw5xKoJT6ymIFS2vDfDQto0ChtN9/AuKPAMKyWIR1kjstuwKBgQC7sBITzDwyVU4SwESsxeMyfrAii7EEKrcKlrhtxMJUwsbWd95SVAhijs9MqXSMeYrWPxOMDp4jEIOf1l1cA6HhbxGq7JErcshb+qUIzQdWI/+lEPVFbsRulNCLofEHyLnzsl3wECxXiqpYSQwj2+HHgBj7usqCtzEyXdY3q7x9pwKBgGvqvVN4vkjyac4OHiYDGkJlZIcMKIdb+n5cOqTC+VmaQpteujWE7Fnxa5LLjrM/yFStfYAECnH9y1kGi5i7y86c8N+82AV9wtZU7cOTt1p9hcVR43UwWCtdJ8RCTHVyfc8PmEpGTp+r8QaB6q8J5boN05W5Zd9YAgyPrZ0s0WZdAoGBAKusp05LkXYEvG4T9Ks83B0jlPsvBo0wBZL7rPd7Tx2PS//3oUzs2sj8xJayU+45UXhOMaBXBjNbBPcEzXNqAsIm62PedmmNjaOrRtsEadcyjExGgnBbJf+zM9R2BxUfz/wcoiFX9IvukKjqwkJRWN4MQPWa+HwNB9FuJ1Oq5VVE";
			// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
			public static String alipay_public_key ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
			// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
			public static String notify_url = "http://localhost:8080/";

			// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
			public static String return_url = "http://localhost:8080/";

			// 签名方式
			public static String sign_type = "RSA2";
			
			// 字符编码格式
			public static String charset = "utf-8";
			
			// 支付宝网关
			public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
			
			// 支付宝网关
			public static String log_path = "C:\\";


		//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

		    /** 
		     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
		     * @param sWord 要写入日志里的文本内容
		     */
		    public static void logResult(String sWord) {
		        FileWriter writer = null;
		        try {
		            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
		            writer.write(sWord);
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            if (writer != null) {
		                try {
		                    writer.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		    }
}
