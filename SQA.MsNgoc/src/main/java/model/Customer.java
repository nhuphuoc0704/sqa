package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{
	private int id;
	private String fullName,dob,gender, address, CCCD, tel,nationality;
	private ArrayList<BankPassbook> listBankPassbook;
	private BankAccount bankAccount;
	public Customer(String fullName, String dob, String gender, String address, String cCCD, String tel,
			String nationality) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		CCCD = cCCD;
		this.tel = tel;
		this.nationality = nationality;
		listBankPassbook= new ArrayList<BankPassbook>();
		bankAccount=null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public ArrayList<BankPassbook> getListBankPassbook() {
		return listBankPassbook;
	}
	public void setListBankPassbook(ArrayList<BankPassbook> listBankPassbook) {
		this.listBankPassbook = listBankPassbook;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	

}
