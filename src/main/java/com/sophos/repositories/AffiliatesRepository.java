package com.sophos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sophos.entities.Affiliates;


@Repository
public interface AffiliatesRepository extends JpaRepository<Affiliates,Integer>{

	
	

}
