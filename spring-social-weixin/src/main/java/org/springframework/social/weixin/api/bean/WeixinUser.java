package org.springframework.social.weixin.api.bean;

import java.io.Serializable;

import org.springframework.social.weixin.api.WeixinObject;

public class WeixinUser extends WeixinObject implements Serializable{

	private static final long serialVersionUID = -7661155872297793909L;

	private String id;
	
	private String unionid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
}
