package com.shreesoft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreesoft.Binding.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
