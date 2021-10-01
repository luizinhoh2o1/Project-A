package com.alone.projecta.dto;

import java.io.Serializable;

public class CommandToServerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String command;
	private String serverToken;
	
	public CommandToServerDTO() {}

	public CommandToServerDTO(String command, String serverToken) {
		this.command = command;
		this.serverToken = serverToken;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getServerToken() {
		return serverToken;
	}

	public void setServerToken(String serverToken) {
		this.serverToken = serverToken;
	}
}
