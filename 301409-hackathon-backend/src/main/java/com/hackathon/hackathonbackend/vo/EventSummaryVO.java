package com.hackathon.hackathonbackend.vo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="eventSummary")
public class EventSummaryVO {

	@Id
	private String eventID;
	private String month;
	private String baseLocation;
	private String beneficiaryName;
	private String venueAddress;
	private String councilName;
	private String project;
	private String category;
	private String eventName;
	private String eventDescription;
	private String eventDate;
	private int totalNoOfVolunteers;
	private int totalVolunteerHours;
	private int totalTravelHours;
	private int overallVolunteeringHours;
	private int livesImpacted;
	private int activityType;
	private String status;
	private int pOCID;
	private String pOCName;
	private int pOCContactNumber;

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getVenueAddress() {
		return venueAddress;
	}

	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}

	public String getCouncilName() {
		return councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getTotalNoOfVolunteers() {
		return totalNoOfVolunteers;
	}

	public void setTotalNoOfVolunteers(int totalNoOfVolunteers) {
		this.totalNoOfVolunteers = totalNoOfVolunteers;
	}

	public int getTotalVolunteerHours() {
		return totalVolunteerHours;
	}

	public void setTotalVolunteerHours(int totalVolunteerHours) {
		this.totalVolunteerHours = totalVolunteerHours;
	}

	public int getTotalTravelHours() {
		return totalTravelHours;
	}

	public void setTotalTravelHours(int totalTravelHours) {
		this.totalTravelHours = totalTravelHours;
	}

	public int getOverallVolunteeringHours() {
		return overallVolunteeringHours;
	}

	public void setOverallVolunteeringHours(int overallVolunteeringHours) {
		this.overallVolunteeringHours = overallVolunteeringHours;
	}

	public int getLivesImpacted() {
		return livesImpacted;
	}

	public void setLivesImpacted(int livesImpacted) {
		this.livesImpacted = livesImpacted;
	}

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getpOCID() {
		return pOCID;
	}

	public void setpOCID(int pOCID) {
		this.pOCID = pOCID;
	}

	public String getpOCName() {
		return pOCName;
	}

	public void setpOCName(String pOCName) {
		this.pOCName = pOCName;
	}

	public int getpOCContactNumber() {
		return pOCContactNumber;
	}

	public void setpOCContactNumber(int pOCContactNumber) {
		this.pOCContactNumber = pOCContactNumber;
	}

}
