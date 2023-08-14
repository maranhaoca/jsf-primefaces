package com.nttdata.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.nttdata.controller.ContactController;

class ContactControllerTest {
	
	ContactController controller = new ContactController();

	@Test
	void save() {
		List<Contact> contacts = controller.getContacts();
		assertTrue(contacts.isEmpty());
		
		controller.save();
		
		List<Contact> newContacts = controller.getContacts();
		assertEquals(newContacts.size(), 1);
	}
}
