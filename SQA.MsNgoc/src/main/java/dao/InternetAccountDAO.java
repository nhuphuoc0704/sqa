package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.Customer;
import model.InternetBankAccount;

public class InternetAccountDAO extends DAO{

	public InternetAccountDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean checkLogin(InternetBankAccount i) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String sql="{call check_login(?,?)}";
		CallableStatement ps;
		try {
			ps = con.prepareCall(sql);
			ps.setString(1, i.getUsername());
			ps.setString(2,i.getPassword());
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				int id= rs.getInt("id_account");
				i.setId(id);
				id=rs.getInt("id");
				String fullname=rs.getString("fullname");
				String gender=rs.getString("gender");
				String address= rs.getString("address");
				String tel= rs.getString("tel");
				String CCCD= rs.getString("CCCD");
				String dob= sdf.format(rs.getDate("dob"));
				Customer c= new Customer(fullname, dob, gender, address, CCCD, tel, dob);
				c.setId(id);
				i.setCustomer(c);
				return true;
			}
			else return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
