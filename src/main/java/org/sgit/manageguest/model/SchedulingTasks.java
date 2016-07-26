package org.sgit.manageguest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SchedulingTasks {
	
	private String id;
	private String cadence;

	public SchedulingTasks() {

	}

	public SchedulingTasks(String id, String cadence) {

		super();
		this.id = id;
		this.cadence = cadence;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCadence() {
		return cadence;
	}

	public void setCadence(String cadence) {
		this.cadence = cadence;
	}


}
