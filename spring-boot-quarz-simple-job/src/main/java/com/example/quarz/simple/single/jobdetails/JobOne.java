package com.example.quarz.simple.single.jobdetails;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobOne implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello World from Job One.");
	}

}
