package org.sgit.manageguest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status {
	
	private String code;
	private String description;
	
	public Status() {

	}

	public Status(String code, String description) {

		super();
		this.code = code;
		this.description = description;

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

}
