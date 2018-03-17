package com.example.quarz.simple.single.jobdetails;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.quarz.simple.single.jobdetails.repository.DbJobDetailsRepository;
import com.example.quarz.simple.single.jobdetails.service.JobServiceImplemention;

@Component
public class JobOne implements Job {

	// // @Autowired
	// private JobServiceImplemention jobService;
	// //
	@Autowired
	private DbJobDetailsRepository job_repository;

	// public void setJobService(JobServiceImplemention jobService) {
	// this.jobService = jobService;
	// }
	//
	// public void setJob_repository(DbJobDetailsRepository job_repository) {
	// this.job_repository = job_repository;
	// }

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobServiceImplemention jobService = new JobServiceImplemention(job_repository);

		JobKey key = context.getJobDetail().getKey();
		System.out.println("Simple Job started with key :" + key.getName() + ", Group :" + key.getGroup()
				+ " , Thread Name :" + Thread.currentThread().getName());

		System.out.println("Hello World from Dynamic Job.");
		System.out.println(key.getName());

		jobService.getJobs();

		System.out.println("Karunakar is testing the dynamic jobs");

		jobService.getCount();

		System.out.println("Dynamic jobs count query " + jobService.getCount());

		// AnnotationConfigApplicationContext applicationContext = new
		// AnnotationConfigApplicationContext();
		// applicationContext.register(QuartzConfig.class);
		// applicationContext.getEnvironment().setActiveProfiles("default");
		// // applicationContext.scan("com");
		// applicationContext.refresh();
		// JobServiceImplemention customerService =
		// applicationContext.getBean(JobServiceImplemention.class);
		// customerService.getJobs();

	}

}
