package dev.pioruocco.lazybank.repository;

import dev.pioruocco.lazybank.model.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
