package com.joshryther.project_one;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	private ContactService contactService;
	
	@BeforeEach
	void setUp() {
		contactService = new ContactService();
		assertTrue(contactService.getContactList().isEmpty());
	}

	@Test
	@DisplayName("Add Content: Empty ArrayList")
	void testAddEmpty() {
		contactService.addContact("Josh", "Ryther", "1234567891", "3232 Road Ln");
		assertTrue(contactService.getContactList().get(0).getiD().equals("1"));
	}
	
	@Test
	@DisplayName("Add Content: Populated ArrayList")
	void testAddNotPopulated() {
		contactService.addContact("Josh", "Ryther", "1234567891", "3232 Road Ln");
		contactService.addContact("John", "Doe", "2345678912", "2020 Road Ln");
		assertFalse(contactService.getContactList().isEmpty());
		assertTrue(contactService.getContactList().get(1).getiD().equals("2"));
	}

	@Test
	@DisplayName("Delete Content")
	void testDelete() {
		contactService.addContact("Josh", "Ryther", "1234567891", "3232 Road Ln");
		contactService.deleteContact("1");
		assertTrue(contactService.getContactList().isEmpty());
	}
	
	@Test
	@DisplayName("Update Content: First Name")
	void testUpdateFirstName() {
		contactService.addContact("Josh", "Ryther", "1234567891", "3232 Road Ln");
		contactService.updateFirstName("1", "John");
		assertTrue(contactService.getContactList().get(0).getFirstName().equals("John"));
	}
	
	@Test
	@DisplayName("Update Content: Last Name")
	void testUpdateLastName() {
		contactService.addContact("Josh", "Ryther", "1234567891", "3232 Road Ln");
		contactService.updateLastName("1", "Doe");
		assertTrue(contactService.getContactList().get(0).getLastName().equals("Doe"));
	}
	
	@Test
	@DisplayName("Update Content: Phone")
	void testUpdatePhone() {
		contactService.addContact("Josh", "Ryther", "1234567891", "3232 Road Ln");
		contactService.updatePhone("1", "8888888888");
		assertTrue(contactService.getContactList().get(0).getPhone().equals("8888888888"));
	}
	
	@Test
	@DisplayName("Update Content: Address")
	void testUpdateAddress() {
		contactService.addContact("Josh", "Ryther", "1234567891", "3232 Road Ln");
		contactService.updateAddress("1", "2020 Lane Rd");
		assertTrue(contactService.getContactList().get(0).getAddress().equals("2020 Lane Rd"));
	}
}
