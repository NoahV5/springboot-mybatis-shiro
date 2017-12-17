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
 * role 角色表
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
@Entity//声明一个实体，用的是Java规范下的注解
@Table(name="role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
    /**
     * 角色名
     */
	private String name;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * 描述
     */
	private String description;

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

	/**
	 * 一个角色拥有多个权限
	 */
	//@Transient
	@ManyToMany
	@JoinTable(name = "role_permission",joinColumns = {@JoinColumn(name = "pid")},inverseJoinColumns = {@JoinColumn(name = "rid")})
	private Set<Permission> permissionSet;

	/**
	 * 一个角色被多个用户拥有
	 */
//	@Transient
	@ManyToMany
	@JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "pid")},inverseJoinColumns = {@JoinColumn(name = "uid")})
	private Set<Role> roleSet;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Set<Permission> getPermissionSet() {
		return permissionSet == null ? Collections.EMPTY_SET : permissionSet;
	}

	public void setPermissionSet(Set<Permission> permissionList) {
		this.permissionSet = permissionList;
	}

	public Set<Role> getRoleSet() {
		return roleSet  == null ? Collections.EMPTY_SET : roleSet;
	}

	public void setRoleSet(Set<Role> roleList) {
		this.roleSet = roleList;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Role{" +
			"id=" + id +
			", name=" + name +
			", sort=" + sort +
			", description=" + description +
			", status=" + status +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			"}";
	}
}
