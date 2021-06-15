package com.joshryther.project_one;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentServiceTest {
	private AppointmentService appointmentService;
	private Date date;
	private String description;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		appointmentService = new AppointmentService();
		assertTrue(appointmentService.getAppointmentList().isEmpty());
		date = new Date(121, 5, 30);
		description = "Go to lunch with Tony";
		
	}

	@Test
	@DisplayName("Add Appointment: Empty ArrayList")
	void testAddEmpty() {
		appointmentService.addAppointment(date, description);
		assertTrue(appointmentService.getAppointmentList().get(0).getiD().equals("1"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Add Appointment: Populated ArrayList")
	void testAddNotPopulated() {
		appointmentService.addAppointment(date, description);
		appointmentService.addAppointment(new Date(121, 6, 10), "Pick up Judy from airport");
		assertFalse(appointmentService.getAppointmentList().isEmpty());
		assertTrue(appointmentService.getAppointmentList().get(1).getiD().equals("2"));
	}

	@Test
	@DisplayName("Delete Appointment")
	void testDelete() {
		appointmentService.addAppointment(date, description);
		appointmentService.deleteAppointment("1");
		assertTrue(appointmentService.getAppointmentList().isEmpty());
	}
}
