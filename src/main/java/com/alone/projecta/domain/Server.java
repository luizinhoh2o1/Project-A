package com.alone.projecta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Server implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String hosting;
	private String ip;
	private Integer playersOnline;
	private boolean active;
	private String tokenPost;
	
	private List<Player> players = new ArrayList<>();

	public Server() {}
	
	public Server(String id, String name, String hosting, String ip, String tokenPost) {
		super();
		this.id = id;
		this.name = name;
		this.hosting = hosting;
		this.ip = ip;
		this.tokenPost = tokenPost;
		
		playersOnline = 0;
		active = false;
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

	public Integer getPlayersOnline() {
		return playersOnline;
	}

	public void setPlayersOnline(Integer playersOnline) {
		this.playersOnline = playersOnline;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public String getTokenPost() {
		return tokenPost;
	}

	public void setTokenPost(String tokenPost) {
		this.tokenPost = tokenPost;
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
		Server other = (Server) obj;
		return Objects.equals(id, other.id);
	}
}
