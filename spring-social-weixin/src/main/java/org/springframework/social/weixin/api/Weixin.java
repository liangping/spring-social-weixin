package org.springframework.social.weixin.api;

import org.springframework.social.ApiBinding;
import org.springframework.social.weixin.api.bean.User;
import org.springframework.social.weixin.api.operation.UserOperations;
import org.springframework.web.client.RestOperations;

public interface Weixin extends ApiBinding {
	/**
	 * Returns the underlying {@link RestOperations} object allowing for consumption of Twitter endpoints that may not be otherwise covered by the API binding.
	 * The RestOperations object returned is configured to include an OAuth "Authorization" header on all requests.
	 * @return a RestOperations object instrumented for including an OAuth Authorization header on requests.
	 */
	RestOperations restOperations();
	
	UserOperations userOperations();
	
	User getWeixinUser(String openid);
}
