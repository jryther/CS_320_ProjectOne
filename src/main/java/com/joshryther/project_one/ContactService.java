package com.joshryther.project_one;

import java.util.ArrayList;

public class ContactService {
	private ArrayList<Contact> contactList;
	
	public ContactService(){
		this.contactList = new ArrayList<Contact>();
	}
	
	public ArrayList<Contact> getContactList(){
		return contactList;
	}
	
	public void addContact(String firstName, String lastName, String phone, String address) {
		int iD;
		
		if(contactList.isEmpty()) {
			iD = 1;
			Contact contact = new Contact(Integer.toString(iD), firstName, lastName, phone, address);
			contactList.add(contact);
		}
		else {
			//Get the last ID number in the sorted array list, convert to int,
			//increment by 1, and convert back to string
			iD = Integer.parseInt(contactList.get(contactList.size()-1).getiD()) + 1;
			Contact contact = new Contact(Integer.toString(iD), firstName, lastName, phone, address);
			contactList.add(contact);
		}
	}
	
	public void deleteContact(String iD) {	
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getiD().equals(iD)) {
				contactList.remove(i);
				contactList.trimToSize();
				return;
			}
		}
	}
	
	public void updateFirstName(String iD, String firstName) {
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getiD().equals(iD)) {
				contactList.get(i).setFirstName(firstName);
				break;
			}
		}
	}
	
	public void updateLastName(String iD, String lastName) {
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getiD().equals(iD)) {
				contactList.get(i).setLastName(lastName);
				break;
			}
		}
	}
	
	public void updatePhone(String iD, String phone) {
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getiD().equals(iD)) {
				contactList.get(i).setPhone(phone);
				break;
			}
		}
	}
	
	public void updateAddress(String iD, String address) {
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getiD().equals(iD)) {
				contactList.get(i).setAddress(address);
				break;
			}
		}
	}
	
	
}
