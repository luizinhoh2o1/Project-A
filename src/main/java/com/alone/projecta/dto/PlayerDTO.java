package com.alone.projecta.dto;

import java.io.Serializable;
import java.util.Date;

public class PlayerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private Date expiration;
	
	public PlayerDTO() {}
	
	public PlayerDTO(String nickname, Date expiration) {
		this.nickname = nickname;
		this.expiration = expiration;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
}
