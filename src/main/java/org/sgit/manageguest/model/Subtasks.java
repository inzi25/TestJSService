package org.sgit.manageguest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Subtasks {
	
	private String id;
	private String subTaskName;
	
	public Subtasks() {

	}

	public Subtasks(String id, String subTaskName) {

		super();
		this.id = id;
		this.subTaskName = subTaskName;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubTaskName() {
		return subTaskName;
	}

	public void setSubTaskName(String subTaskName) {
		this.subTaskName = subTaskName;
	}

}
