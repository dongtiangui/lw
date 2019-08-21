package com.lw.model;

import java.io.Serializable;
import java.util.List;

public class AdminRole implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3343831708091944210L;

	/**
	 * 
	 */
	

	private int id;
	
	private Long roleId;
	
	private String roleName;
	
	private String roleDescription;
	
	private Integer roleStatus;
	
	private String createTime;
	
	private String updateTime;
	

	private List<AdminPermissionModel> permissions;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Integer getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}


	public List<AdminPermissionModel> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<AdminPermissionModel> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "AdminRole [id=" + id + ", roleId=" + roleId + ", roleName=" + roleName + ", roleDescription="
				+ roleDescription + ", roleStatus=" + roleStatus + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", permissions=" + permissions + "]";
	}
	
	
	

}
