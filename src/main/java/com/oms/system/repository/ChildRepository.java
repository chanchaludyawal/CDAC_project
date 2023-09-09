package com.oms.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.system.entity.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child,Integer>{

	 int deleteByChildId(int childId);

	
	
	
	

}
