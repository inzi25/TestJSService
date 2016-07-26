package org.sgit.manageguest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Guest {

	private String hotelName;
	private String departmentName;
	private String taskName;
	private String slaCode;
	private String subtaskName;
	private String active;

	public Guest() {

	}

	public Guest(String hotelName, String departmentName, String taskName,
			String slaCode, String subtaskName, String active) {

		super();
		this.hotelName = hotelName;
		this.departmentName = departmentName;
		this.taskName = taskName;
		this.slaCode = slaCode;
		this.subtaskName = subtaskName;
		this.active = active;

	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getSlaCode() {
		return slaCode;
	}

	public void setSlaCode(String slaCode) {
		this.slaCode = slaCode;
	}

	public String getSubtaskName() {
		return subtaskName;
	}

	public void setSubtaskName(String subtaskName) {
		this.subtaskName = subtaskName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}



}
