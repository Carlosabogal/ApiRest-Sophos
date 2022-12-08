package com.sophos.services.impl;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.entities.Affiliates;
import com.sophos.entities.Appoinments;
import com.sophos.repositories.AppoinmentsRepository;
import com.sophos.services.ServicesAppoinments;
@Service
public class ServicesAppoinmentsImpl implements ServicesAppoinments{

	@Autowired
	private AppoinmentsRepository appoinmentsRepository;

	@Override
	public List<Appoinments> listAllAppoinments() {
		// TODO Auto-generated method stub
		return (List<Appoinments>) appoinmentsRepository.findAll();
	}

	@Override
	public Optional<Appoinments> findById(Integer id) {
		// TODO Auto-generated method stub
		return appoinmentsRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		appoinmentsRepository.deleteById(id);
	}

	@Override
	public Optional<Appoinments> PutInfoAppoinments(Integer id, Appoinments appoinmentsToUpdate) {
		// TODO Auto-generated method stub
		Optional<Appoinments> appoinments = appoinmentsRepository.findById(id);
		
		if(!appoinments.isPresent()){
			return null;
		}
		
		appoinments.get().setDayDate(appoinmentsToUpdate.getDayDate());
		appoinments.get().setHour(appoinmentsToUpdate.getHour());

		
		appoinmentsRepository.save(appoinments.get());

		return appoinments;	
		}

	@Override
	public Appoinments save(Appoinments appoinments) {

		return appoinmentsRepository.save(appoinments);
	}
	@Override
	public Collection<Appoinments> findByDate(LocalDate date) {
		Appoinments appoinment = new Appoinments();
		appoinment.setDayDate(date);
		return appoinmentsRepository.findByDayDateOrderByIdAffiliateAsc(date);
	}


	@Override
	public List<Appoinments> getByAffiliatesById(Integer affiliate) {
		// TODO Auto-generated method stub
		System.out.println("The affiliate id is " + affiliate);
		return appoinmentsRepository.findByIdAffiliate(affiliate);
	}






	
}
