/*
 * This class is for user inter-action
 * User interface is available in the console window
 * there are 7 options for custommer management 
 * we can use all these options typing the appropiate options in the console window 
 * after typing we should enter to see the resault
 * Since I was not suppose to make the application production ready so there is no
 * error handeling and I have console as user interface
 * So, if we type some thing wrong it doesnot shows error message to retype
 */
package crudForXml;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInterface {

	static int i = 0;// for loading xml file once
	static int j = 0;// to get last customers id
	static int k = 0;// for loading instruction only once

	// static CRUD crud = new CRUD();
	public static void main(String[] args) {
		try {
			// to get the input from the user

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int ch = 0;
			while (true) {
				if (k == 0) {
					System.out
							.println("*****IMPORTENT SELECT LOAD AND SAVE XML OPTION FROM CUSTOMER MANAGEMENT LIST FIRST TO RUN THIS APPLICATION******");
					System.out
							.println(" Click the console window and type the number of options from Customer Management and press Enter ");
					System.out.println("      Scroll to see the results ");
					System.out.println("Customer management \n "
							+ "1. Load and Save Xml \n "
							+ "2. Add Customer \n " + "3. Edit Customer \n "
							+ "4. Delete Customer \n "
							+ "5. Display all record \n "
							+ "6. Display a record \n " + "7. Exit"
							+ "Enter option \n");
					k++;
				} else {
					System.out
							.print("****Type a number of option from CUSTOMER MANAGEMENT LIST ABOVE **** \n");
				}
				String str1 = br.readLine().toString();
				ch = Integer.parseInt(str1);
				switch (ch) {
				case 1: {
					if (i == 0) {// to load xml file only once when we run the
						// application
						SAXParserExample spe = new SAXParserExample();
						// to parse XML file and save the data in database after
						// creating tables
						spe.runExample();
						i++;
					} else {
						System.out.print("Can load XML File only once \n");
					}
					break;
				}
				case 2: {
					if (i > 0) {
						// String name,String addType,String street, String
						// poBox,String postalCode,
						// String town,String workPhone,String Mob,String email,
						// String note)
						System.out.println("Enter Customer Name \n");
						String name = br.readLine();
						System.out.println("Enter Customer Address Type \n");
						String addType = br.readLine();
						System.out.println("Enter Customer street \n");
						String street = br.readLine();
						System.out.println("Enter Customer poBox \n");
						String poBox = br.readLine();
						System.out.println("Enter Customer postalCode \n");
						String postalCode = br.readLine();
						System.out.println("Enter Customer town \n");
						String town = br.readLine();
						System.out.println("Enter Customer workPhone \n");
						String workPhone = br.readLine();
						System.out.println("Enter Customer Mobile \n");
						String Mob = br.readLine();
						System.out.println("Enter Customer email \n");
						String email = br.readLine();
						System.out.println("Enter Customer note \n");
						String note = br.readLine();
						// Calling method insertCustomersDetail
						CRUD.insertCustomersDetail(name, addType, street,
								poBox, postalCode, town, workPhone, Mob, email,
								note);
					} else {
						System.out.print("FIRST LOAD AND SAVE XML FILE \n");
					}
					break;
				}
				case 3: {
					if (i > 0) {
						// System.out.print(j);
						System.out.println("Type Customer custId to update \n");
						String cust = br.readLine();
						int custId = Integer.parseInt(cust);// convert string to
						// int
						CheckId check = new CheckId();// to send id value to CheckId.java
						check.Check(custId);// sending value of id to check
						// System.out.print(check.checkId);
						// to check if the id provided by user exists from
						// CheckId.java class
						if (check.checkId == true) {
							System.out
									.println("IF YOU WANT TO EDIT type Customer Name ELSE type NO \n");
							String name = br.readLine();
							System.out
									.println("IF YOU WANT TO EDIT type Customer addType ELSE type NO \n");
							String addType = br.readLine();
							System.out
									.println("IF YOU WANT TO EDIT type Customer street ELSE type NO \n");
							String street = br.readLine();
							System.out
									.println("IF YOU WANT TO EDIT type Customer poBox ELSE type NO \n");
							String poBox = br.readLine();
							System.out
									.println("IF YOU WANT TO EDIT type Customer postalCode ELSE type NO \n");
							String postalCode = br.readLine();
							System.out
									.println("IF YOU WANT TO EDIT type Customer town ELSE type NO \n");
							String town = br.readLine();
							System.out
									.println("IF YOU WANT TO EDIT type Customer workPhone ELSE type NO  \n");
							String workPhone = br.readLine();
							System.out
									.println("IF YOU WANT TO EDIT type Customer Mobile ELSE type NO \n");
							String Mob = br.readLine();
							System.out
									.println("IF YOU WANT TO EDIT type Customer email ELSE type NO \n");
							String email = br.readLine();
							System.out
									.println("IF YOU WANT TO EDIT type Customer note ELSE type NO \n");
							String note = br.readLine();
							// con.close();
							// calling method updateCustomer
							// CRUD.updateCustomer(name, addType, street,
							// poBox,postalCode, town, workPhone, Mob,
							// email,note, custId);
							EditCustomer.Edit(name, addType, street, poBox,
									postalCode, town, workPhone, Mob, email,
									note, custId);
						} else {
							System.out
									.println("ERROR Type existing Id value \n");
						}
					} else {
						System.out.print("FIRST LOAD AND SAVE XML FILE \n");
					}
					break;
				}
				case 4: {
					if (i > 0) {
						System.out
								.println("Enter Customer custId to delete \n");
						String cust = br.readLine();
						int custId = Integer.parseInt(cust);// convert string to
						// int
						CheckId check1 = new CheckId();// to send id value to
														// CheckId.java
						check1.Check(custId);// sending value of id to check
						if (check1.checkId == true) {
							// calling method deleteCustomer
							CRUD.deleteCustomer(custId);
						} else {
							System.out
									.println("ERROR Type existing Id value \n");
						}
					} else {
						System.out.print("FIRST LOAD AND SAVE XML FILE");
					}

					break;
				}
				case 5: {
					if (i > 0) {
						CRUD.dispAll();
					} else {
						System.out.print("FIRST LOAD AND SAVE XML FILE \n");
					}
					break;
				}
				case 6: {
					if (i > 0) {
						System.out
								.println("Enter Customer Id to display record \n");
						String cust = br.readLine();
						int custId = Integer.parseInt(cust);
						CheckId check2 = new CheckId();// to acess the return
														// value of CheckId.java
						check2.Check(custId);// sending value of id to check

						if (check2.checkId == true) {
							// Calling method dispAnCustomer
							CRUD.dispAnCustomer(custId);
						} else {
							System.out
									.println("ERROR Type existing Id value  \n");
						}
					} else {
						System.out.print("FIRST LOAD AND SAVE XML FILE \n");
					}
					break;
				}
				case 7: {
					System.exit(0);
				}

				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
