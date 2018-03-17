package com.example.quarz.simple.single.jobdetails;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.quarz.simple.single.jobdetails.service.JobService;

public class DynamicJob implements Job {
	@Autowired
	private JobService jobService;

	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobKey key = context.getJobDetail().getKey();
		System.out.println("Simple Job started with key :" + key.getName() + ", Group :" + key.getGroup()
				+ " , Thread Name :" + Thread.currentThread().getName());

		System.out.println("Hello World from Hello Job.");
		// System.out.println(jobService.getJobs("testring"));

	}
}
