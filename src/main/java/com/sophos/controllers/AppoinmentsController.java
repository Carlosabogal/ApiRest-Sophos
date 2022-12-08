package com.sophos.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Collection;

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

import com.sophos.entities.Appoinments;
import com.sophos.services.ServicesAppoinments;

@RestController
@RequestMapping("/api/appointments")
public class AppoinmentsController {

	@Autowired
	private ServicesAppoinments servicesAppoinments;

	@GetMapping("/getlist")
	public ResponseEntity<?> listAllAppoinments() {

		List<Appoinments> list = servicesAppoinments.listAllAppoinments();

		if (list.isEmpty()) {
			return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);

		} else {
			return new ResponseEntity<>(list, HttpStatus.OK);

		}

	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {

		Optional<Appoinments> findId = servicesAppoinments.findById(id);

		if (findId.isPresent()) {

			return new ResponseEntity<>(findId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No content", HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/getbydate/{day}/{month}/{year}")
	public ResponseEntity<?> findByDate(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
		try {
			LocalDate date = LocalDate.of(year, month, day);
			Collection<Appoinments> appoinmentList = this.servicesAppoinments.findByDate(date);
			System.out.print(appoinmentList.toString());
			if (appoinmentList.isEmpty()) {

				return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(appoinmentList, HttpStatus.OK);

			}
		} catch (Exception exception) {
			return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);

		}
	}

	@PutMapping("/put/{id}")
	public ResponseEntity<?> PutInfoAppoinments(@PathVariable(value = "id") Integer id,
			@RequestBody Appoinments appoinmentsToUpdate) {

		Optional<Appoinments> updateId = servicesAppoinments.PutInfoAppoinments(id, appoinmentsToUpdate);
		if (updateId.isPresent()) {

			return new ResponseEntity<>(updateId, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("No content", HttpStatus.NOT_FOUND);

		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(value = "id") Integer id) {
		servicesAppoinments.deleteById(id);
		try {
			servicesAppoinments.deleteById(id);
			return new ResponseEntity<>("Appoinments deleted successfully", HttpStatus.OK);

		} catch (Exception exception) {
			return new ResponseEntity<>("No content", HttpStatus.NOT_FOUND);

		}

	}

	@PostMapping("/post")
	public ResponseEntity<?> save(@RequestBody Appoinments appoinments) {
		Appoinments addAffili = servicesAppoinments.save(appoinments);
		try {
			return new ResponseEntity<>(addAffili, HttpStatus.CREATED);

		} catch (Exception exception) {
			return new ResponseEntity<>("No content", HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/getbyaffiliates/{id}")
	public ResponseEntity<?> getByAffiliatesById(@PathVariable(value = "id") Integer id) {
		try {

			List<Appoinments> appoinments = servicesAppoinments.getByAffiliatesById(id);

			if (appoinments.isEmpty()) {

				return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(appoinments, HttpStatus.OK);

			}
		} catch (Exception exception) {
			return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);

		}

	}
}
