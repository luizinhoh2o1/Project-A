package com.alone.projecta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alone.projecta.dto.CommandToServerDTO;

@Document
public class Server implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String hosting;
	private String ip;
	private String token;
	private CommandToServerDTO cmdToServer = new CommandToServerDTO();
	@DBRef
	private List<DailyReport> dailyReportList = new ArrayList<>();

	public Server() {
	}

	public Server(String id, String name, String hosting, String ip, String token) {
		this.id = id;
		this.name = name;
		this.hosting = hosting;
		this.ip = ip;
		this.token = token;

		cmdToServer.setCommand(""); 
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

	public void setTokenPost(String tokenPost) {
		this.token = tokenPost;
	}

	public CommandToServerDTO getCmdToServer() {
		return cmdToServer;
	}

	public void setCmdToServer(CommandToServerDTO cmdToServer) {
		this.cmdToServer = cmdToServer;
	}

	public List<DailyReport> getDailyReportList() {
		return dailyReportList;
	}

	public void setDailyReportList(List<DailyReport> dailyReportList) {
		this.dailyReportList = dailyReportList;
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
