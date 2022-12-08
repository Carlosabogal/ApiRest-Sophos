package com.sophos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sophos.entities.Affiliates;
import com.sophos.services.ServicesAffiliates;

@RestController
@RequestMapping("/api/affiliates")
public class AffiliatesController {

	@Autowired
	private ServicesAffiliates servicesAffiliates;

	@GetMapping("/getlist")
	public ResponseEntity<?> listAllAffiliate() {

		List<Affiliates> ListGet = servicesAffiliates.listAllAffiliates();

		if (ListGet.isEmpty()) {
			return new ResponseEntity<>("No content", HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<>(ListGet, HttpStatus.OK);

		}

	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
		Optional<Affiliates> findId = servicesAffiliates.findById(id);

		if (findId.isPresent()) {
			return new ResponseEntity<>(findId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No content", HttpStatus.NOT_FOUND);

		}
	}

	@PutMapping("/put/{id}")
	public ResponseEntity<?> PutInfoAffiliates(@PathVariable(value = "id") Integer id,
			@RequestBody Affiliates affiliatesToUpdate) {

		Optional<Affiliates> updateAffiliate = servicesAffiliates.PutInfoAffiliates(id, affiliatesToUpdate);
		try {
			return new ResponseEntity<>(updateAffiliate, HttpStatus.CREATED);

		} catch (Exception exception) {
			return new ResponseEntity<>("No content", HttpStatus.NOT_FOUND);

		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(value = "id") Integer id) {
		servicesAffiliates.deleteById(id);
		try {
			servicesAffiliates.deleteById(id);
			return new ResponseEntity<>("Affiliate deleted successfully", HttpStatus.OK);

		} catch (Exception exception) {
			return new ResponseEntity<>("No content", HttpStatus.NOT_FOUND);

		}

	}

	@PostMapping("/post")
	public ResponseEntity<?> save(@RequestBody Affiliates affiliates) {
		Affiliates testSave = servicesAffiliates.save(affiliates);

		try {
			return new ResponseEntity<>(testSave, HttpStatus.CREATED);

		} catch (Exception exception) {
			return new ResponseEntity<>("No content", HttpStatus.NOT_FOUND);

		}

	}
}
