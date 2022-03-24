package model;

import java.io.Serializable;

public class BankPassbook implements Serializable {
	private int id;
	private String accountno, currency, startdate, enddate;
	private int deposits,issettlement;
	private Tenor tenor;
	private Customer cutomer;
	public BankPassbook(String accountno, String currency, String startdate, String enddate, int deposits,int issettlement) {
		super();
		this.accountno = accountno;
		this.currency = currency;
		this.startdate = startdate;
		this.enddate = enddate;
		this.deposits = deposits;
		this.issettlement=issettlement;
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getDeposits() {
		return deposits;
	}
	public void setDeposits(int deposits) {
		this.deposits = deposits;
	}
	public Tenor getTenor() {
		return tenor;
	}
	public void setTenor(Tenor tenor) {
		this.tenor = tenor;
	}
	public Customer getCutomer() {
		return cutomer;
	}
	public void setCutomer(Customer cutomer) {
		this.cutomer = cutomer;
	}
	public int getIssettlement() {
		return issettlement;
	}
	public void setIssettlement(int issettlement) {
		this.issettlement = issettlement;
	}
	
	
}	
