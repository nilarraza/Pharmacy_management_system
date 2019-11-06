package com.pms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.model.Sales;



@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {
	
	@Query("select pid,count(pid) from  Sales group by pid")
	public List<Object[]> findPidandPidCount();

}
