/*
 * This class if for editing the customers details
 * to edit only the required details
 */
package crudForXml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EditCustomer {

	public static void Edit(String name, String addType, String street,
			String poBox, String postalCode, String town, String workPhone,
			String Mob, String email, String note, int custId)
			throws SQLException {
		dbConnection db = new dbConnection();
		Connection con = db.getConnection1();

		String[] anArray;
		// allocates memory for 10 integers
		anArray = new String[10];
		Statement st = con.createStatement();
		// using resaultset to display all the selected data
		// select every thing from Customers
		if (name.equalsIgnoreCase("no")) {
			// System.out.print("Select Customers name for id "+custId+" \n");
			ResultSet res = st
					.executeQuery("select Name from Customers where custId='"
							+ custId + "'");
			while (res.next()) {// Since in odbc we are suppose to read all
								// values
				// System.out.print(" Name:");
				// System.out.print(res.getString(1));
				anArray[0] = res.getString(1);
			}
			res.close();
		} else {
			anArray[0] = name;
		}
		// System.out.print(anArray[0]);
		if (note.equalsIgnoreCase("no")) {
			ResultSet res = st
					.executeQuery("select Note from Customers where custId='"
							+ custId + "'");
			// System.out.print("Select Customers note for id "+custId+"");
			while (res.next()) {
				// System.out.print(" Note:");
				// System.out.print(res.getString(1));
				anArray[1] = res.getString(1);
			}
			res.close();
		} else {
			anArray[1] = note;
		}
		// System.out.print(anArray[1]);
		if (addType.equalsIgnoreCase("no")) {
			ResultSet res = st
					.executeQuery("select AddType from Address where custId='"
							+ custId + "'");
			// System.out.print("Select Address addtype for id "+custId+"");
			while (res.next()) {
				// System.out.print(" AddType:");
				// System.out.print(res.getString(1));
				anArray[2] = res.getString(1);
			}
			res.close();
		} else {
			anArray[2] = addType;
		}
		// System.out.print(anArray[2]);
		if (street.equalsIgnoreCase("no")) {
			ResultSet res = st
					.executeQuery("select Street from Address where custId='"
							+ custId + "'");
			// System.out.print("Select Address addtype for id "+custId+"");
			while (res.next()) {
				// System.out.print(" Street:");
				// System.out.print(res.getString(1));
				anArray[3] = res.getString(1);
			}
			res.close();
		} else {
			anArray[3] = street;
		}
		// System.out.print(anArray[3]);
		if (poBox.equalsIgnoreCase("no")) {
			ResultSet res = st
					.executeQuery("select POBox from Address where custId='"
							+ custId + "'");
			// System.out.print("Select Address poBox for id "+custId+"");
			while (res.next()) {
				// System.out.print(" POBox:");
				// System.out.print(res.getString(1));
				anArray[4] = res.getString(1);
			}
			res.close();
		} else {
			anArray[4] = poBox;
		}
		// System.out.print(anArray[4]);
		if (postalCode.equalsIgnoreCase("no")) {
			ResultSet res = st
					.executeQuery("select PostalCode from Address where custId='"
							+ custId + "'");
			// System.out.print("Select Address postalCode for id "+custId+"");
			while (res.next()) {
				// System.out.print(" PostalCode:");
				// System.out.print(res.getString(1));
				anArray[5] = res.getString(1);
			}
			res.close();
		} else {
			anArray[5] = postalCode;
		}
		// System.out.print(anArray[5]);
		if (town.equalsIgnoreCase("no")) {
			ResultSet res = st
					.executeQuery("select Town from Address where custId='"
							+ custId + "'");
			// System.out.print("Select Address addtype for id "+custId+"");
			while (res.next()) {
				// System.out.print(" Town:");
				// System.out.print(res.getString(1));
				anArray[6] = res.getString(1);
			}
			res.close();
		} else {
			anArray[6] = town;
		}
		// System.out.print(anArray[6]);
		if (workPhone.equalsIgnoreCase("no")) {
			ResultSet res = st
					.executeQuery("select Work_Phone from Contact where custId='"
							+ custId + "'");
			// System.out.print("Select Contact workPhone for id "+custId+"");
			while (res.next()) {
				// System.out.print(" WorkPhone:");
				// System.out.print(res.getString(1));
				anArray[7] = res.getString(1);
			}
			res.close();
		} else {
			anArray[7] = workPhone;
		}
		// System.out.print(anArray[7]);
		if (Mob.equalsIgnoreCase("no")) {
			ResultSet res = st
					.executeQuery("select MOB_Phone from Contact where custId='"
							+ custId + "'");
			// System.out.print("Select Contact mob_phone for id "+custId+"");
			while (res.next()) {
				// System.out.print(" Mob:");
				// System.out.print(res.getString(1));
				anArray[8] = res.getString(1);
			}
			res.close();
		} else {
			anArray[8] = Mob;
		}
		// System.out.print(anArray[8]);
		if (email.equalsIgnoreCase("no")) {
			ResultSet res = st
					.executeQuery("select Work_Email from Contact where custId='"
							+ custId + "'");
			// System.out.print("Select Contact email for id "+custId+"");
			while (res.next()) {
				// System.out.print(" email:");
				// System.out.print(res.getString(1));
				anArray[9] = res.getString(1);
			}
			res.close();
		} else {
			anArray[9] = email;
		}
		// System.out.print(anArray[9]);
		System.out.print("\n");
		CRUD.updateCustomer(anArray[0], anArray[2], anArray[3], anArray[4],
				anArray[5], anArray[6], anArray[7], anArray[8], anArray[9],
				anArray[1], custId);
		st.close();
		con.close();
	}

}
