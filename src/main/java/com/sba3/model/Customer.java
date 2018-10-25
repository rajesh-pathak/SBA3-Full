package com.sba3.model;

/*************************/
/*************************/
/*************************/
/*   First Change        */
/*     Made Here		 */
/*************************/
/*************************/
/*************************/



public class Customer {

	private int id;
	private String name;
	private String doj;
	private String city;
	private String contact;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, String name, String doj, String city, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.doj = doj;
		this.city = city;
		this.contact = contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
