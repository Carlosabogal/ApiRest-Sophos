package com.sophos.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.sophos.entities.Affiliates;
import com.sophos.entities.Appoinments;
import com.sophos.services.ServicesAppoinments;

public interface ServicesAppoinments {
	
	public List<Appoinments> listAllAppoinments();
	public Optional<Appoinments> findById(Integer id);
	public void deleteById(Integer id);
	public Optional<Appoinments> PutInfoAppoinments(Integer id, Appoinments appoinmentsToUpdate);	
	public Appoinments save(Appoinments appoinments);
	public Collection<Appoinments> findByDate(LocalDate date);
	public List<Appoinments> getByAffiliatesById(Integer id);
}
