package org.sgit.manageguest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String id;
	private String firstName;
	private String lastName;
	private String password;
	private String hotelName;
	private String departmentName;
	private String active;

	public User() {

	}

	public User(String id, String firstName, String lastName, String password,
			String hotelName, String departmentName, String active) {

		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.hotelName = hotelName;
		this.departmentName = departmentName;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
