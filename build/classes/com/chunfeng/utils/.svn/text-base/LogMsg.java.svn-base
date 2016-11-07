package com.chunfeng.utils;

public class LogMsg {
	private static final boolean DEBUG = true;
	
	public static void print(String tag,Object...objs){
		if(!DEBUG){
			return;
		}
		StringBuffer sb = new StringBuffer();
		if(tag != null){
			sb.append(tag);
		}else{
			sb.append("null");
		}
		boolean first = true;
		for(Object object : objs){
			if(object == null){
				object = "null";
			}
			if(first){
				sb.append(" = ").append(object.toString());
				first = false;
			}else {
				sb.append(", ").append(object.toString());
			}
		}
		System.out.println(sb);
	}
}
