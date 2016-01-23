/*
 * This is the customer object class
 * this class gets the data obtained from xml parsing
 * and send it to save these values into database
 */
package crudForXml;

public class Customer {
	CreateTable create = new CreateTable();
	CRUD crud = new CRUD();

	private String name;

	private String addType;

	private String street;

	private String poBox;

	private String postalCode;

	private String town;

	private String phoneType;

	private String phoneValue;

	private String MobType;

	private String MobValue;

	private String emailType;

	private String emailValue;

	private String note;

	private String type;

	public Customer() {

	}

	public Customer(String name, String addtype, String street, String poBox,
			String postalcode, String town, String phonetype,
			String phonevalue, String mobtype, String mobvalue,
			String emailtype, String emailvalue, String note, String type) {
		this.name = name;
		this.addType = addtype;
		this.street = street;
		this.poBox = poBox;
		this.postalCode = postalcode;
		this.town = town;
		this.phoneType = phonetype;
		this.phoneValue = phonevalue;
		this.phoneType = mobtype;
		this.phoneValue = mobvalue;
		this.emailType = emailtype;
		this.emailValue = emailvalue;
		this.note = note;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddType() {
		return addType;
	}

	public void setAddType(String addtype) {
		this.addType = addtype;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPoBox() {
		return poBox;
	}

	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalcode) {
		this.postalCode = postalcode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailtype) {
		this.emailType = emailtype;
	}

	public String getEmailValue() {
		return emailValue;
	}

	public void setEmailValue(String emailvalue) {
		this.emailValue = emailvalue;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phonetype) {
		this.phoneType = phonetype;
	}

	public String getPhoneValue() {
		return phoneValue;
	}

	public void setPhoneValue(String phonevalue) {
		this.phoneValue = phonevalue;
	}

	public String getMobType() {
		return MobType;
	}

	public void setMobType(String mobtype) {
		this.MobType = mobtype;
	}

	public String getMobValue() {
		return MobValue;
	}

	public void setMobValue(String mobvalue) {
		this.MobValue = mobvalue;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String toString() {
		create.creatTable();// to create the table
		// to insert the values from xml file to database
		CRUD.insertCustomersDetail(getName(), getAddType(), getStreet(),
				getPoBox(), getPostalCode(), getTown(), getPhoneValue(),
				getMobValue(), getEmailValue(), getNote());
		// to display the values from xml parsing
		StringBuffer sb = new StringBuffer();
		sb.append("Customers Details - ");
		sb.append("Name:" + getName());
		sb.append(", ");
		sb.append("Type:" + getType());
		sb.append(", ");
		sb.append("Address Type:" + getAddType());
		sb.append(", ");
		sb.append("Street:" + getStreet());
		sb.append(", ");
		sb.append("P.O.Box:" + getPoBox());
		sb.append(", ");
		sb.append("Postal Code:" + getPostalCode());
		sb.append(", ");
		sb.append("Town:" + getTown());
		sb.append(", ");
		sb.append("Phone Type:" + getPhoneType());
		sb.append(".");
		sb.append("Value:" + getPhoneValue());
		sb.append(", ");
		sb.append("Mobile Type:" + getMobType());
		sb.append(".");
		sb.append("Value:" + getMobValue());
		sb.append(", ");
		sb.append("Email Type:" + getEmailType());
		sb.append(".");
		sb.append("Value:" + getEmailValue());
		sb.append(", ");
		sb.append("Note:" + getNote());

		return sb.toString();
	}
}
