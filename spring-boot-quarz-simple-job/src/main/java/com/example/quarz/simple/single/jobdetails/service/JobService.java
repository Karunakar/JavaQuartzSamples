package com.example.quarz.simple.single.jobdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quarz.simple.single.jobdetails.entity.DbJobDetails;

@Service
public interface JobService {
	// public List<DbJobDetails> find_by_job_name();

	public List<DbJobDetails> getJobs();
}
