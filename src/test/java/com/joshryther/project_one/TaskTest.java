package com.joshryther.project_one;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TaskTest {

	@Test
	@DisplayName("Task Creation")
	void testTask() {
		Task task = new Task("12", "Email", "Check email inbox");
		assertTrue(task.getiD().equals("12"));
		assertTrue(task.getName().equals("Email"));
		assertTrue(task.getDescription().equals("Check email inbox"));
	}
	
	//Test ID
	@Test
	@DisplayName("ID: Too long")
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678910", "Email", "Check email inbox");
		});
	}
	
	@Test
	@DisplayName("ID: Null")
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Email", "Check email inbox");
		});
	}
	
	@Test
	@DisplayName("ID: Non-Numeric")
	void testContactIDNonNumeric() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			new Task("a", "Email", "Check email inbox");;
		});
	}
	
	//Test Name
	@Test
	@DisplayName("Name: Too Long")
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12", "Emailjkjkjkjkjkjkjkjk", "Check email inbox");
		});
	}
	
	@Test
	@DisplayName("Name: Null")
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12", null, "Check email inbox");
		});
	}
	
	//Test Last Name
	@Test
	@DisplayName("Description: Too Long")
	void testContactDescriptionTooLong() {
		String string = "testingtestingtestingtestingtestingtestingtestingtesting";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12", "Email", string);
		});
	}
	
	@Test
	@DisplayName("Description: Null")
	void testContactDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12", "Email", null);
		});
	}
}