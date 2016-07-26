package org.sgit.manageguest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sgit.manageguest.model.Ticket;
import org.sgit.manageguest.model.User;

public class TicketService {

	DBconnect connect = new DBconnect();
	String connectionUrl = connect.connectionString();

	public String getHotelName(String hotelId) {
		String hotelName = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL_hotelName = "SELECT hotel_name FROM sgit.hotels WHERE hotel_id= '"
					+ hotelId + "'";
			System.out.print(SQL_hotelName);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_hotelName);
			if (rs.next()) {
				hotelName = rs.getString(1);
				System.out.print(hotelName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print(hotelName);
		return hotelName;

	}

	public String getDepartmentName(String departmentId) {
		String departmentName = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL_departmentName = "SELECT department_name FROM sgit.departments WHERE department_id= '"
					+ departmentId + "'";
			System.out.print(SQL_departmentName);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_departmentName);
			if (rs.next()) {
				departmentName = rs.getString(1);
				System.out.print(departmentName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return departmentName;

	}

	public String getHotelId(String hotelName) throws ClassNotFoundException {
		String hotelId = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL_hotelId = "SELECT hotel_id FROM sgit.hotels WHERE hotel_name= '"
					+ hotelName + "'";

			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_hotelId);
			if (rs.next()) {
				hotelId = rs.getString(1);
				System.out.print(hotelId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hotelId;

	}

	public String getDepartmentId(String departmentName) {
		String departmentId = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL_departmentId = "SELECT department_id FROM sgit.departments WHERE department_name= '"
					+ departmentName + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_departmentId);
			if (rs.next()) {
				departmentId = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return departmentId;

	}

	public String insertTask(Ticket ticket) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		Connection con1 = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;

		String result = " ";
		String customerId = " ";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			System.out.print("Connected.<br/>");

			String SQL = "INSERT INTO sgit.tickets (hotel_id,reservation_id,room_no,guest_name,mainclient_name,group_name,group_reservationId,created_time,created_date,createdby,assignedto,department_id,due_date,due_time,status,task,cadence,comment,arrival_date,departure_date,arrival_time,departure_time,pax,nationality,gender,guest_status,checkout,sla_code,vip_status,room_type,upgraded_roomType) VALUES ('"
					+ getHotelId(ticket.getHotelName())
					+ "','"
					+ ticket.getReservation_id()
					+ "','"
					+ ticket.getRoom_no()
					+ "','"
					+ ticket.getGuestName()
					+ "','"
					+ ticket.getMainClientName()
					+ "','"
					+ ticket.getGroup_name()
					+ "','"
					+ ticket.getGroup_reservationId()
					+ "','"
					+ ticket.getCreated_time()
					+ "','"
					+ ticket.getCreated_date()
					+ "','"
					+ ticket.getCreatedby()
					+ "','"
					+ ticket.getAssignedto()
					+ "','"
					+ getDepartmentId(ticket.getDepartment_Name())
					+ "','"
					+ ticket.getDue_date()
					+ "','"
					+ ticket.getDue_time()
					+ "','"
					+ ticket.getStatus()
					+ "','"
					+ ticket.getTask()
					+ "','"
					+ ticket.getCadence()
					+ "','"
					+ ticket.getComment()
					+ "','"
					+ ticket.getArrival_date()
					+ "','"
					+ ticket.getDeparture_date()
					+ "','"
					+ ticket.getArrival_time()
					+ "','"
					+ ticket.getDeparture_time()
					+ "','"
					+ ticket.getPax()
					+ "','"
					+ ticket.getNationality()
					+ "','"
					+ ticket.getGender()
					+ "','"
					+ ticket.getGuest_status()
					+ "','"
					+ ticket.getCheckout()
					+ "','"
					+ ticket.getSla_code()
					+ "','"
					+ ticket.getVip_status()
					+ "','"
					+ ticket.getRoom_type()
					+ "','"
					+ ticket.getUpgraded_roomType() + "')";

			System.out.print(SQL);
			stmt = con.createStatement();
			stmt.execute(SQL, Statement.RETURN_GENERATED_KEYS);

			ResultSet keyResultSet = stmt.getGeneratedKeys();
			int newCustomerId = 0;
			if (keyResultSet.next()) {
				newCustomerId = (int) keyResultSet.getInt(1);
				customerId = String.valueOf(newCustomerId);
				System.out.print(customerId);
			}

			con.close();

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con1 = DriverManager.getConnection(connectionUrl);

			String[] subTask = new String[ticket.getSubTask().length];
			subTask = ticket.getSubTask();
			System.out.print(ticket.getQuntity().length);
			String[] quantity = new String[ticket.getQuntity().length];
			quantity = ticket.getQuntity();

			int res = 0;

			for (int i = 0; i < subTask.length; i++) {

				String SQL_subtask = "INSERT INTO sgit.ticketSubtask (ticket_id,subtask_name,quantity) VALUES ('"
						+ customerId
						+ "','"
						+ subTask[i]
						+ "','"
						+ quantity[i]
						+ "')";

				System.out.print(SQL_subtask);
				stmt1 = con1.createStatement();
				res = stmt1.executeUpdate(SQL_subtask);

			}

			if (res == 1) {
				System.out.println("Insert Success");
				result = "Ticket created successfully";
			}

			con1.close();

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}

	public List<Ticket> getTicketDetails() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Ticket> list = new ArrayList<Ticket>();
		String[] aMessageId = null;

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");
			String SQL = "SELECT * FROM sgit.tickets";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			
			// Iterate through the data in the result set and display it.
			while (rs.next()) {

				Ticket h1 = new Ticket(rs.getInt(1),
						getHotelName(rs.getString(2)), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12),
						getDepartmentName(rs.getString(13)), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21), rs.getString(22), rs.getString(23),
						rs.getString(24), rs.getString(25), rs.getString(26),
						rs.getString(27), rs.getString(28), rs.getString(29),
						rs.getString(30), rs.getString(31), rs.getString(32),
						getSubTask(rs.getInt(1)), getQuantity(rs.getInt(1)));

				list.add(h1);

			}

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return list;

	}

	public String[] getSubTask(int i) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String[] subTask = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL = "SELECT subtask_name FROM sgit.ticketSubtask WHERE ticket_id= '"
					+ i + "'";
			System.out.println(SQL);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			rs.last();
			subTask = new String[rs.getRow()];
			rs.beforeFirst();

			int n = 0;
			while (rs.next()) {

				subTask[n] = rs.getString(1);
				n++;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return subTask;
	}

	public String[] getQuantity(int i) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String[] quantity = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL = "SELECT quantity FROM sgit.ticketSubtask WHERE ticket_id= '"
					+ i + "'";
			System.out.println(SQL);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(SQL);

			rs.last();
			quantity = new String[rs.getRow()];
			rs.beforeFirst();

			int n = 0;
			while (rs.next()) {

				quantity[n] = rs.getString(1);
				n++;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return quantity;
	}

	public String updateTicket(Ticket ticket) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String result = " ";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");

			String SQL = "UPDATE sgit.tickets SET assignedto= " + " '"
					+ ticket.getAssignedto() + "'" + "," + "department_id="
					+ "'" + getDepartmentId(ticket.getDepartment_Name()) + "'"
					+ "," + "due_date=" + "'" + ticket.getDue_date() + "'"
					+ "," + "due_time=" + "'" + ticket.getDue_time() + "'"
					+ "," + "status=" + "'" + ticket.getStatus() + "'" + ","
					+ "task=" + "'" + ticket.getTask() + "'" + "," + "comment="
					+ "'" + ticket.getComment() + "'" + "WHERE ticket_id="
					+ " '" + ticket.getTicketNumber() + "'";

			System.out.print(SQL);

			stmt = con.createStatement();
			int res = stmt.executeUpdate(SQL);

			if (res == 1) {
				System.out.println("Update Success");
				result = "Ticket updated successfully";
			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}

}
