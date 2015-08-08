package org.springframework.social.weixin.security;

import org.springframework.social.security.provider.OAuth2AuthenticationService;
import org.springframework.social.weixin.api.Weixin;
import org.springframework.social.weixin.connect.WeixinConnectionFactory;

public class WeixinAuthenticationService extends OAuth2AuthenticationService<Weixin> {

	public WeixinAuthenticationService(String appid, String appSecret) {
		super(new WeixinConnectionFactory(appid, appSecret));
	}

}
