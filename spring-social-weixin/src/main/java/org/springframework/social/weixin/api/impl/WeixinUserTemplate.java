package org.springframework.social.weixin.api.impl;

import org.springframework.social.weixin.api.Weixin;
import org.springframework.social.weixin.api.bean.WeixinUser;
import org.springframework.social.weixin.api.operation.UserOperations;
import org.springframework.web.client.RestTemplate;

public class WeixinUserTemplate implements UserOperations {
	
	static final String URI = "https://api.weixin.qq.com/sns/oauth2/access_token"; 
	private RestTemplate rest;
	private Weixin weixinApi;
	private WeixinUser user;

	public WeixinUserTemplate(RestTemplate rest, Weixin weixinApi) {
		super();
		this.rest = rest;
		this.weixinApi = weixinApi;
		user = rest.getForObject(URI, WeixinUser.class);
	}

	public String getId() {
		return user.getId();
	}

	public String getUnionid() {
		return user.getUnionid();
	}

	public WeixinUser getWeixinUser() {
		return user;
	}

}
