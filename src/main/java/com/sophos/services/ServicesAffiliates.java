package com.sophos.services;

import java.util.List;
import java.util.Optional;

import com.sophos.entities.Affiliates;
import com.sophos.services.ServicesAffiliates;

public interface ServicesAffiliates {
	
	public List<Affiliates> listAllAffiliates();
	public Optional<Affiliates> findById(Integer id);
	public void deleteById(Integer id);
	public Optional<Affiliates> PutInfoAffiliates(Integer id, Affiliates affiliatesToUpdate);	
	public Affiliates save(Affiliates affiliates);

}
