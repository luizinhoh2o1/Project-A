package com.alone.projecta.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alone.projecta.domain.DailyReport;
import com.alone.projecta.domain.HourReport;

public class DailyReportDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private Date reportDate;
	private List<HourReport> hoursReportList = new ArrayList<>();

	public DailyReportDTO() {
	}

	public DailyReportDTO(DailyReport obj) {
		id = obj.getId();
		reportDate = obj.getReportDate();
		hoursReportList = obj.getHoursReportList();
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
}
