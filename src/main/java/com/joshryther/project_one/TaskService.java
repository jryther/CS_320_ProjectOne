package com.joshryther.project_one;

import java.util.ArrayList;

public class TaskService {
	private ArrayList<Task> taskList;
	
	public TaskService(){
		this.taskList = new ArrayList<Task>();
	}
	
	public ArrayList<Task> getTaskList(){
		return taskList;
	}
	
	public void addTask(String name, String description) {
		int iD;
		
		if(taskList.isEmpty()) {
			iD = 1;
			Task task = new Task(Integer.toString(iD), name, description);
			taskList.add(task);
		}
		else {
			//Get the last ID number in the sorted array list, convert to int,
			//increment by 1, and convert back to string
			iD = Integer.parseInt(taskList.get(taskList.size()-1).getiD()) + 1;
			Task task = new Task(Integer.toString(iD), name, description);
			taskList.add(task);
		}
	}
	
	public void deleteTask(String iD) {	
		for(int i = 0; i < taskList.size(); i++) {
			if(taskList.get(i).getiD().equals(iD)) {
				taskList.remove(i);
				taskList.trimToSize();
				return;
			}
		}
	}
	
	public void updateName(String iD, String name) {
		for(int i = 0; i < taskList.size(); i++) {
			if(taskList.get(i).getiD().equals(iD)) {
				taskList.get(i).setName(name);
				return;
			}
		}
	}
	
	public void updateDescription(String iD, String description) {
		for(int i = 0; i < taskList.size(); i++) {
			if(taskList.get(i).getiD().equals(iD)) {
				taskList.get(i).setDescription(description);
				return;
			}
		}
	}
}
