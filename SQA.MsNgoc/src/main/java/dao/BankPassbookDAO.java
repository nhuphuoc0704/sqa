package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.BankAccount;
import model.BankPassbook;
import model.Customer;
import model.Tenor;

public class BankPassbookDAO extends DAO{
	SimpleDateFormat sdf;
	public BankPassbookDAO() {
		super();
		sdf= new SimpleDateFormat("yyyy-MM-dd");
		// TODO Auto-generated constructor stub
	}
	public ArrayList<BankPassbook> getListBankPassbook(Customer c){
		
		ArrayList<BankPassbook> list= new ArrayList<BankPassbook>();
		String sql="{call get_list_passbook(?)}";
		CallableStatement ps;
		try {
			ps=con.prepareCall(sql);
			ps.setInt(1, c.getId());
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int id= rs.getInt("id");
				String accountno= rs.getString("accountno");
				String currency= rs.getString("currency");
				int deposits= rs.getInt("deposits");
				String startdate=sdf.format(rs.getDate("startdate"));
				String enddate=sdf.format(rs.getDate("enddate"));
				int issettlement= rs.getInt("issettlement");
				BankPassbook  b= new BankPassbook(accountno, currency, startdate, enddate, deposits,issettlement);
				b.setId(id);
				b.setCutomer(c);
				id=rs.getInt("id_tenor");
				String unit=rs.getString("unit");
				float interestrate= rs.getFloat("interestrate");
				int value=rs.getInt("value");
				Tenor t= new Tenor(value, interestrate, unit);
				t.setId(id);
				b.setTenor(t);
				list.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public BankAccount getBankAccount(Customer c) {
		String sql="select * from tblbankaccount where customer=?";
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				int id= rs.getInt("id");
				String accountno=rs.getString("accountno");
				String membersince=sdf.format(rs.getDate("membersince"));
				String validthru= sdf.format(rs.getDate("validthru"));
				String cardholder= rs.getString("cardholder");
				String cardtype= rs.getString("cardtype");
				String pincode=rs.getString("pincode");
				int balance= rs.getInt("balances");
				BankAccount b= new BankAccount(accountno, membersince, validthru, cardholder, cardtype, pincode, balance);
				b.setId(id);
				b.setCustomer(c);
				return b;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public int getRatePassbook(BankPassbook passbook) {
		int rate=0;
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		try {
		Calendar calendar= Calendar.getInstance();
		Date now= calendar.getTime();
		Date start=sdf.parse(passbook.getStartdate());
		long diff= now.getTime()-start.getTime();
		long sng = diff / (24 * 60 * 60 * 1000); // Số ngày đã gửi tiền trong sổ tiết kiệm tính đến ngày tất toán

		 calendar.setTime(start);
		 calendar.add(Calendar.MONTH,passbook.getTenor().getValue());
		 Date ndh= calendar.getTime(); // Ngày đến hạn tất toán trong hợp đồng sổ tiết kiệm
		 
		 diff= ndh.getTime()-start.getTime();
		 long sncg= diff / (24 * 60 * 60 * 1000);// Số ngày cần gửi đến khi đến hạn tất toán
		 
		 if(sng>=sncg){
			 long bonus= sng-sncg;
			 rate= Math.round(passbook.getDeposits()*passbook.getTenor().getInterestRate()*sncg/(360*100)) ;
			 int rateBonus=Math.round((passbook.getDeposits()+rate)*1*bonus/(360*100));
			 rate+=rateBonus;
		 }
		 else {
			 rate= Math.round(passbook.getDeposits()*sng*1/(360*100));
		 }
		 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rate;
	}
}
