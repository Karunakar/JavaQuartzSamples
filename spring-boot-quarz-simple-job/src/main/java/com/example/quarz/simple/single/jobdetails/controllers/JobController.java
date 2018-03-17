package com.example.quarz.simple.single.jobdetails.controllers;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quarz.simple.single.jobdetails.JobOne;
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

	// private JobServiceImplemention cdrService = new JobServiceImplemention();

	@RequestMapping("createJob")
	@ResponseBody
	public void createJob(@RequestBody CreateJobRequest request) throws Exception {
		System.out.println(request.getName());
		System.out.println(request.getAction());
		DbJobDetails job_detail = new DbJobDetails();
		job_detail.setAction(request.getAction());
		job_detail.setName(request.getName());
		job_detail.setJob_group(request.getGroup());

		jobRepository.save(job_detail);

		JobDetail hello_job = JobBuilder.newJob().ofType(JobOne.class)
				.withIdentity(request.getName(), request.getName()).build();

		// Set the scheduler timings.
		Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity(request.getName(), request.getGroup())
				.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(hello_job, trigger1);

	}

}
