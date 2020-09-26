package com.myclass.fashionshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email
	private String email;
	@NotBlank(message = "Username can't be whitespace character!")
	private String fullname;
	private String password;
	private String avatar;
	private String phone;

	@Column(name = "role_id")
	private Long roleId;

	@ManyToOne
	@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_user_role"), insertable = false, updatable = false)
	@JsonIgnore
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, String fullname, String password, String phone, Long roleId) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.phone = phone;
		this.roleId = roleId;
	}
}
