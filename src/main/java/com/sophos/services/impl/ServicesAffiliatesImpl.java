package com.sophos.services.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.entities.Affiliates;
import com.sophos.repositories.AffiliatesRepository;
import com.sophos.services.ServicesAffiliates;
@Service
public class ServicesAffiliatesImpl implements ServicesAffiliates{

	@Autowired
	private AffiliatesRepository affiliatesRepository;
		
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		affiliatesRepository.deleteById(id);
	}
	
	@Override
	public Optional<Affiliates> PutInfoAffiliates(Integer id, Affiliates affiliatesToUpdate) {
		Optional<Affiliates> affiliates = affiliatesRepository.findById(id);
		
		if(!affiliates.isPresent()){
			return null;
		}
		
		affiliates.get().setName(affiliatesToUpdate.getName());
		affiliates.get().setAge(affiliatesToUpdate.getAge());
		affiliates.get().setMail(affiliatesToUpdate.getMail());
		
		affiliatesRepository.save(affiliates.get());
		return affiliates;

	}
	
	@Override
	public  Affiliates save(Affiliates affiliates) {
		return affiliatesRepository.save(affiliates);
	}

	@Override
	public List<Affiliates> listAllAffiliates() {
		return (List<Affiliates>) affiliatesRepository.findAll();
	}

	@Override
	public Optional<Affiliates> findById(Integer id) {
		return(Optional<Affiliates>) affiliatesRepository.findById(id);
	}
}
