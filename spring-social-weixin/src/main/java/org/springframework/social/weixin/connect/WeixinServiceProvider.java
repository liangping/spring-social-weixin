/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.weixin.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.weixin.api.Weixin;
import org.springframework.social.weixin.api.impl.WeixinTemplate;

/**
 * Weixin ServiceProvider implementation.
 * @author liangping
 */
public class WeixinServiceProvider<T> extends AbstractOAuth2ServiceProvider<Weixin> {
	
	public WeixinServiceProvider(OAuth2Operations oauth2Operations) {
		super(oauth2Operations);
	}
	
	public WeixinServiceProvider(String appid, String appsecret){
		super(getOAuth2Template(appid, appsecret));
	}

	private static OAuth2Template getOAuth2Template(String appid, String appsecret) {
		OAuth2Template oAuth2Template = new OAuth2Template(appid, appsecret,
			"https://open.weixin.qq.com/connect/qrconnect",
			"https://api.weixin.qq.com/sns/oauth2/access_token");
		oAuth2Template.setUseParametersForClientAuthentication(true);
		return oAuth2Template;
	}

	@Override
	public Weixin getApi(String accesstoken) {
		return new WeixinTemplate(accesstoken);
	}


}