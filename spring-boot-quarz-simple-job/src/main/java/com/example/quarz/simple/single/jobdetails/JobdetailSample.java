package com.example.quarz.simple.single.jobdetails;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class JobdetailSample {
	public static void main(String args[]) {
		try {
			// Set job details.
			JobDetail job = JobBuilder.newJob().ofType(HelloJob.class).storeDurably().withIdentity("Qrtz_Job_Detail")
					.withDescription("Invoke Sample Job service...").build();

			// Set the scheduler timings.
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "group1")
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())
					.build();

			// Execute the job.
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
