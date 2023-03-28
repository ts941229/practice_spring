package com.practice.practice1.global;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	private static Util util;
	
	private Util() {}
	
	public static Util getInstance() {
		
		if(util == null) {
			util = new Util();
		}
		
		return util;
	}
	
	public String DateFormat(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		return simpleDateFormat.format(date);
		
	}

}
