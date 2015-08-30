package org.springframework.social.weixin.api.impl;

import org.springframework.social.support.URIBuilder;
import org.springframework.social.weixin.api.Weixin;
import org.springframework.social.weixin.api.bean.User;
import org.springframework.social.weixin.api.operation.UserOperations;
import org.springframework.web.client.RestTemplate;

public class WeixinUserTemplate implements UserOperations {
	
	static final String URI = "https://api.weixin.qq.com/sns/oauth2/access_token"; 
	static final String URI_USERINFO = "https://api.weixin.qq.com/cgi-bin/user/info";
	private RestTemplate rest;
	private Weixin weixinApi;
	private User user;

	public WeixinUserTemplate(RestTemplate rest, Weixin weixinApi) {
		super();
		this.rest = rest;
		this.weixinApi = weixinApi;
	}

	public User getWeixinUser(String openid) {
		user = rest.getForObject(URIBuilder.fromUri(URI_USERINFO).queryParam("openid", openid).toString(), User.class);
		return user;
	}

}
