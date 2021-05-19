package com.joshryther.project_one;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ContactTest {

	@Test
	@DisplayName("Contact Creation")
	void testContact() {
		Contact contact = new Contact("12", "Josh", "Ryther", "8888888888", "3232 Road Ln");
		assertTrue(contact.getiD().equals("12"));
		assertTrue(contact.getFirstName().equals("Josh"));
		assertTrue(contact.getLastName().equals("Ryther"));
		assertTrue(contact.getPhone().equals("8888888888"));
		assertTrue(contact.getAddress().equals("3232 Road Ln"));
	}
	
	//Test ID
	@Test
	@DisplayName("ID: Too long")
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "Josh", "Ryther", "8888888888", "3232 Road Ln");
		});
	}
	
	@Test
	@DisplayName("ID: Null")
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Josh", "Ryther", "8888888888", "3232 Road Ln");
		});
	}
	
	@Test
	@DisplayName("ID: Non-Numeric")
	void testContactIDNonNumeric() {
		Contact contact = new Contact("1", "Josh", "Ryther", "8888888888", "3232 Road Ln");
		Assertions.assertThrows(NumberFormatException.class, () -> {
			contact.setiD("a");
			
		});
		Assertions.assertThrows(NumberFormatException.class, () -> {
			new Contact("a", "Josh", "Ryther", "8888888888", "3232 Road Ln");;
		});
	}
	
	//Test First Name
	@Test
	@DisplayName("First Name: Too Long")
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12", "Joshjkjkjkj", "Ryther", "8888888888", "3232 Road Ln");
		});
	}
	
	@Test
	@DisplayName("First Name: Too Short")
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12", null, "Ryther", "8888888888", "3232 Road Ln");
		});
	}
	
	//Test Last Name
	@Test
	@DisplayName("Last Name: Too Long")
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12", "Josh", "Rytherjkjkj", "8888888888", "3232 Road Ln");
		});
	}
	
	@Test
	@DisplayName("Last Name: Null")
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12", "Josh", null, "8888888888", "3232 Road Ln");
		});
	}
	
	//Test Phone Number
	@Test
	@DisplayName("Phone: Too Long")
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12", "Josh", "Ryther", "88888888888", "3232 Road Ln");
		});
	}

	@Test
	@DisplayName("Phone: Too Short")
	void testContactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12", "Josh", "Ryther", "888888888", "3232 Road Ln");
		});
	}
	
	@Test
	@DisplayName("Phone: Null")
	void testContactPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12", "Josh", "Ryther", null, "3232 Road Ln");
		});
	}
	
	//Test Address
	@Test
	@DisplayName("Address: Too Long")
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12", "Josh", "Ryther", "8888888888", "3232 Road Lnjkjkjkjkjkjkjkjkjkj");
		});
	}
	
	@Test
	@DisplayName("Address: Null")
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12", "Josh", "Ryther", "8888888888", null);
		});
	}
}
