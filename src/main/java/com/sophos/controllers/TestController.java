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

import com.sophos.entities.Test;
import com.sophos.services.ServicesTest;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	private ServicesTest servicesTest;
	@GetMapping("/getlist")
	public ResponseEntity<?> ListarTest(){
		
		List<Test> List= servicesTest.listAllTest();
		
		if(List.isEmpty()) {
			return new ResponseEntity<>("No content",HttpStatus.NO_CONTENT);

		}else {
			return new ResponseEntity<>(List,HttpStatus.OK);

		}
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") Integer id){
		 Optional<Test> ListId =  servicesTest.findById(id);
		 
		 if(ListId.isPresent()) {
			 return new ResponseEntity<>(ListId,HttpStatus.OK);

			}else {
				return new ResponseEntity<>("No content",HttpStatus.NOT_FOUND);

			}
	}
	
	
	@PutMapping("/put/{id}")
	public ResponseEntity<?> PutInfo(@PathVariable(value="id") Integer id,@RequestBody Test testToUpdate ) {
		
		 Optional<Test> testupdate= servicesTest.PutInfo(id,testToUpdate);
		 try {
				return new ResponseEntity<>(testupdate,HttpStatus.CREATED);

		 }catch (Exception exception) {
				return new ResponseEntity<>("No content",HttpStatus.NOT_FOUND);

		 }
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(value="id") Integer id){
		
		 try {
			 	servicesTest.deleteById(id);
				return new ResponseEntity<>("Test deleted successfully",HttpStatus.OK);

		 }catch (Exception exception) {
				return new ResponseEntity<>("No content",HttpStatus.NOT_FOUND);

		 }
		
	}
	
	@PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody Test test){
		Test savetest= servicesTest.save(test);
		try {
			return new ResponseEntity<>(savetest,HttpStatus.CREATED);

	 }catch (Exception exception) {
			return new ResponseEntity<>("No content",HttpStatus.NOT_FOUND);

	 }
        
    }
}
