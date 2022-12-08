package com.sophos.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sophos.entities.Affiliates;
import com.sophos.services.ServicesAffiliates;

@ExtendWith(MockitoExtension.class)
class AffiliatesControllerTest {

	@InjectMocks
	private AffiliatesController affiliatesController = new AffiliatesController();
	@Mock
	private ServicesAffiliates servicesAffiliatesMock;
	

	@Test
	void listAllAffiliates() {
		List<Affiliates> listAffiliates = new ArrayList<Affiliates>();
		Affiliates affiliates = new Affiliates(1,"jose",25,"josefelipe@hotmail.com");
		listAffiliates.add(affiliates);
		when(servicesAffiliatesMock.listAllAffiliates()).thenReturn(listAffiliates);
		ResponseEntity<?> response = affiliatesController.listAllAffiliate();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
   

	@Test
	void findById() {
		Affiliates affiliates = new Affiliates(1,"jose",25,"josefelipe@hotmail.com");
		Optional<Affiliates> opAffiliates = Optional.of(affiliates);
		when(servicesAffiliatesMock.findById(1)).thenReturn(opAffiliates);
		ResponseEntity<?> response = affiliatesController.findById(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void deleteById() {
		doNothing().when(servicesAffiliatesMock).deleteById(1);
		ResponseEntity<?> response = affiliatesController.deleteById(1);;
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	void putInfo() {
		Affiliates affiliates = new Affiliates(1,"jose",25,"josefelipe@hotmail.com");
		Optional<Affiliates> opAffiliates = Optional.of(affiliates);
		when(servicesAffiliatesMock.PutInfoAffiliates(1, affiliates)).thenReturn(opAffiliates);
		ResponseEntity<?> response = affiliatesController.PutInfoAffiliates(1, affiliates);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	void save() {
		Affiliates affiliates = new Affiliates(1,"jose",25,"josefelipe@hotmail.com");
		when(servicesAffiliatesMock.save(affiliates)).thenReturn(affiliates);
		ResponseEntity<?> response = affiliatesController.save(affiliates);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	
	

}
