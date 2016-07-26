package org.sgit.manageguest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Slacode {

	private String code;
	private String description;
	private String time;
	private String active;

	public Slacode() {

	}

	public Slacode(String code, String description, String time, String password) {

		super();
		this.code = code;
		this.description = description;
		this.time = time;
		this.active = active;

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
