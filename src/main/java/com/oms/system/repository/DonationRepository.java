package com.oms.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.system.entity.Donation;
import com.oms.system.entity.User;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {

	List<Donation>findByUser(User user);

	int deleteByDonationId(int id);

}
