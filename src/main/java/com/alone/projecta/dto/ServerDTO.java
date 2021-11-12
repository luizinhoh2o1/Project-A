package com.alone.projecta.dto;

import java.io.Serializable;

import com.alone.projecta.domain.Server;

public class ServerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String hosting;
	private String ip;
	private String token;
	
	public ServerDTO() {}
	
	public ServerDTO(Server obj) {
		id = obj.getId();
		name = obj.getName();
		hosting = obj.getHosting();
		ip = obj.getIp();
		token = obj.getToken();
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

	public String getHosting() {
		return hosting;
	}

	public void setHosting(String hosting) {
		this.hosting = hosting;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
