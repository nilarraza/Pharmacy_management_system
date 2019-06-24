package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Person;
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	Person findByUsername(String username);

}
