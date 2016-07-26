package org.sgit.manageguest.service;

public class DBconnect {

	String connectionUrl;

	public String connectionString() {

		try {

			connectionUrl = "jdbc:sqlserver://jkhazuredev.database.windows.net:1433;database=jkhazuredevdb;user=jkhadmin@jkhazuredev;password=pass#word1;";

		} catch (Exception e) {
			e.printStackTrace();

		}

		return connectionUrl;

	}

}
