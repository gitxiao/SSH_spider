package com.cfrj.sppm.cfesf.utils;

import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


public class Common {
	
	//功能：把传入的参数进行解码，处理中文问题�?
	//作�?：宁利广
	//日期�?012-4-24
	public static String getDecoderUrl(String url)throws Exception{
		return java.net.URLDecoder.decode(url, "utf-8");			
	}

	@SuppressWarnings("deprecation")
	public static String getConfigPath(String fileName){
		String appListPath = Common.class.getResource("/").getFile().toString();
		File subFile = new File(appListPath);
		File file = subFile.getParentFile();
		appListPath = URLDecoder.decode(file.getAbsolutePath() + "/" + fileName);
		return appListPath;
	}
	
	/**
	 * 创建WebApplicationException, 使用标准状�?码与自定义信�?
	 */
	public static WebApplicationException buildException(Status status, String message) {
		throw new WebApplicationException(Response.status(status).entity(message).type("text/plain").build());
	}
	
/*	*//**
	 * 创建WebApplicationException, 使用自定义状态码与自定义信息.
	 *//*
	private WebApplicationException buildException(int status, String message) {
		log.error(message);
		return new WebApplicationException(Response.status(status).entity(message).type("text/plain").build());
	}*/
	
	 //用于文件的唯�?���?
	 public static String getUUID(){  
		  String uuid = UUID.randomUUID().toString();//获取随机唯一标识�? 
		  //去掉标识符中�?-"  
		  uuid = uuid.substring(0, 8)+uuid.substring(9,13)+uuid.substring(14,18)+uuid.substring(19,23)+uuid.substring(24);  
		  return uuid;  
	} 
	 
	//获取10位的随机码 
	public static String getRandomStr(){
		String base = "!#@abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < 10; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();
	}
	
	/**
	 * @@author liyutao
	 * @param dateFormat
	 * 获取系统日期
	 * @return
	 */
	public static String getSysTime(String dateFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(new Date());
	}
	
	/**
	 * @author liyutao
	 * @param code
	 * 生成最新的订单编号的后四位
	 * @return
	 */
	public static String lastCode(String code){
		String str = code.substring(code.length()-4);
		Integer num = Integer.parseInt(str);
		num++;
		if(num<10){
			return "000"+num;
		}else if(num<100){
			return "00"+num;
		}else if(num<1000){
			return "0"+num;
		}else{
			return String.valueOf(num);
		}
	}
	
}
