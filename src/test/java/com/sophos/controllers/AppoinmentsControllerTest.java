package com.sophos.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
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
import com.sophos.entities.Appoinments;
import com.sophos.services.ServicesAffiliates;
import com.sophos.services.ServicesAppoinments;

@ExtendWith(MockitoExtension.class)
class AppoinmentsControllerTest {
	@InjectMocks
	private AppoinmentsController appoinmentsController = new AppoinmentsController();
	@Mock
	private ServicesAppoinments servicesAppoinmentsMock;

	@Test
	void listAllAppoinments() {

		com.sophos.entities.Test test = new com.sophos.entities.Test();
		Affiliates affiliate = new Affiliates();
		List<Appoinments> listAppoinments = new ArrayList<Appoinments>();
		Appoinments appoinments = new Appoinments(1, LocalDate.of(2020, 1, 8), LocalTime.of(06, 30), test, affiliate);
		listAppoinments.add(appoinments);
		when(servicesAppoinmentsMock.listAllAppoinments()).thenReturn(listAppoinments);
		ResponseEntity<?> response = appoinmentsController.listAllAppoinments();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void deleteById() {
		doNothing().when(servicesAppoinmentsMock).deleteById(1);
		ResponseEntity<?> response = appoinmentsController.deleteById(1);
		;
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	void findById() {
		com.sophos.entities.Test test = new com.sophos.entities.Test();
		Affiliates affiliate = new Affiliates();
		Appoinments appoinments = new Appoinments(1, LocalDate.of(2020, 1, 8), LocalTime.of(06, 30), test, affiliate);
		Optional<Appoinments> opApponments = Optional.of(appoinments);
		when(servicesAppoinmentsMock.findById(1)).thenReturn(opApponments);
		ResponseEntity<?> response = appoinmentsController.findById(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void putInfo() {
		com.sophos.entities.Test test = new com.sophos.entities.Test();
		Affiliates affiliate = new Affiliates();
		Appoinments appoinments = new Appoinments(1, LocalDate.of(2020, 1, 8), LocalTime.of(06, 30), test, affiliate);
		Optional<Appoinments> opApponments = Optional.of(appoinments);
		when(servicesAppoinmentsMock.PutInfoAppoinments(1, appoinments)).thenReturn(opApponments);
		ResponseEntity<?> response = appoinmentsController.PutInfoAppoinments(1, appoinments);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	void save() {

		com.sophos.entities.Test test = new com.sophos.entities.Test();
		Affiliates affiliate = new Affiliates();
		Appoinments appoinments = new Appoinments(1, LocalDate.of(2020, 1, 8), LocalTime.of(06, 30), test, affiliate);
		when(servicesAppoinmentsMock.save(appoinments)).thenReturn(appoinments);
		ResponseEntity<?> response = appoinmentsController.save(appoinments);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	@Test
	void getByAffiliatesById() {
		com.sophos.entities.Test test = new com.sophos.entities.Test();
		Affiliates affiliate = new Affiliates();
		List<Appoinments> listAppoinments = new ArrayList<Appoinments>();
		Appoinments appoinments = new Appoinments(1, LocalDate.of(2020, 1, 8), LocalTime.of(06, 30), test, affiliate);
		listAppoinments.add(appoinments);
		when(servicesAppoinmentsMock.getByAffiliatesById(1)).thenReturn(listAppoinments);
		ResponseEntity<?> response = appoinmentsController.getByAffiliatesById(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void findByDate() {
		com.sophos.entities.Test test = new com.sophos.entities.Test();
		Affiliates affiliate = new Affiliates();
		List<Appoinments> listAppoinments = new ArrayList<Appoinments>();
		Appoinments appoinments = new Appoinments(1, LocalDate.of(2020, 1, 8), LocalTime.of(06, 30), test, affiliate);
		listAppoinments.add(appoinments);
		when(servicesAppoinmentsMock.findByDate(LocalDate.of(2020, 1, 8))).thenReturn(listAppoinments);
		ResponseEntity<?> response = appoinmentsController.findByDate(2020, 1, 8);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
