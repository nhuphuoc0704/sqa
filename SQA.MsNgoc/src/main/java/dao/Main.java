package dao;

import model.Customer;
import model.InternetBankAccount;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			InternetBankAccount i= new InternetBankAccount("0961754050", "1");
			System.out.println((new InternetAccountDAO()).checkLogin(i));
			System.out.println(i.getCustomer().getFullName());
	}

}
