package com.example.quarz.simple.single.jobdetails;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MultipleJobs {

	public static void main(String args[]) {
		try {
			// Set job details.
			JobDetail job = JobBuilder.newJob().ofType(HelloJob.class).storeDurably().withIdentity("Qrtz_Job_Detail")
					.withDescription("Invoke Sample Job service...").build();

			JobDetail hello_job = JobBuilder.newJob().ofType(JobOne.class).withIdentity(" JOb1s", "group1").build();

			JobDetail job_one = JobBuilder.newJob().ofType(HelloJob.class).withIdentity("hello job", "group1").build();

			// JobDetail job_one =
			// JobBuilder.newJob().ofType(JobOne.class).withIdentity("Job One",
			// "group1").build();

			// Set the scheduler timings.
			Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("cronTrigger1", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();

			Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("cronTrigger2", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();

			// Execute the job.
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(hello_job, trigger1);
			scheduler.scheduleJob(job_one, trigger2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
