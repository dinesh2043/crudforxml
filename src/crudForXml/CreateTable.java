/*
 * This Class is for creating the tables.
 * After checking if there exists the same tables 
 * and dropping the table if exist
 * 
 */

package crudForXml;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateTable {
	Connection con = null;
	dbConnection db = new dbConnection();
	static boolean boo = false;// to assign the value only once for first run

	public void creatTable() {
		try {
			con = db.getConnection1();
			Statement st = con.createStatement();
			// to check if there is the table with same name or not
			DatabaseMetaData dbm = con.getMetaData();
			// check if "Customers" table is there
			ResultSet tables = dbm.getTables(null, null, "Customers", null);
			if (tables.next()) {
				// Table exists
				// to drop existing tables
				System.out
						.println("table exist with the name Customers,Address,Contact");
				// System.out.print(boo);
				// to run this condition only for the first run
				if (!boo) {
					boo = true;
					// System.out.print(boo);
					// sql query for droping tables
					String dropContact = "DROP TABLE Contact";
					st.executeUpdate(dropContact);
					String dropAddress = "DROP TABLE Address";
					st.executeUpdate(dropAddress);
					String dropCustomers = "DROP TABLE Customers";
					st.executeUpdate(dropCustomers);

					System.out
							.println("Customers,Address,Contact are dropped since we run the Application. We need new tables for this App.");
					// creating tables with the relationship with other
					// SQL statement to create Customer Table
					String sql = "CREATE TABLE Customers(custId SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,Name VARCHAR(54),Note VARCHAR(100),PRIMARY KEY (custId))";
					st.executeUpdate(sql);
					System.out
							.println("Customers table was created From xml file");
					// to create address table with the foreign kay of customer
					String sqlAddress = "CREATE TABLE Address(custId SMALLINT UNSIGNED NOT NULL,AddType VARCHAR(24),Street VARCHAR(50),POBox VARCHAR(20),PostalCode VARCHAR(20),Town VARCHAR(20),FOREIGN KEY (custId) REFERENCES Customers (custId))";
					st.executeUpdate(sqlAddress);
					System.out
							.println("Address table was created From xml file");
					// to create contact table with the foreign kay of customer
					String sqlContact = "CREATE TABLE Contact(custId SMALLINT UNSIGNED NOT NULL,Work_Phone VARCHAR(24),MOB_Phone VARCHAR(24),Work_Email VARCHAR(150),FOREIGN KEY (custId) REFERENCES Customers (custId))";
					st.executeUpdate(sqlContact);
					System.out
							.println("Contact table was created From xml file");
				}
			} else {
				// Table does not exist
				// to create customers table with primary kay auto incriment
				String sql = "CREATE TABLE Customers(custId SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,Name VARCHAR(54),Note VARCHAR(100),PRIMARY KEY (custId))";
				st.executeUpdate(sql);
				System.out.println("Customers table was created From xml file");
				// to create address table with the foreign kay of customer
				String sqlAddress = "CREATE TABLE Address(custId SMALLINT UNSIGNED NOT NULL,AddType VARCHAR(24),Street VARCHAR(50),POBox VARCHAR(20),PostalCode VARCHAR(20),Town VARCHAR(20),FOREIGN KEY (custId) REFERENCES Customers (custId))";
				st.executeUpdate(sqlAddress);
				System.out.println("Address table was created From xml file");
				// to create contact table with the foreign kay of customer
				String sqlContact = "CREATE TABLE Contact(custId SMALLINT UNSIGNED NOT NULL,Work_Phone VARCHAR(24),MOB_Phone VARCHAR(24),Work_Email VARCHAR(150),FOREIGN KEY (custId) REFERENCES Customers (custId))";
				st.executeUpdate(sqlContact);
				System.out.println("Contact table was created From xml file");

			}
			tables.close();

			con.close();
		} catch (Exception e) {
			System.out.println("Error in creating Customers table" + e);
		}

	}

}
