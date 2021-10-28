package com.alone.projecta.dto;

import java.io.Serializable;

import com.alone.projecta.domain.Account;

public class AccountDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String username;
	private String email;
	private String password;
	private boolean admin;
	private boolean active;

	public AccountDTO() {
	}

	public AccountDTO(Account obj) {
		id = obj.getId();
		name = obj.getName();
		username = obj.getUsername();
		email = obj.getEmail();
		password = obj.getPassword();
		admin = obj.isAdmin();
		active = obj.isActive();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public boolean isAdmin() {
		return admin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
