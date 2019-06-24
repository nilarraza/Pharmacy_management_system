package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.NonPresDrugs;

@Repository
public interface NonPresDrugsRepository extends CrudRepository<NonPresDrugs, Integer> {

}
