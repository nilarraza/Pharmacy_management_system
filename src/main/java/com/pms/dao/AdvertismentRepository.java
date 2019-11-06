package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Advertisement;

@Repository
public interface AdvertismentRepository extends CrudRepository<Advertisement, Integer>{

}
