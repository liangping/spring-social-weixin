package org.springframework.social.weixin.api.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.social.weixin.api.WeixinObject;

/**
 * The persistent class for the weixin_users database table. *
 */
public class User extends WeixinObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String country;
	private String province;
	private String city;

	private int sex = 0;
	private String language;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	private Date createtime;

	private int credits;

	/**
	 * 如果是微信认证用户，此ID为OpenID, 其它情况这里是fakeID;
	 */
	private String fakeid;

	private int group;

	private String ip;

	private String logo;

	private int msgs;

	private String nickname;
	private String password;

	/**
	 * 
	 */
	private int role;

	private String sid;

	private byte status;

	private int totalcredits;

	private int visits;
	
	private int fromscene;
	private String fromuser;
	private Date signindate;
	private int cash = 0;
	
	private String unionid;

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getCredits() {
		return this.credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getFakeid() {
		return this.fakeid;
	}

	public void setFakeid(String fakeid) {
		this.fakeid = fakeid;
	}

	public int getGroup() {
		return this.group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getMsgs() {
		return this.msgs;
	}

	public void setMsgs(int msgs) {
		this.msgs = msgs;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public int getTotalcredits() {
		return this.totalcredits;
	}

	public void setTotalcredits(int totalcredits) {
		this.totalcredits = totalcredits;
	}

	public int getVisits() {
		return this.visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFromscene() {
		return fromscene;
	}

	public void setFromscene(int fromscene) {
		this.fromscene = fromscene;
	}

	public Date getSignindate() {
		return signindate;
	}

	public void setSignindate(Date signindate) {
		this.signindate = signindate;
	}

	public String getFromuser() {
		return fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}

}