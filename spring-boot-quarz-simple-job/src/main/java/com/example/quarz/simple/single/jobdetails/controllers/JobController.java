package com.example.quarz.simple.single.jobdetails.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quarz.simple.single.jobdetails.entity.DbJobDetails;
import com.example.quarz.simple.single.jobdetails.repository.DbJobDetailsRepository;
import com.example.quarz.simple.single.jobdetails.request.CreateJobRequest;

@RestController
@RequestMapping("/quarz/")
@CrossOrigin
public class JobController {

	// @Autowired
	// private JobService jobService;

	@Autowired
	private DbJobDetailsRepository jobRepository;

	@RequestMapping("createJob")
	@ResponseBody
	public void createCPR(@RequestBody CreateJobRequest request) throws Exception {
		// System.out.println("Karunakar is very good boy");
		// System.out.println(request.getName());
		// System.out.println(request.getAction());
		DbJobDetails job_detail = new DbJobDetails();
		// job_detail.setAction(request.getAction());
		// job_detail.setName(request.getName());
		// job_detail.setGroup(request.getGroup());

		jobRepository.save(job_detail);
	}

}
