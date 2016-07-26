package org.sgit.manageguest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hotel {

	private String id;
	private String name;
	private String active;

	public Hotel() {

	}

	public Hotel(String id, String name, String active) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

}
