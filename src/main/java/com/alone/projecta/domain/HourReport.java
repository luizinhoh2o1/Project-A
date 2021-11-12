package com.alone.projecta.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class HourReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date reportTime;
	private Integer numberOfPlayersWhoEntered;

	public HourReport() {
	}
	
	public HourReport(Date reportTime, Integer numberOfPlayersWhoEntered) {
		this.reportTime = reportTime;
		this.numberOfPlayersWhoEntered = numberOfPlayersWhoEntered;
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
		HourReport other = (HourReport) obj;
		return Objects.equals(id, other.id);
	}
}
