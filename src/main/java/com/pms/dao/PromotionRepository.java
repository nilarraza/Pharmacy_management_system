package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Promotion;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Integer> {



}
