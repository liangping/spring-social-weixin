package org.springframework.social.weixin.api;

import java.util.HashMap;
import java.util.Map;

public abstract class WeixinObject {
	private Map<String, Object> extraData;

	public WeixinObject() {
		extraData = new HashMap<String, Object>();
	}
	public Map<String, Object> getExtraData() {
		return extraData;
	}
	protected void add(String key, Object value) {
		extraData.put(key, value);
	}
	
}
