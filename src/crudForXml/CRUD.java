/*
 * This class is for inserting values, updating values, 
 * delating values,display selected values and display all values
 * It responds to the customers request
 *  
 */
package crudForXml;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	
	public static void insertCustomersDetail(String name,String addType,String street, String poBox,String postalCode,String town,String workPhone,String Mob,String email, String note) {
		//creatTable();
		dbConnection db = new dbConnection();
		Connection con = db.getConnection1();
        try {
        	PreparedStatement ps;
        	//using preparedStatement for sql query
        	//for inserting the values in customers table obtained from customer inputs and customer.java class from xml parsing
            ps = con.prepareStatement("insert into Customers values(?,?,?)");
            ps.setString(1, null);
            ps.setString(2, name);
            ps.setString(3, note);
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("Customers data Inserted");
                
            } else {
                System.out.println("not Inserted");
            }
            
            Statement st = con.createStatement();
            
            //for inserting the values in Address table from user input and xml parsing from customer.java class
            //getting the last entries id of cuatomers table and putting it in foreign key value
            st.executeUpdate("insert into Address values(LAST_INSERT_ID(),'"+addType+"','"+street+"','"+poBox+"','"+postalCode+"','"+town+"')");
            System.out.println("Address values inserted");
            //inserting values in contact table from customer input and xml parsing
            //saving customers id last entry as foreign kay
            st.executeUpdate("insert into Contact values(LAST_INSERT_ID(),'"+workPhone+"','"+Mob+"','"+email+"')");
            System.out.println("Contact values inserted");
            ps.close();
            st.close();
            con.close();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	public static void updateCustomer(String name,String addType,String street, String poBox,String postalCode,String town,String workPhone,String Mob,String email, String note, int custId) {
		dbConnection db = new dbConnection();
		Connection con = db.getConnection1();
		try {
        	Statement st = con.createStatement();
        	//Name VARCHAR(54),Note VARCHAR(100),PRIMARY KEY (custId)
        	//getting the values from users input
        	//updating the database with the entries
        	
        	st.executeUpdate("update Customers set Name ='"+name+"',Note = '"+note+"' where custId='"+custId+"'");
        	System.out.println("Customerst values update");
        	//AddType VARCHAR(24),Street VARCHAR(50),POBox VARCHAR(20),PostalCode VARCHAR(20),Town VARCHAR(20),FOREIGN KEY (custId) REFERENCES Customers (custId)
        	st.executeUpdate("update Address set AddType= '"+addType+"',Street='"+street+"',POBox='"+poBox+"',PostalCode='"+postalCode+"',Town='"+town+"' where custId='"+custId+"'");
            System.out.println("Address values updated");
          //Work_Phone VARCHAR(24),MOB_Phone VARCHAR(24),Work_Email VARCHAR(150),FOREIGN KEY (custId) REFERENCES Customers (custId)
            st.executeUpdate("update Contact set Work_Phone='"+workPhone+"',MOB_Phone='"+Mob+"',Work_Email='"+email+"' where custId='"+custId+"'");
            System.out.println("Contact values update");
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static void deleteCustomer(int custId) {
		dbConnection db = new dbConnection();
		Connection con = db.getConnection1();
        try {
        	Statement st = con.createStatement();
        	//for delete the data in tables with the same id
        	st.executeUpdate("delete from Address where custId='"+custId+"'");
        	st.executeUpdate("delete from Contact where custId='"+custId+"'");
        	st.executeUpdate("delete from Customers where custId='"+custId+"'");
        	
        	System.out.println("Customer with id '"+custId+"' deleted");
        	st.close();
        	con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static void dispAll() {
		dbConnection db = new dbConnection();
		Connection con = db.getConnection1();
        try {
            Statement st = con.createStatement();
            //using resaultset to display all the selected data
            //select every thing from Customers
            ResultSet res = st.executeQuery("select * from Customers");
            System.out.print("All Customers");
            while (res.next()) {
            	
            	System.out.print("\n");
            	System.out.print("ID:");
                System.out.print(res.getString(1));
                System.out.print(" Name:");
                System.out.print(res.getString(2));
                System.out.print(" Note:");
                System.out.print(res.getString(3));
                System.out.print("\n");
            }
            //select every thing from Address
            res = st.executeQuery("select * from Address");
            System.out.print("All Address");
            while (res.next()) {
            	System.out.print("\n");
            	System.out.print("ID:");
                System.out.print(res.getString(1));
                System.out.print(" Address Type:");
                System.out.print(res.getString(2));
                System.out.print(" Street:");
                System.out.print(res.getString(3));
                System.out.print(" POBox:");
                System.out.print(res.getString(4));
                System.out.print(" PostalCode:");
                System.out.print(res.getString(5));
                System.out.print(" Town:");
                System.out.print(res.getString(6));
                System.out.print("\n");
            }
            //select every thing from Contact
            res = st.executeQuery("select * from Contact");
            System.out.print("All Contact");
            while (res.next()) {
            	System.out.print("\n");
            	System.out.print("ID:");
                System.out.print(res.getString(1));
                System.out.print(" WorkPhone:");
                System.out.print(res.getString(2));
                System.out.print(" MobilePhone:");
                System.out.print(res.getString(3));
                System.out.print(" Email:");
                System.out.print(res.getString(4));
                
                System.out.print("\n");
                
            }
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public static void dispAnCustomer(int s) {
		dbConnection db = new dbConnection();
		Connection con = db.getConnection1();
        try {
        	Statement st = con.createStatement();
        	//display a customer from user selection
            ResultSet res = st.executeQuery("select * from Customers where custId='"+s+"'");
            System.out.print("A Customer"); 
            if (res.next()) {
            	System.out.print('\n');
            	System.out.print("Id:");
                System.out.print(res.getString(1));
                System.out.print(" Name:");
                System.out.print(res.getString(2));
                System.out.print(" Note:");
                System.out.print(res.getString(3));
                System.out.print('\n');
            }
            //display a customer from user selection
            res = st.executeQuery("select * from Address where custId='"+s+"'");
            System.out.print("A Customer Address"); 
            if (res.next()) {
            	System.out.print('\n');
            	System.out.print("Id:");
                System.out.print(res.getString(1));
                System.out.print(" Address Type:");
                System.out.print(res.getString(2));
                System.out.print(" Street:");
                System.out.print(res.getString(3));
                System.out.print(" POBox:");
                System.out.print(res.getString(4));
                System.out.print(" Postal Code:");
                System.out.print(res.getString(5));
                System.out.print(" Town:");
                System.out.print(res.getString(6));
                System.out.print('\n');
            }
            //display a customer from user selection
            res = st.executeQuery("select * from Contact where custId='"+s+"'");
            System.out.print("A Customer Contact"); 
            if (res.next()) {
            	System.out.print('\n');
            	System.out.print("Id:");
                System.out.print(res.getString(1));
                System.out.print(" Work Phone:");
                System.out.print(res.getString(2));
                System.out.print(" Mobile Phone:");
                System.out.print(res.getString(3));
                System.out.print(" Email:");
                System.out.print(res.getString(4));
                System.out.print('\n');
            }
            st.close();
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
