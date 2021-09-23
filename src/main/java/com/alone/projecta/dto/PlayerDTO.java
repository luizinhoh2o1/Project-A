package com.alone.projecta.dto;

import java.io.Serializable;
import java.util.UUID;

public class PlayerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nickname;
	private UUID uuid;
	private Boolean playerOn;
	
	public PlayerDTO() {}
	
	public PlayerDTO(String id, String nickname, UUID uuid, Boolean playerOn) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.uuid = uuid;
		this.playerOn = playerOn;
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

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Boolean getPlayerOn() {
		return playerOn;
	}

	public void setPlayerOn(Boolean playerOn) {
		this.playerOn = playerOn;
	}
}
