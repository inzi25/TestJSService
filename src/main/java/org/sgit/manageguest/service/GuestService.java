package org.sgit.manageguest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.sgit.manageguest.model.Guest;
import org.sgit.manageguest.model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class GuestService {

	DBconnect connect = new DBconnect();
	String connectionUrl = connect.connectionString();

	public String getHotelId(String hotelName) {
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

	public String getTaskId(String taskName) {
		String taskId = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL_taskId = "SELECT task_id FROM sgit.tasks WHERE task_name= '"
					+ taskName + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_taskId);
			if (rs.next()) {
				taskId = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskId;

	}

	public String getSubTaskId(String subtaskName) {
		String subtaskId = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL_subtaskId = "SELECT subtask_id FROM sgit.subtasks WHERE subtask_name= '"
					+ subtaskName + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_subtaskId);
			if (rs.next()) {
				subtaskId = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return subtaskId;

	}

	public String getSlacodeId(String slacodeName) {
		String slacodeId = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL_slacodeId = "SELECT sla_code FROM sgit.slacode WHERE sla_description= '"
					+ slacodeName + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_slacodeId);
			if (rs.next()) {
				slacodeId = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return slacodeId;

	}

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

	public String getTaskName(String taskId) {
		String taskName = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL_taskName = "SELECT task_name FROM sgit.tasks WHERE task_id= '"
					+ taskId + "'";
			System.out.print(SQL_taskName);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_taskName);
			if (rs.next()) {
				taskName = rs.getString(1);
				System.out.print(taskName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskName;

	}

	public String getSubTaskName(String subtaskId) {
		String subtaskName = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL_subtaskName = "SELECT subtask_name FROM sgit.subtasks WHERE subtask_id= '"
					+ subtaskId + "'";
			System.out.print(SQL_subtaskName);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_subtaskName);
			if (rs.next()) {
				subtaskName = rs.getString(1);
				System.out.print(subtaskName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return subtaskName;

	}

	public String getSlaName(String slaId) {
		String slaName = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			String SQL_subtaskName = "SELECT sla_description FROM sgit.slacode WHERE sla_code= '"
					+ slaId + "'";
			System.out.print(SQL_subtaskName);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL_subtaskName);
			if (rs.next()) {
				slaName = rs.getString(1);
				System.out.print(slaName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return slaName;

	}

	public String getService() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Guest> list = new ArrayList<Guest>();

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");
			String SQL = "SELECT * FROM sgit.service";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {

				Guest h1 = new Guest(getHotelName(rs.getString(1)),
						getDepartmentName(rs.getString(2)),
						getTaskName(rs.getString(3)),
						getSlaName(rs.getString(4)),getSubTaskName(rs.getString(5)), rs.getString(6));

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

		Gson gson = new GsonBuilder().create();
		JsonArray myCustomArray = gson.toJsonTree(list).getAsJsonArray();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", myCustomArray);
		System.out.print(jsonObject.toString());

		return jsonObject.toString();

	}

	public String insertGuestService(Guest guest) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String result = " ";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			System.out.print("Connected.<br/>");

			String SQL = "INSERT INTO sgit.service (hotel_id,department_id,task_id,subtask_id,sla_code,service_active) VALUES ('"
					+ getHotelId(guest.getHotelName())
					+ "','"
					+ getDepartmentId(guest.getDepartmentName())
					+ "','"
					+ getTaskId(guest.getTaskName())
					+ "','"
					+ getSubTaskId(guest.getSubtaskName())
					+ "','"
					+ getSlacodeId(guest.getSlaCode())
					+ "','"
					+ guest.getActive() + "')";

			System.out.print(SQL);
			stmt = con.createStatement();
			int res = stmt.executeUpdate(SQL);

			if (res == 1) {
				System.out.println("Insert Success");
				result = "Service maped successfully";
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
