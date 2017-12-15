package com.victor.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "permission")
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * url地址
     */
	private String url;
	/**
	 * 资源类型，[menu|button]
	 */
	@Column(columnDefinition="enum('menu','button')")
	private String resourceType;
    /**
     * url描述
     */
	private String name;
	/**
	 *权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
	 */
	private String permission;
	/**
	 * 父编号
	 */
	private Long parentId;
	/**
	 * 父编号列表
	 */
	private String parentIds;

	private Boolean available = Boolean.FALSE;

	@ManyToMany
	@JoinTable(name = "role+permission",joinColumns = {@JoinColumn(name = "pid")},inverseJoinColumns = {@JoinColumn(name = "rid")})
	private Set<Role> roleSet;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Set<Role> getRoleSet() {
		return roleSet == null ? Collections.EMPTY_SET :roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	@Override public String toString() {
		return "Permission{" + "id=" + id + ", url='" + url + '\'' + ", resourceType='" + resourceType + '\''
				+ ", name='" + name + '\'' + ", permission='" + permission + '\'' + ", parentId=" + parentId
				+ ", parentIds='" + parentIds + '\'' + ", available=" + available + '}';
	}
}
