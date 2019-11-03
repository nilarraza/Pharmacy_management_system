package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Pharmasist;

@Repository
public interface PharmasistRepository extends CrudRepository<Pharmasist,Integer>{

	

}
