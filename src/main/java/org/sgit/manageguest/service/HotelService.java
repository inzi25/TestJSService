package org.sgit.manageguest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.sgit.manageguest.model.Hotel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class HotelService {

	DBconnect connect = new DBconnect();
	String connectionUrl = connect.connectionString();

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	public String getHotels() {

		String result = " ";
		List<Hotel> list = new ArrayList<Hotel>();

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");
			String SQL = "SELECT * FROM sgit.hotels";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {

				Hotel h1 = new Hotel(rs.getString(1), rs.getString(2),
						rs.getString(3));
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

	public String insertHotel(Hotel hotel) {

		String result = " ";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			System.out.print("Connected.<br/>");
			String SQL = "INSERT INTO sgit.hotels (hotel_id,hotel_name,hotel_active) VALUES ('"
					+ hotel.getId()
					+ "','"
					+ hotel.getName()
					+ "','"
					+ hotel.getActive() + "')";

			stmt = con.createStatement();
			int res = stmt.executeUpdate(SQL);

			if (res == 1) {
				System.out.println("Insert Success");
				result = "Hotel created successfully";
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

	public String updateHotel(Hotel hotel) {

		String result = " ";

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");
			String SQL = "UPDATE sgit.hotels SET hotel_name= " + " '"
					+ hotel.getName() + "'" + "," + "hotel_active=" + "'"
					+ hotel.getActive() + "'" + "WHERE hotel_id=" + " '"
					+ hotel.getId() + "'";

			stmt = con.createStatement();
			int res = stmt.executeUpdate(SQL);

			if (res == 1) {
				System.out.println("Update Success");
				result = "Hotel updated successfully";
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
