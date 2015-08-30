package org.springframework.social.weixin.api.operation;

import org.springframework.social.weixin.api.bean.User;

public interface UserOperations {

	public User getWeixinUser(String openid);
	
}
