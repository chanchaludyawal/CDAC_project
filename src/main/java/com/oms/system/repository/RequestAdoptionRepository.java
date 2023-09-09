package com.oms.system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.system.entity.Child;
import com.oms.system.entity.RequestAdoption;
import com.oms.system.entity.User;

public interface RequestAdoptionRepository extends JpaRepository<RequestAdoption, Integer>{

	Optional<RequestAdoption> findByUser(User user);

	Optional<RequestAdoption>findByChild(Child child);
}
