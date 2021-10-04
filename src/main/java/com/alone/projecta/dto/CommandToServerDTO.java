package com.alone.projecta.dto;

import java.io.Serializable;

public class CommandToServerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String command;
	
	public CommandToServerDTO() {}

	public CommandToServerDTO(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
}
