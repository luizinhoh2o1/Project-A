package com.alone.projecta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DailyReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date reportDate;
	private List<HourReport> hoursReportList = new ArrayList<>();

	public DailyReport() {
	}

	public DailyReport(List<HourReport> hoursReportList, Date reportDate) {
		this.hoursReportList = hoursReportList;
		this.reportDate = reportDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public List<HourReport> getHoursReportList() {
		return hoursReportList;
	}

	public void setHoursReportList(List<HourReport> hoursReportList) {
		this.hoursReportList = hoursReportList;
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
		DailyReport other = (DailyReport) obj;
		return Objects.equals(id, other.id);
	}
}
