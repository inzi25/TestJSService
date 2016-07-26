package org.sgit.manageguest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tasks {

	private String id;
	private String taskName;

	public Tasks() {

	}

	public Tasks(String id, String taskName) {

		super();
		this.id = id;
		this.taskName = taskName;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

}
