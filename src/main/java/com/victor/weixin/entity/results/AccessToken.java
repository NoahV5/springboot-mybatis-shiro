package com.victor.weixin.entity.results;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Victor
 * @since 2017-12-28
 */
@Entity
@Table(name = "access_token")
public class AccessToken extends Model<AccessToken> {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

	/**
	 * 获取到的凭证
	 */
	@TableField("access_token")
	private String accessToken;
	/**
	 * 凭证有效时间，单位：秒
	 */
	@TableField("expires_in")
	private String expiresIn;
	/**
	 * 用户刷新access_token
	 */
	@TableField("refresh_token")
	private String refreshToken;
	private String openid;
	/**
	 * 用户授权的作用域，使用逗号（,）分隔
	 */
	private String scope;
	/**
	 * 网页返回 unionid
	 */
	private String unionid;
	@TableField("gmt_modified")
	private Date gmtModified;
	@TableField("gmt_create")
	private Date gmtCreate;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "AccessToken{" +
				"id=" + id +
				", accessToken=" + accessToken +
				", expiresIn=" + expiresIn +
				", refreshToken=" + refreshToken +
				", openid=" + openid +
				", scope=" + scope +
				", unionid=" + unionid +
				", gmtModified=" + gmtModified +
				", gmtCreate=" + gmtCreate +
				"}";
	}
}
