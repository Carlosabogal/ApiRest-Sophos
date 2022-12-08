package com.sophos.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sophos.entities.Affiliates;
import com.sophos.entities.Appoinments;


@Repository
public interface AppoinmentsRepository extends JpaRepository<Appoinments,Integer>{
	/*
	@param affiliate
	@return lista de appoinment
	@author
	@since*/
	@Query(value="select * from Appoinments where id_affiliate=?1",nativeQuery=true)
	public List<Appoinments> findByIdAffiliate(Integer idAffiliate);
	
	public Collection<Appoinments> findByDayDateOrderByIdAffiliateAsc(LocalDate dayDate);
	
}
