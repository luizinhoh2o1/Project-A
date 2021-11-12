package com.alone.projecta.dto;

import java.io.Serializable;
import java.util.Date;

import com.alone.projecta.domain.HourReport;

public class HourReportDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date reportTime;
	private Integer numberOfPlayersWhoEntered;
	
	public HourReportDTO() {
	}
	
	public HourReportDTO(HourReport obj) {
		reportTime = obj.getReportTime();
		numberOfPlayersWhoEntered = obj.getNumberOfPlayersWhoEntered();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public Integer getNumberOfPlayersWhoEntered() {
		return numberOfPlayersWhoEntered;
	}
	public void setNumberOfPlayersWhoEntered(Integer numberOfPlayersWhoEntered) {
		this.numberOfPlayersWhoEntered = numberOfPlayersWhoEntered;
	}
}
