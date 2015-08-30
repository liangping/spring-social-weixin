package org.springframework.social.weixin.api.bean;

import org.springframework.social.oauth2.AccessGrant;

public class WeixinAccessGrant extends AccessGrant {

	private static final long serialVersionUID = 5104132146580119202L;
	private String openid;
	private String unionid;
	
	public WeixinAccessGrant(String accessToken, String scope,
			String refreshToken, Long expiresIn, String openid, String unionid) {
		super(accessToken, scope, refreshToken, expiresIn);
		this.openid  = openid;
		this.unionid = unionid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("accesstoken:").append(this.getAccessToken())
		.append(" scope:").append(this.getScope())
		.append(" refreshtoken:").append(this.getRefreshToken())
		.append(" expire:").append(this.getExpireTime())
		.append(" openid:").append(this.openid)
		.append(" unionid:").append(this.unionid);
		return sb.toString();
	}

}
