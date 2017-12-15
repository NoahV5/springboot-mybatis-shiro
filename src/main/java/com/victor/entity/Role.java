package com.victor.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Collections;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * <p>
 * 
 * </p>
 *
 * @author Victor
 * @since 2017-12-15
 */
@Entity
@Table(name="role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的:
     */
	private String role;
    /**
     * 角色描述
     */
	private String description;
	/**
	 * 是否可用,如果不可用将不会添加给用户
	 */
	private Boolean available = Boolean.FALSE;
	/**
	 * 一个角色拥有多个权限
	 */
	@ManyToMany
	@JoinTable(name = "role_permission",joinColumns = {@JoinColumn(name = "pid")},inverseJoinColumns = {@JoinColumn(name = "rid")})
	private Set<Permission> permissionSet;

	/**
	 * 一个角色被多个用户拥有
	 */
	@ManyToMany
	@JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "pid")},inverseJoinColumns = {@JoinColumn(name = "uid")})
	private Set<Role> roleSet;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
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

	@Override public String toString() {
		return "Role{" + "id=" + id + ", role='" + role + '\'' + ", description='" + description + '\'' + ", available="
				+ available + '}';
	}
}
