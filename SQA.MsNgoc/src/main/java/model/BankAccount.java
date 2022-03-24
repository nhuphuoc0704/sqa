package model;

import java.io.Serializable;

public class BankAccount implements Serializable {
	private int id;
	private String accountno,membersince,validthru,cardholder,cardtype,pincode;
	private int balances;
	private Customer customer;
	public BankAccount(String accountno, String membersince, String validthru, String cardholder, String cardtype,
			String pincode, int balances) {
		super();
		this.accountno = accountno;
		this.membersince = membersince;
		this.validthru = validthru;
		this.cardholder = cardholder;
		this.cardtype = cardtype;
		this.pincode = pincode;
		this.balances = balances;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getMembersince() {
		return membersince;
	}
	public void setMembersince(String membersince) {
		this.membersince = membersince;
	}
	public String getValidthru() {
		return validthru;
	}
	public void setValidthru(String validthru) {
		this.validthru = validthru;
	}
	public String getCardholder() {
		return cardholder;
	}
	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getBalances() {
		return balances;
	}
	public void setBalances(int balances) {
		this.balances = balances;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
