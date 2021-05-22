package com.joshryther.project_one;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	private TaskService taskService;
	
	@BeforeEach
	void setUp() {
		taskService = new TaskService();
		assertTrue(taskService.getTaskList().isEmpty());
	}

	@Test
	@DisplayName("Add Task: Empty ArrayList")
	void testAddEmpty() {
		taskService.addTask("Email", "Check email inbox");
		assertTrue(taskService.getTaskList().get(0).getiD().equals("1"));
	}
	
	@Test
	@DisplayName("Add Task: Populated ArrayList")
	void testAddNotPopulated() {
		taskService.addTask("Email", "Check email inbox");
		taskService.addTask("Call Jill", "Call Jill from legal");
		assertFalse(taskService.getTaskList().isEmpty());
		assertTrue(taskService.getTaskList().get(1).getiD().equals("2"));
	}

	@Test
	@DisplayName("Delete Task")
	void testDelete() {
		taskService.addTask("Email", "Check email inbox");
		taskService.deleteTask("1");
		assertTrue(taskService.getTaskList().isEmpty());
	}
	
	@Test
	@DisplayName("Update Task: Name")
	void testUpdateName() {
		taskService.addTask("Email", "Check email inbox");
		taskService.updateName("1", "EmailCheck");
		assertTrue(taskService.getTaskList().get(0).getName().equals("EmailCheck"));
	}
	
	@Test
	@DisplayName("Update Task: Description")
	void testUpdateDescription() {
		String string = "I am changing the description";
		taskService.addTask("Email", "Check email inbox");
		taskService.updateDescription("1", string);
		assertTrue(taskService.getTaskList().get(0).getDescription().equals(string));
	}
}
