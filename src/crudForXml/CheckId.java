/*
 * This class is to save id of table into array and 
 * check if the id provided by users exists
 */
package crudForXml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckId {
	boolean checkId = false;
	int j = 0;
	int rowCount = 0;

	public boolean Check(int id) throws SQLException {
		dbConnection db = new dbConnection();
		Connection con = db.getConnection1();
		Statement st = con.createStatement();
		// System.out.print(id);
		// using resaultset to display all data
		// to get the number of rows
		ResultSet res = st.executeQuery("select custId from Customers \n");
		// to get row count
		int count = 0;
		while (res.next()) {
			count++;
			// System.out.print(count);
		}
		// System.out.print(count);
		// declares an array of integers
		int[] anArray;
		// allocates memory for 10 integers
		anArray = new int[count];

		res = st.executeQuery("select custId from Customers \n");
		// to save id values in array
		while (res.next()) {
			anArray[j] = res.getInt(1);
			// System.out.print(anArray[j]);
			// System.out.print(j);
			j++;
		}
		// System.out.print(count);

		for (int i = 0; i < count; i++) {
			// System.out.print(i);
			if (id == anArray[i]) {
				// System.out.print("condition satisfied");
				checkId = true;
			}

		}
		res.close();
		con.close();
		return checkId;

	}

}
