package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.ProfileImg;

@Repository
public interface ProfileImgRepository extends CrudRepository<ProfileImg,Integer> {

}
