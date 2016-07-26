package org.sgit.manageguest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Department {

	private String id;
	private String name;
	private String active;

	public Department() {

	}

	public Department(String id, String name, String active) {
		
		super();
		this.id = id;
		this.name = name;
		this.active = active;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
