package org.sgit.manageguest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ticket {

	private int ticketNumber;
	private String hotelName;
	private String reservation_id;
	private String room_no;
	private String guestName;
	private String mainClientName;
	private String group_name;
	private String group_reservationId;
	private String created_time;
	private String created_date;
	private String createdby;
	private String assignedto;
	private String department_Name;
	private String due_date;
	private String due_time;
	private String status;
	private String task;
	private String cadence;
	private String comment;
	private String arrival_date;
	private String departure_date;
	private String arrival_time;
	private String departure_time;
	private String pax;
	private String nationality;
	private String gender;
	private String guest_status;
	private String checkout;
	private String sla_code;
	private String vip_status;
	private String room_type;
	private String upgraded_roomType;
	private String[] subTask;
	private String[] quntity;

	public Ticket() {

	}

	public Ticket(int ticketNumber, String hotelName, String reservation_id,
			String room_no, String guestName, String mainClientName,
			String group_name, String group_reservationId, String created_time,
			String created_date, String createdby, String assignedto,
			String department_Name, String due_date, String due_time,
			String status, String task, String cadence, String comment,
			String arrival_date, String departure_date, String arrival_time,
			String departure_time, String pax, String nationality,
			String gender, String guest_status, String checkout,
			String sla_code, String vip_status, String room_type,
			String upgraded_roomType,String[] subTask,String[] quntity) {

		super();
		this.ticketNumber = ticketNumber;
		this.hotelName = hotelName;
		this.reservation_id = reservation_id;
		this.room_no = room_no;
		this.guestName = guestName;
		this.mainClientName = mainClientName;
		this.group_name = group_name;
		this.group_reservationId = group_reservationId;
		this.created_time = created_time;
		this.created_date = created_date;
		this.createdby = createdby;
		this.assignedto = assignedto;
		this.department_Name = department_Name;
		this.due_date = due_date;
		this.due_time = due_time;
		this.status = status;
		this.task = task;
		this.cadence = cadence;
		this.comment = comment;
		this.arrival_date = arrival_date;
		this.departure_date = departure_date;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.pax = pax;
		this.nationality = nationality;
		this.gender = gender;
		this.guest_status = guest_status;
		this.checkout = checkout;
		this.sla_code = sla_code;
		this.vip_status = vip_status;
		this.room_type = room_type;
		this.upgraded_roomType = upgraded_roomType;
		this.subTask = subTask;
		this.quntity = quntity;

	}

	public String[] getSubTask() {
		return subTask;
	}

	public void setSubTask(String[] subTask) {
		this.subTask = subTask;
	}

	public String[] getQuntity() {
		return quntity;
	}

	public void setQuntity(String[] quntity) {
		this.quntity = quntity;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getMainClientName() {
		return mainClientName;
	}

	public void setMainClientName(String mainClientName) {
		this.mainClientName = mainClientName;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getGroup_reservationId() {
		return group_reservationId;
	}

	public void setGroup_reservationId(String group_reservationId) {
		this.group_reservationId = group_reservationId;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getAssignedto() {
		return assignedto;
	}

	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}

	public String getDepartment_Name() {
		return department_Name;
	}

	public void setDepartment_Name(String department_Name) {
		this.department_Name = department_Name;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getDue_time() {
		return due_time;
	}

	public void setDue_time(String due_time) {
		this.due_time = due_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getCadence() {
		return cadence;
	}

	public void setCadence(String cadence) {
		this.cadence = cadence;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(String arrival_date) {
		this.arrival_date = arrival_date;
	}

	public String getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getPax() {
		return pax;
	}

	public void setPax(String pax) {
		this.pax = pax;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGuest_status() {
		return guest_status;
	}

	public void setGuest_status(String guest_status) {
		this.guest_status = guest_status;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getSla_code() {
		return sla_code;
	}

	public void setSla_code(String sla_code) {
		this.sla_code = sla_code;
	}

	public String getVip_status() {
		return vip_status;
	}

	public void setVip_status(String vip_status) {
		this.vip_status = vip_status;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getUpgraded_roomType() {
		return upgraded_roomType;
	}

	public void setUpgraded_roomType(String upgraded_roomType) {
		this.upgraded_roomType = upgraded_roomType;
	}

}
