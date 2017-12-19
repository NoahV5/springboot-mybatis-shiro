package com.victor.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Collections;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * user 用户表
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
@Entity
@Table(name="user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
    /**
     * 用户名
     */
	private String username;
    /**
     * 昵称
     */
	private String nickname;
    /**
     * 密码
     */
	private String password;
    /**
     * 盐
     */
	private String salt;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 0、禁用 1、正常
     */
	private Integer status;
    /**
     * 创建时间
     */
	@TableField("gmt_create")
	private Date gmtCreate;
    /**
     * 修改时间
     */
	@TableField("gmt_modified")
	private Date gmtModified;

//	/**
//	 * 一个用户拥有的角色集合
//	 */
//	//@Transient
//	@ManyToMany(fetch = FetchType.EAGER)//立即从数据库进行数据加载
//	@JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = {@JoinColumn(name = "rid")})
//	private Set<Role> roleSet;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
//
//	public Set<Role> getRoleSet() {
//		return roleSet == null ? Collections.EMPTY_SET:roleSet;
//	}
//
//	public void setRoleSet(Set<Role> roleList) {
//		this.roleSet = roleList;
//	}

	public String getGredentialsSat(){
		return this.username+this.salt;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", username=" + username +
			", nickname=" + nickname +
			", password=" + password +
			", salt=" + salt +
			", email=" + email +
			", status=" + status +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			"}";
	}
}
