package org.sgit.manageguest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.sgit.manageguest.model.UserLogin;
import org.sgit.manageguest.model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class UserService {

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

	public String getUser() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<User> list = new ArrayList<User>();

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");
			String SQL = "SELECT * FROM sgit.users";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {

				User h1 = new User(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						getHotelName(rs.getString(5)),
						getDepartmentName(rs.getString(6)), rs.getString(7));

				System.out.print("Hotel Name" + getHotelName(rs.getString(5)));

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

	public String insertUser(User user) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String result = " ";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			System.out.print("Connected.<br/>");

			String SQL = "INSERT INTO sgit.users (user_id,user_firstname,user_lastname,user_password,hotel_id,department_id,user_active) VALUES ('"
					+ user.getId()
					+ "','"
					+ user.getFirstName()
					+ "','"
					+ user.getLastName()
					+ "','"
					+ user.getPassword()
					+ "','"
					+ getHotelId(user.getHotelName())
					+ "','"
					+ getDepartmentId(user.getDepartmentName())
					+ "','"
					+ user.getActive() + "')";

			System.out.print(SQL);
			stmt = con.createStatement();
			int res = stmt.executeUpdate(SQL);

			// rs = stmt.getGeneratedKeys();

			if (res == 1) {
				System.out.println("Insert Success");
				result = "User created successfully";
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

	public String updateUser(User user) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String result = " ";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");

			String SQL = "UPDATE sgit.users SET user_firstname= " + " '"
					+ user.getFirstName() + "'" + "," + "user_lastname=" + "'"
					+ user.getLastName() + "'" + "," + "department_id=" + "'"
					+ getDepartmentId(user.getDepartmentName()) + "'" + ","
					+ "hotel_id=" + "'" + getHotelId(user.getHotelName()) + "'"
					+ "," + "user_password=" + "'" + user.getPassword() + "'"
					+ "," + "user_active=" + "'" + user.getActive() + "'"
					+ "WHERE user_id=" + " '" + user.getId() + "'";

			System.out.print(SQL);

			stmt = con.createStatement();
			int res = stmt.executeUpdate(SQL);

			if (res == 1) {
				System.out.println("Update Success");
				result = "User updated successfully";
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

	public String login(UserLogin userLogin) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String result = "false";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");
			String SQL = "SELECT user_id, user_password FROM sgit.users WHERE user_id='"
					+ userLogin.getId()
					+ "' AND user_password='"
					+ userLogin.getPassword() + "'";

			System.out.print(SQL);
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			if (rs.next()) {
				result = "true";

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

	public String changePassword(UserLogin userLogin) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String result = " ";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");

			String SQL = "UPDATE sgit.users SET user_password=" + "'"
					+ userLogin.getPassword() + "'" + "WHERE user_id=" + " '"
					+ userLogin.getId() + "'";

			System.out.print(SQL);

			stmt = con.createStatement();
			int res = stmt.executeUpdate(SQL);

			if (res == 1) {
				System.out.println("Update Success");
				result = "Password changed successfully";
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
