package com.joshryther.project_one;

public class Task {
	private String iD;
	private String name;
	private String description;
	
	Task(String iD, String name, String description){
		//Data validation: Throws NumberFormatException if ID is not a number
		Integer.parseInt(iD);
		
		if (iD == null || iD.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.iD = iD;
		this.name = name;
		this.description = description;
	}

	public String getiD() {
		return iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
