package com.pms.dao;

import org.springframework.data.repository.CrudRepository;

import com.pms.model.ShoppingCard;

public interface ShoppingCardRepository extends CrudRepository<ShoppingCard, Integer> {

}
