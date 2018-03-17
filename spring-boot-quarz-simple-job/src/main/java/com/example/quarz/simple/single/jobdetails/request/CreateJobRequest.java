package com.example.quarz.simple.single.jobdetails.request;

public class CreateJobRequest {

	private long id;

	private String action;

	private String name;

	private String job_group;

	public String getJob_group() {
		return job_group;
	}

	public void setJob_group(String job_group) {
		this.job_group = job_group;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return job_group;
	}

	public void setGroup(String group) {
		this.job_group = group;
	}

}
