package com.alone.projecta.dto;

import java.io.Serializable;
import java.util.Date;

public class PlayerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private Boolean playerOn;
	private Date expiration;
	
	public PlayerDTO() {}
	
	public PlayerDTO(String nickname, Boolean playerOn, Date expiration) {
		this.nickname = nickname;
		this.playerOn = playerOn;
		this.expiration = expiration;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Boolean getPlayerOn() {
		return playerOn;
	}

	public void setPlayerOn(Boolean playerOn) {
		this.playerOn = playerOn;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
}
