package com.hackathon.hackathonbackend.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "associateDetails")
public class AssociateDetailsVO {

	@Id
	private int associateId;
	private String name;
	private String designation;
	private String location;
	private String buinessUnit;

	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBuinessUnit() {
		return buinessUnit;
	}

	public void setBuinessUnit(String buinessUnit) {
		this.buinessUnit = buinessUnit;
	}

	@Override
	public String toString() {
		return "AssociateDetailsVo [associateId=" + associateId + ", name=" + name + ", designation=" + designation
				+ ", location=" + location + ", buinessUnit=" + buinessUnit + "]";
	}

}
