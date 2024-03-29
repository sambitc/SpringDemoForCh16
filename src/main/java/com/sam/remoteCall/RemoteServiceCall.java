package com.sam.remoteCall;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch16.domain.Contact;
import com.apress.prospring3.ch16.service.ContactService;

public class RemoteServiceCall {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:http-invoker-app-context.xml");
		ctx.refresh();
		ContactService contactService = ctx.getBean("remoteContactService",
				ContactService.class);
		// Find all contacts
		System.out.println("Finding all contacts");
		List<Contact> contacts = contactService.findAll();
		listContacts(contacts);
		// Find contacts by first name
		System.out.println("Finding contact with first name equals Clarence");
		contacts = contactService.findByFirstName("Clarence");
		listContacts(contacts);
	}

	private static void listContacts(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		System.out.println("");
	}
}