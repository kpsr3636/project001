package com.shopme.common.entity;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roleId;
	
	@Column(length=128,nullable=false,unique=true)
    private String name;
	
	@Column(length=150,nullable=false)
	private String description;
	
	
	public Role() {
		
	}
	
	public Role(String name) {
		this.name=name;
	}
	
	public Role(String name,String description) {
		this.name=name;
		this.description=description;
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

	
}
