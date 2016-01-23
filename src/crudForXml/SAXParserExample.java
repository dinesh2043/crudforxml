/*
 * This class is for XML Parsing 
 * After getting the required values from XML parsing
 * this class send it to Customer.java class to save it to the database
 * Here I have used SAXParser because of its efficiency since it is fast 
 */
package crudForXml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample extends DefaultHandler {

	List<Customer> myCusts;

	private String tempVal;

	// to maintain context
	private Customer tempCust;
	// since inside child elements address, workphone, phone and email we have
	// grand child elements
	// so to control the xml parsing we need some bool variables
	boolean address = false;
	boolean workPhone = false;
	boolean Phone = false;
	boolean email = false;

	public SAXParserExample() {
		myCusts = new ArrayList<Customer>();

	}

	public void runExample() {
		parseDocument();
		printData();
	}

	private void parseDocument() {

		// get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {

			// get a new instance of parser
			SAXParser sp = spf.newSAXParser();

			// parse the file and also register this class for call backs
			sp.parse("src/crudForXml/customers.xml", this);

		} catch (SAXException se) {
			se.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * Iterate through the list and print the contents
	 */
	private void printData() {

		System.out.println("No of Customer '" + myCusts.size() + "'.");

		Iterator<Customer> it = myCusts.iterator();

		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

	}

	// Event Handlers
	// to parse the start element tag of xml file

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// reset
		tempVal = "";
		// System.out.println("Start Element :" + qName); //to print the start
		// of an element
		if (qName.equalsIgnoreCase("Customer")) {
			// create a new instance of customer
			tempCust = new Customer();
			tempCust.setType(attributes.getValue("xmlns"));
		}
		// when we find the start tag of child element we set bool value to true
		// then we can save the values of grand child element
		if (qName.equalsIgnoreCase("Address")) {
			address = true;
			// System.out.println("Address bool value :" + address);
		}
		if (qName.equalsIgnoreCase("workPhone")) {
			workPhone = true;
			// System.out.println("WorkPhone bool value :" + workPhone);
		}
		if (qName.equalsIgnoreCase("Email")) {
			email = true;
			// System.out.println("Email bool value :" + email);
		}
		if (qName.equalsIgnoreCase("Phone")) {
			Phone = true;
			// System.out.println("Phone bool value :" + Phone);
		}

	}

	// to store the values inside the tag
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		tempVal = new String(ch, start, length);
		// System.out.println("Value of Element :" + tempVal);
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// System.out.println("End Element :" + qName); //to print end of an
		// element
		if (qName.equalsIgnoreCase("Customer")) {
			// add it to the list
			myCusts.add(tempCust);

		} else if (qName.equalsIgnoreCase("Name")) {
			tempCust.setName(tempVal);
			// Here we check that if the tag is grand child element of child
			// element address
			// and is it inside the child element address
		} else if (qName.equalsIgnoreCase("addType") && address == true) {
			tempCust.setAddType(tempVal);
		} else if (qName.equalsIgnoreCase("Street") && address == true) {
			tempCust.setStreet(tempVal);
		} else if (qName.equalsIgnoreCase("poBox") && address == true) {
			tempCust.setPoBox(tempVal);
		} else if (qName.equalsIgnoreCase("PostalCode") && address == true) {
			tempCust.setPostalCode(tempVal);
		} else if (qName.equalsIgnoreCase("Town") && address == true) {
			tempCust.setTown(tempVal);
			// when we find end tag of child element address we set the bool
			// value of address to false
		} else if (qName.equalsIgnoreCase("Address")) {
			address = false;
			// Here we check that if the tag is grand child element of child
			// element Work phone
			// and is it inside the child element Work Phone
		} else if (qName.equalsIgnoreCase("Type") && workPhone == true) {
			tempCust.setPhoneType(tempVal);
		} else if (qName.equalsIgnoreCase("Value") && workPhone == true) {
			tempCust.setPhoneValue(tempVal);
			// when we find end tag of child element Workphone we set the bool
			// value of WorkPhone to false
		} else if (qName.equalsIgnoreCase("WorkPhone")) {
			workPhone = false;
			// here we check for email
		} else if (qName.equalsIgnoreCase("Type") && email == true) {
			tempCust.setEmailType(tempVal);
		} else if (qName.equalsIgnoreCase("Value") && email == true) {
			tempCust.setEmailValue(tempVal);
			// set email value to false
		} else if (qName.equalsIgnoreCase("Email")) {
			email = false;
			// Here we check for phone
		} else if (qName.equalsIgnoreCase("Type") && Phone == true) {
			tempCust.setMobType(tempVal);
		} else if (qName.equalsIgnoreCase("Value") && Phone == true) {
			tempCust.setMobValue(tempVal);
			// give the false to email
		} else if (qName.equalsIgnoreCase("Phone")) {
			Phone = false;
		} else if (qName.equalsIgnoreCase("Notes")) {
			tempCust.setNote(tempVal);
		}

	}

}
