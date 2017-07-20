package com.thinkgem.jeesite.modules.sys.entity;

import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.persistence.Page;

import java.util.Map;

public class AppResult {
	public static Map<String, Object> appSuccessResult(Object rDate) {
		Map<String, Object> r = Maps.newHashMap();
		r.put("rCode", "0");
		r.put("rInfo", "成功");
		r.put("rDate", rDate);
		return r;
	}

	public static Map<String, Object> appErrorResult(String errorCode,
			String errorMsg) {
		Map<String, Object> r = Maps.newHashMap();
		r.put("rCode", errorCode);
		r.put("rInfo", errorMsg);
		return r;
	}

	public static void setPageInfo(Map<String, Object> r, Page<?> page) {
		r.put("rPageCount", page.getCount());
		r.put("rPageLast", page.getLast());
		r.put("rPageNo", page.getPageNo());
		r.put("rPageSize", page.getPageSize());
	}

}
