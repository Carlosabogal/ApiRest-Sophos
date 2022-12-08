package com.sophos.services;

import java.util.List;
import java.util.Optional;

import com.sophos.entities.Test;

public interface ServicesTest {
	public List<Test> listAllTest();
	public Optional<Test> findById(Integer id);
	public void deleteById(Integer id);
	public Optional<Test> PutInfo(Integer id, Test testToUpdate);	
	public Test save(Test test);

}
