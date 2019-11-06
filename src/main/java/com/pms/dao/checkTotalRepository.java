package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.checkTotal;

@Repository
public interface checkTotalRepository extends CrudRepository<checkTotal, Integer>{

}
