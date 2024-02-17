package com.zech.bank.repository;

import com.zech.bank.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact , String> {
}
