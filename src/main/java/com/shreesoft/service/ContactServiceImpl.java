package com.shreesoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreesoft.Binding.Contact;
import com.shreesoft.Repository.ContactRepository;

@Service	
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repo;
	@Override
	public String saveContact(Contact contact) {
		
		contact = repo.save(contact);
		if(contact.getContactId()!=null) {
			return "Contact Saved..!!";
		} else {
			return "Contact Failed to Save";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		/*List<Contact> contacts = repo.findAll();
		return contacts;*/
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		
		if(repo.existsById(contact.getContactId())) {
			repo.save(contact);
			return "Updated Successfully..!!";
		} else {
			return "Updation Failed..!!";
		}
	}

	@Override
	public String deleteContact(Integer contactId) {
		if(repo.existsById(contactId)) {
			repo.deleteById(contactId);
			return "Record Deleted Successfully..!!";
		} else {
			return "Record Deletion Failed..!!";
		}
	}

	
}
