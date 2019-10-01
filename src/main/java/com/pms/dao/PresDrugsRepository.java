package com.pms.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.PresDrugs;

@Repository
public interface PresDrugsRepository extends CrudRepository<PresDrugs, Integer> {

	



}
