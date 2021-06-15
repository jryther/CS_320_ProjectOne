package com.joshryther.project_one;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentTest {
	Date date;
	String description;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setup() {
		date = new Date(121, 5, 30);
		description = "Lunch with Tony";
	}

	@Test
	@DisplayName("Appointment Creation")
	void testAppointment() {
		Appointment appointment = new Appointment("12", date, description);
		assertTrue(appointment.getiD().equals("12"));
		assertTrue(appointment.getDate().equals(date));
		assertTrue(appointment.getDescription().equals(description));
	}
	
	//Test ID
	@Test
	@DisplayName("ID: Too long")
	void testAppointmentIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678910", date, description);
		});
	}
	
	@Test
	@DisplayName("ID: Null")
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, date, description);
		});
	}
	
	@Test
	@DisplayName("ID: Non-Numeric")
	void testContactIDNonNumeric() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			new Appointment("a", date, description);;
		});
	}
	
	//Test Date
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Date: Scheduled in past")
	void testAppointmentDateTooLong() {
		date = new Date(99, 3, 12);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12", date, description);
		});
	}
	
	@Test
	@DisplayName("Date: Null")
	void testAppointmentDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12", null, description);
		});
	}
	
	//Test Last Date
	@Test
	@DisplayName("Description: Too Long")
	void testContactDescriptionTooLong() {
		String string = "testingtestingtestingtestingtestingtestingtestingtesting";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12", date, string);
		});
	}
	
	@Test
	@DisplayName("Description: Null")
	void testContactDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12", date, null);
		});
	}
}
