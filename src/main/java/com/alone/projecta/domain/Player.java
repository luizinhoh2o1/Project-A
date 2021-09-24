package com.alone.projecta.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nickname;
	private UUID uuid;
	private Boolean playerOn;
	private Date expiration;
	
	public Player() {}
	
	public Player(String id, String nickname, UUID uuid, Boolean playerOn, Date expiration) {
		this.id = id;
		this.nickname = nickname;
		this.uuid = uuid;
		this.playerOn = playerOn;
		this.expiration = expiration;
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

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(id, other.id);
	}
}
