package com.shopme.common.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer roleId;
	
	@Column(length=40,nullable=false,unique=true)
	private String name;
	
	@Column(length=150,nullable=false)
	private String description;
	
	public Role() {
		
	}
	public Role(Integer id) {
		this.roleId=id;
	}
	
	public Role(String name) {
		this.name=name;
	}
	
	public Role(String name,String descrption) {
		this.name=name;
		this.description=descrption;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(roleId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(roleId, other.roleId);
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", description=" + description + "]";
	}

	
	
}
