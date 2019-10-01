package com.pms.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Person;
import com.pms.model.PresDrugs;
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	Person findByUsername(String username);

	ArrayList<Person> findByUsernameLike(String string);

}
