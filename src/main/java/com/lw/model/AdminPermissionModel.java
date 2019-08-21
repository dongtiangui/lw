package com.lw.model;

import java.io.Serializable;
import java.util.List;

public class AdminPermissionModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7684404489595256728L;
	
	private int id;
	private Long permissionId;
	// 权限名
	private String permissionName;
	//权限描述
	private String permissionDescription;
	// 权限访问URL
	private String permissionUrl;
	// 权限标示
	private String permissionPerms;
	// 父级权限标示
	private String parentId;
	// 权限类型
	private String permissionType;
	// 排序
	private Integer order_num;
	// 权限 icon
	private String permissionIcon;
	// 权限状态
	private Integer permissionStatus;
	// 权限创建时间
	private String create_time;
	// 权限修改时间
	private String update_time;
	
	private List<AdminRole> roles;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getPermissionDescription() {
		return permissionDescription;
	}
	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}
	public String getPermissionUrl() {
		return permissionUrl;
	}
	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}
	public String getPermissionPerms() {
		return permissionPerms;
	}
	public void setPermissionPerms(String permissionPerms) {
		this.permissionPerms = permissionPerms;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getPermissionType() {
		return permissionType;
	}
	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}
	public Integer getOrder_num() {
		return order_num;
	}
	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}
	public String getPermissionIcon() {
		return permissionIcon;
	}
	public void setPermissionIcon(String permissionIcon) {
		this.permissionIcon = permissionIcon;
	}
	public Integer getPermissionStatus() {
		return permissionStatus;
	}
	public void setPermissionStatus(Integer permissionStatus) {
		this.permissionStatus = permissionStatus;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public List<AdminRole> getRoles() {
		return roles;
	}
	public void setRoles(List<AdminRole> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "AdminPermissionModel [id=" + id + ", permissionId=" + permissionId + ", permissionName="
				+ permissionName + ", permissionDescription=" + permissionDescription + ", permissionUrl="
				+ permissionUrl + ", permissionPerms=" + permissionPerms + ", parentId=" + parentId
				+ ", permissionType=" + permissionType + ", order_num=" + order_num + ", permissionIcon="
				+ permissionIcon + ", permissionStatus=" + permissionStatus + ", create_time=" + create_time
				+ ", update_time=" + update_time + ", roles=" + roles + "]";
	}
	
	
	
}
