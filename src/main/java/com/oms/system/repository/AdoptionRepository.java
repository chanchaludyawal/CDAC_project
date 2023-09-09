package com.oms.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.system.entity.Adoption;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption,Integer>{

	
}
