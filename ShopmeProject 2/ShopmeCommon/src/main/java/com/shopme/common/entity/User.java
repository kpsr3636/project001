package com.shopme.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table()
public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer userId;
	
	@Column(length=128,nullable=false,unique=true)
	private String email;
	
	@Column(length=64,nullable=false,unique=true)
	private String password;
	
	@Column(name="first_name",length=45,nullable=false)
	private String firstName;
	
	@Column(name="last_name",length=45,nullable=false)
	private String lastName;
	
	@Column()
	private String photos;
	
	@Column()
	private boolean enanled;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="users_roles",
	        joinColumns = @JoinColumn(name="user_id"),
	        inverseJoinColumns=@JoinColumn(name="role_id")
			)
	private Set<Role> roles= new HashSet<>();
	
	
	public User() {
		
	}


	public User(String email, String password, String firstName, String lastName) {
		
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

    public void addRole(Role rol) {
    	this.roles.add(rol);
    }
	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhotos() {
		return photos;
	}


	public void setPhotos(String photos) {
		this.photos = photos;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", photos=" + photos + ", enanled=" + enanled + ", roles=" + roles + "]";
	}


	public boolean isEnanled() {
		return enanled;
	}


	public void setEnanled(boolean enanled) {
		this.enanled = enanled;
	}
	
	
	
	
	
	
	
	
	
	
	
}
