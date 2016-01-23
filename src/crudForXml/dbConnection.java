/*
 * This is the class for database connection
 * This class uses MySql Community server Release Version: 5.5.22 with ODBC Driver
 */
package crudForXml;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
	Connection con = null;

	public Connection getConnection1() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:datasource1");
			System.out.println("Connection sucessful");
		} catch (Exception e) {
			System.out.println("Error in connection" + e);
		}
		return con;
	}
}