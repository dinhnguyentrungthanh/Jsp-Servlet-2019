package com.poly.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserTbl")
public class User {
	@Id
	private String username;//username
	private String password;
	private String fullname;
	private boolean role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	private String email;
	private String phone;
	private String hinh;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String fullname, boolean role, String email, String phone,
			String hinh) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
		this.email = email;
		this.phone = phone;
		this.hinh = hinh;
	}

}
