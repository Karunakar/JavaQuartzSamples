package com.example.quarz.simple.single.jobdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.quarz.simple.single.jobdetails.entity.DbJobDetails;
import com.example.quarz.simple.single.jobdetails.repository.DbJobDetailsRepository;

@Service
@Transactional
public class JobServiceImplemention implements JobService {

	@Autowired
	private DbJobDetailsRepository jobRepository;

	// @Override
	// public List<DbJobDetails> find_all_jobs() {
	//
	// return (List<DbJobDetails>) jobRepository.findAll();
	//
	// }

	public List<DbJobDetails> getJobs() {

		// private DbJobDetailsRepository jobRepository;

		return (List<DbJobDetails>) jobRepository.findAll();

	}

	public long getCount() {

		// private DbJobDetailsRepository jobRepository;

		return jobRepository.count();

	}

	public JobServiceImplemention(DbJobDetailsRepository jobRepository) {
		this.jobRepository = jobRepository;

	}

	// public List<DbJobDetails> find_by_job_name(String job_name) {
	//
	// return jobRepository.findAll();
	//
	// }

}
