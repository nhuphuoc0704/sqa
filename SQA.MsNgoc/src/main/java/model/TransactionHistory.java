package model;

import java.io.Serializable;

public class TransactionHistory implements Serializable{
	private int id;
	private String time, description;
	private int value;
	private BankAccount destination;
	private BankPassbook source;
	public TransactionHistory(String time, String description, int value, BankAccount destination,
			BankPassbook source) {
		super();
		this.time = time;
		this.description = description;
		this.value = value;
		this.destination = destination;
		this.source = source;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public BankAccount getDestination() {
		return destination;
	}
	public void setDestination(BankAccount destination) {
		this.destination = destination;
	}
	public BankPassbook getSource() {
		return source;
	}
	public void setSource(BankPassbook source) {
		this.source = source;
	}
	
	
}
