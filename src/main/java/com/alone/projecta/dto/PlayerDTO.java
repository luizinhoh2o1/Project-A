package com.alone.projecta.dto;

import java.io.Serializable;
import java.util.Date;

import com.alone.projecta.domain.Player;

public class PlayerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nickname;
	private Boolean playerOn;
	private Date expiration;
	
	public PlayerDTO() {}
	
	public PlayerDTO(Player obj) {
		id = obj.getId();
		nickname = obj.getNickname();
		playerOn = obj.getPlayerOn();
		expiration = obj.getExpiration();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
