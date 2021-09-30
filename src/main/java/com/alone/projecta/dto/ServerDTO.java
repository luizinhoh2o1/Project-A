package com.alone.projecta.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alone.projecta.domain.Server;

public class ServerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String hosting;
	private String ip;
	private Integer playersOnline;
	private boolean active;
	private String tokenPost;
	private List<PlayerDTO> players = new ArrayList<>();
	
	public ServerDTO() {}
	
	public ServerDTO(Server obj) {
		id = obj.getId();
		name = obj.getName();
		hosting = obj.getHosting();
		ip = obj.getIp();
		playersOnline = obj.getPlayersOnline();
		active = obj.isActive();
		players = obj.getPlayers();
		tokenPost = obj.getTokenPost();
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

	public String getTokenPost() {
		return tokenPost;
	}

	public void setTokenPost(String tokenPost) {
		this.tokenPost = tokenPost;
	}

	public List<PlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDTO> players) {
		this.players = players;
	}
}
