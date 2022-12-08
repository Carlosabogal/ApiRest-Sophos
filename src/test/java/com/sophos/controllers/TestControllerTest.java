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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sophos.services.ServicesTest;

@ExtendWith(MockitoExtension.class)
class TestControllerTest {

	@InjectMocks
	private TestController testController = new TestController();
	@Mock
	private ServicesTest servicesTestMock;

	@Test
	void listAllTest() {
		List<com.sophos.entities.Test> listTest = new ArrayList<com.sophos.entities.Test>();
		com.sophos.entities.Test test = new com.sophos.entities.Test(1, "Maria paula", "programadora");
		listTest.add(test);
		when(servicesTestMock.listAllTest()).thenReturn(listTest);
		ResponseEntity<?> response = testController.ListarTest();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void findById() {
		com.sophos.entities.Test test = new com.sophos.entities.Test(1, "Maria paula", "programadora");
		Optional<com.sophos.entities.Test> opTest = Optional.of(test);
		when(servicesTestMock.findById(1)).thenReturn(opTest);
		ResponseEntity<?> response = testController.findById(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void deleteById() {
		doNothing().when(servicesTestMock).deleteById(1);
		ResponseEntity<?> response = testController.deleteById(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	void putInfo() {
		com.sophos.entities.Test test = new com.sophos.entities.Test(1, "Maria paula", "programador");
		Optional<com.sophos.entities.Test> optTest = Optional.of(test);
		when(servicesTestMock.PutInfo(1, test)).thenReturn(optTest);
		ResponseEntity<?> response = testController.PutInfo(1, test);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	void save() {
		com.sophos.entities.Test test = new com.sophos.entities.Test(4, "Geraldo rivera", "brujo");
		when(servicesTestMock.save(test)).thenReturn(test);
		ResponseEntity<?> response = testController.save(test);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}
}
