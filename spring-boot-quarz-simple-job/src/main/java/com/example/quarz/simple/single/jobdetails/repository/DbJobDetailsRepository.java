package com.example.quarz.simple.single.jobdetails.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.quarz.simple.single.jobdetails.entity.DbJobDetails;

@Transactional
@Component
public interface DbJobDetailsRepository extends CrudRepository<DbJobDetails, String> {

	/**
	 * This method will find an User instance in the database by its email. Note
	 * that this method is not implemented and its working code will be
	 * automagically generated from its signature by Spring Data JPA.
	 */

	// List<DbJobDetails> findByIncidentId(String incidentId);

}
