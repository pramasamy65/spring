package com.hackathon.hackathonbackend.genericmetric;

public class GenericMetricOutputVo {

	private int employeeId;
	private String employeeName;
	private String totalVolunteerHours;

	private String livesImpacted;

	private String totalTravelHours;

	private String eventDate;

	private String volunteerFrequency;

	private String baseLocation;

	private String businessUnit;

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getVolunteerFrequency() {
		return volunteerFrequency;
	}

	public void setVolunteerFrequency(String volunteerFrequency) {
		this.volunteerFrequency = volunteerFrequency;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTotalVolunteerHours() {
		return totalVolunteerHours;
	}

	public void setTotalVolunteerHours(String totalVolunteerHours) {
		this.totalVolunteerHours = totalVolunteerHours;
	}

	public String getLivesImpacted() {
		return livesImpacted;
	}

	public void setLivesImpacted(String livesImpacted) {
		this.livesImpacted = livesImpacted;
	}

	public String getTotalTravelHours() {
		return totalTravelHours;
	}

	public void setTotalTravelHours(String totalTravelHours) {
		this.totalTravelHours = totalTravelHours;
	}

	@Override
	public String toString() {
		return "GenericMetricOutputVo [employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", totalVolunteerHours=" + totalVolunteerHours + ", livesImpacted=" + livesImpacted
				+ ", totalTravelHours=" + totalTravelHours + ", eventDate=" + eventDate + ", volunteerFrequency="
				+ volunteerFrequency + ", baseLocation=" + baseLocation + ", businessUnit=" + businessUnit + "]";
	}

}
