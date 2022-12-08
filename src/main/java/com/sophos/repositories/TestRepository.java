package com.sophos.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sophos.entities.Test;

@Repository
public interface TestRepository extends JpaRepository <Test,Integer>{

	
	

}
