package org.springframework.social.weixin.api.impl;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.social.weixin.api.Weixin;
import org.springframework.social.weixin.api.operation.UserOperations;
import org.springframework.web.client.RestOperations;

public class WeixinTemplate extends AbstractOAuth2ApiBinding implements Weixin {

	public WeixinTemplate() {
		super();
	}

	public WeixinTemplate(String accessToken, TokenStrategy tokenStrategy) {
		super(accessToken, tokenStrategy);
	}

	public WeixinTemplate(String accessToken) {
		super(accessToken);
	}

	public RestOperations restOperations() {
		return getRestTemplate();
	}

	public UserOperations userOperations() {
		return null;
	}

}
