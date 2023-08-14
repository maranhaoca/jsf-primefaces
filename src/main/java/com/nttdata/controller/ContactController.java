package com.nttdata.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import com.nttdata.model.Contact;

@ManagedBean
@SessionScoped
public class ContactController {

	private Contact contact = new Contact();
	private Contact editContact = new Contact();
	private List<Contact> contacts = new ArrayList<Contact>();

	public List<Contact> findAll() {
		this.contacts.forEach(el -> System.out.println(el.getName()));
		return contacts;
	}

	public void save() {
		System.out.println(this.editContact.getId());
		if (this.editContact.getId() != null) {
			System.out.println("edit " + this.editContact.getId());
			edit();
		} else {
			System.out.println("create " + this.editContact.getId());
			this.editContact.setId(UUID.randomUUID());
			this.contacts.add(this.editContact);
		}
		cleanup();
	}

	public void edit() {
		this.editContact.setId(this.contact.getId());
		this.contacts.add(this.editContact);
		this.contacts.remove(this.contact);
	}

	public void remove(Contact contact) {
		this.contacts.remove(contact);
	}

	public void prepareEdit(Contact contact) {
		this.contact = contact;
		this.editContact = contact;
	}

	public void cleanup() {
		this.contact = new Contact();
		this.editContact = new Contact();
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact getEditContact() {
		return editContact;
	}

	public void setEditContact(Contact editContact) {
		this.editContact = editContact;
	}

}
