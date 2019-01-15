package com.hrms.util;

import java.util.UUID;


public class CreateGUID {

	/**
	 * 生成GUID
	 * @return GUID
	 */
	public static String createGuId(){
		UUID uuid = UUID.randomUUID();
		String uuIdStr = uuid.toString();
		uuIdStr = uuIdStr.replace("-", "");
		return uuIdStr;
	}
}
