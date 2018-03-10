package com.example.quarz.simple.single.jobdetails;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class JobOne implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobKey key = context.getJobDetail().getKey();
		System.out.println("Simple Job started with key :" + key.getName() + ", Group :" + key.getGroup()
				+ " , Thread Name :" + Thread.currentThread().getName());

	}

}
