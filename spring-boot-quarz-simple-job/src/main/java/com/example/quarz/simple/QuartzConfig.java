package com.example.quarz.simple;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.quarz.simple.single.jobdetails.AutowiringSpringBeanJobFactory;
import com.example.quarz.simple.single.jobdetails.JobOne;

@Configuration
public class QuartzConfig {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private ApplicationContext applicationContext;
	//
	// // private JdbcTemplate jdbc;
	// // private DataSource datasource;
	//
	// // @Autowired
	// // public void setDataSource(DataSource ds) {
	// // this.datasource = ds;
	// // this.jdbc = new JdbcTemplate(ds);
	// // }

	// @Autowired
	// private ApplicationContext applicationContext;

	@PostConstruct
	public void init() {
		log.debug("QuartzConfig initialized.");
	}

	// @Bean
	// public JobServiceImplemention jobServiceImplemention() {
	// return new JobServiceImplemention();
	// }

	@Bean
	public SchedulerFactoryBean quartzScheduler() {
		SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();

		quartzScheduler.setDataSource(dataSource);
		quartzScheduler.setTransactionManager(transactionManager);
		quartzScheduler.setOverwriteExistingJobs(true);
		quartzScheduler.setSchedulerName("jelies-quartz-scheduler");

		// custom job factory of spring with DI support for @Autowired!
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();

		jobFactory.setApplicationContext(applicationContext);
		quartzScheduler.setJobFactory(jobFactory);

		quartzScheduler.setQuartzProperties(quartzProperties());

		System.out.println("properties>>>>>>>>>>>>");

		Trigger[] triggers = { procesoMQTrigger().getObject() };
		quartzScheduler.setTriggers(triggers);

		return quartzScheduler;
	}

	//
	@Bean
	public JobDetailFactoryBean procesoMQJob() {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(JobOne.class);
		jobDetailFactory.setDurability(true);
		jobDetailFactory.setGroup("spring3-quartz");
		return jobDetailFactory;
	}

	//
	@Bean
	public CronTriggerFactoryBean procesoMQTrigger() {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setJobDetail(procesoMQJob().getObject());
		cronTriggerFactoryBean.setCronExpression("0 * * * * ?");
		cronTriggerFactoryBean.setGroup("spring3-quartz");
		return cronTriggerFactoryBean;
	}

	@Bean
	public Properties quartzProperties() {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("application.properties"));
		Properties properties = null;
		try {
			propertiesFactoryBean.afterPropertiesSet();
			properties = propertiesFactoryBean.getObject();
			System.out.println("properties>>>>>>>>>>>>");

			System.out.println(properties);

		} catch (IOException e) {
			log.warn("Cannot load quartz.properties.");
		}

		return properties;
	}

	// @Primary
	// @Bean(name = "dataSource")
	// @ConfigurationProperties(prefix = "application.properties")
	// public DataSource dataSource() {
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	// dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	// dataSource.setUrl("mysql:jdbc://localhost:3306/scheduledemo");
	// dataSource.setUsername("root");
	// dataSource.setPassword("root");
	// return dataSource;
	// }
}