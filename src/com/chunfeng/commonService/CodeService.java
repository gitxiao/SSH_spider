package com.chunfeng.commonService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.netease.checksum.CheckSumBuilder;

@Stateless
@Path("yunxin")
public class CodeService {

	public static final String appKey = "58ffa7fc29815f3f09e5654df681526e";
	public static final String appSecret = "359eafbeb233";
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("sendCode")
	@Produces("application/json")
	public Object sendCode(@FormParam("mobileNum") String mobileNum){
		// 设置请求的的参数
		List nvps = new ArrayList();
		// 参数 jsonArray形式
		nvps.add(new BasicNameValuePair("mobile", mobileNum));
		String url = "https://api.netease.im/sms/sendcode.action";
		return excuteRequest(url,nvps);
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("verifyCode")
	@Produces("application/json")
	public Object verifyCode(@FormParam("mobileNum") String mobileNum,@FormParam("code") String code){
		// 设置请求的的参数
		List nvps = new ArrayList();
		// 									参数 jsonArray形式
		nvps.add(new BasicNameValuePair("mobile", mobileNum));
		// 									参数
		nvps.add(new BasicNameValuePair("code", code));

		String url = "https://api.netease.im/sms/verifycode.action";
		return excuteRequest(url,nvps);
	}
	
	public HttpPost getHttpPost(String url){
		HttpPost httpPost = new HttpPost(url);
		String nonce = new Random().nextInt(1000000) + "" + new Random().nextInt(1000000);// nonce随机数733877558517
		System.out.println("随机码 nonce = " + nonce);
		String curTime = String.valueOf((new Date()).getTime() / 1000L);// time
		String checkSum = CheckSumBuilder.getCheckSum(CodeService.appSecret, nonce, curTime);// 参考计算CheckSum的java代码

		// 设置请求的header
		httpPost.addHeader("AppKey", CodeService.appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		return httpPost;
	}
	
	@SuppressWarnings("unchecked")
	private Result excuteRequest(String url,List nvps){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = getHttpPost(url);
		HttpResponse response = null;
		Result res = null;
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			// 执行请求
			response = httpClient.execute(httpPost);
			// 打印执行结果
			String resString = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println(resString);
			res = new Gson().fromJson(resString, Result.class);
		} catch(Exception e){
			e.printStackTrace();
			res = new Result();
			res.setCode(-1);
		}
		return res;
	}
	
	
	public static void main(String[] args) throws Exception {
//		new CodeService().sendCode("15369865680");
		new CodeService().verifyCode("15369865680","8108");
	}
	
	class Result{
		private Integer code;
		private String msg;
		private Integer obj;

		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public Integer getObj() {
			return obj;
		}
		public void setObj(Integer obj) {
			this.obj = obj;
		}
	}
}
