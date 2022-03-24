package model;

import java.io.Serializable;

public class InternetBankAccount implements Serializable {
	private int id;
	private String username,password;
	private Customer customer;
	public InternetBankAccount(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
