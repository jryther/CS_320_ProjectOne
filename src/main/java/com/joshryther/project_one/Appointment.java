package com.joshryther.project_one;

import java.util.Date;

public class Appointment {
	private String iD;
	private Date date;
	private String description;
	
	Appointment(String iD, Date date, String description){
		//Data validation: Throws NumberFormatException if ID is not a number
		Integer.parseInt(iD);
		
		if (iD == null || iD.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid date");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.iD = iD;
		this.date = date;
		this.description = description;
	}
	
	public String getiD() {
		return iD;
	}

	public Date getDate() {
		return date;
	}

	public void setName(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
