package org.springframework.social.weixin.connect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.FormMapHttpMessageConverter;
import org.springframework.social.weixin.api.bean.WeixinAccessGrant;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class WeixinOAuth2Template extends OAuth2Template {
	
	Logger logger = LoggerFactory.getLogger(WeixinOAuth2Template.class);
	
	private String appid;
	private String appsecret;

	public WeixinOAuth2Template(String appid, String clientSecret,
			String authorizeUrl, String accessTokenUrl) {
		super(appid, clientSecret, authorizeUrl, accessTokenUrl );
		this.appid = appid;
		this.appsecret=clientSecret;
		
		logger.debug(String.format("appid:%s appsecret:%s, authorizeUrl:%s, accessTokenUrl:%s ",appid, clientSecret, authorizeUrl, accessTokenUrl ));
		
	}

	@Override
	protected WeixinAccessGrant createAccessGrant(String accessToken, String scope,
			String refreshToken, Long expiresIn, Map<String, Object> response) {
		
		logger.debug( response.toString() );
		
		if(response.containsKey("errcode")){
			logger.error(response.toString());
		}
		WeixinAccessGrant g = new WeixinAccessGrant(accessToken, scope, refreshToken, expiresIn, 
				String.valueOf(response.get("openid")), 
				String.valueOf(response.get("unionid")));
		logger.debug( g.toString() );
		return g;
	}

	@Override
	public AccessGrant exchangeCredentialsForAccess(String username,
			String password, MultiValueMap<String, String> additionalParameters) {

		logger.debug( String.format(" username is [%s] ", username ) );
		
		return super.exchangeCredentialsForAccess(username, password,
				additionalParameters);
	}

	@Override
	public AccessGrant exchangeForAccess(String authorizationCode,
			String redirectUri,
			MultiValueMap<String, String> additionalParameters) {		
		logger.debug( String.format(" authrizationcode is [%s],%s %s", authorizationCode, additionalParameters ,redirectUri) );
		return super.exchangeForAccess(authorizationCode, redirectUri,
				additionalParameters);
	}
	
	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate =super.createRestTemplate();
		
		List<MediaType> types= new ArrayList<MediaType>();
		types.add(MediaType.TEXT_PLAIN );
		
		MappingJackson2HttpMessageConverter convert = new MappingJackson2HttpMessageConverter();
		convert.setSupportedMediaTypes( types );
		

		restTemplate.getMessageConverters().add( convert );

		return restTemplate;
	}

	@Override
	protected AccessGrant postForAccessGrant(String accessTokenUrl,
			MultiValueMap<String, String> parameters) {
		this.setUseParametersForClientAuthentication(true);
		parameters.add("appid", appid);
		parameters.add("secret", this.appsecret );
		logger.debug( parameters.toString() );
		return super.postForAccessGrant(accessTokenUrl, parameters);
	}
	
/*
	@Override
	public String buildAuthorizeUrl(OAuth2Parameters parameters) {

		parameters.add("appid", this.appid);
		parameters.setScope("snsapi_login");
		parameters.setRedirectUri("http://www.wei3dian.com");

		logger.debug(super.buildAuthorizeUrl(parameters));
		
		return super.buildAuthorizeUrl(parameters);
	}
//*/
}
