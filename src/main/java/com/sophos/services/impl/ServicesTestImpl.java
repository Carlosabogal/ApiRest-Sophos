package com.sophos.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.entities.Test;
import com.sophos.repositories.TestRepository;
import com.sophos.services.ServicesTest;




@Service
public class ServicesTestImpl implements ServicesTest{
	
	@Autowired
	private TestRepository testRepository;
	@Override
	public List<Test> listAllTest() {
		return (List<Test>) testRepository.findAll();

	}
	@Override
	public Optional<Test> findById(Integer id){
		return testRepository.findById(id);

	}
	
	@Override
	public void deleteById(Integer id) {
		testRepository.deleteById(id);

	}
	@Override
	public Optional<Test> PutInfo(Integer id, Test testToUpdate) {
		Optional<Test> test = testRepository.findById(id);
		
		if(!test.isPresent()){
			return null;
		}
		
		test.get().setName(testToUpdate.getName());
		test.get().setDescription(testToUpdate.getDescription());
		
		testRepository.save(test.get());

		return test;
	}
	
	@Override
	public  Test save(Test test) {
		// TODO Auto-generated method stub

		return testRepository.save(test);
	}

	

}
