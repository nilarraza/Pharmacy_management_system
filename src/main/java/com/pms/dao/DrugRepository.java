package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Drugs;

@Repository
public interface DrugRepository extends CrudRepository<Drugs, Integer> {

}
