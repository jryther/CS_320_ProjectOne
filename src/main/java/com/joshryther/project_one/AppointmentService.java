package com.joshryther.project_one;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
private ArrayList<Appointment> appointmentList;
	
	public AppointmentService(){
		this.appointmentList = new ArrayList<Appointment>();
	}
	
	public ArrayList<Appointment> getAppointmentList(){
		return appointmentList;
	}
	
	public void addAppointment(Date date, String description) {
		int iD;
		
		if(appointmentList.isEmpty()) {
			iD = 1;
			Appointment appointment = new Appointment(Integer.toString(iD), date, description);
			appointmentList.add(appointment);
		}
		else {
			//Get the last ID number in the sorted array list, convert to int,
			//increment by 1, and convert back to string
			iD = Integer.parseInt(appointmentList.get(appointmentList.size()-1).getiD()) + 1;
			Appointment appointment = new Appointment(Integer.toString(iD), date, description);
			appointmentList.add(appointment);
		}
	}
	
	public void deleteAppointment(String iD) {	
		for(int i = 0; i < appointmentList.size(); i++) {
			if(appointmentList.get(i).getiD().equals(iD)) {
				appointmentList.remove(i);
				appointmentList.trimToSize();
				return;
			}
		}
	}
}
