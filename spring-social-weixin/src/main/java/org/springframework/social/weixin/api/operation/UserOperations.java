package org.springframework.social.weixin.api.operation;

import org.springframework.social.weixin.api.bean.WeixinUser;

public interface UserOperations {
	
	public String getId();
	public String getUnionid();
	WeixinUser getWeixinUser();
}
