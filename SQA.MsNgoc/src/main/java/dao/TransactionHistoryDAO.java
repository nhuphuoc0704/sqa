package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.TransactionHistory;

public class TransactionHistoryDAO extends DAO{

	public TransactionHistoryDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean addTransaction(TransactionHistory t) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String sql= "insert into tbltransactionhistory (time,value,description,source,destination) value (?,?,?,?,?)";
		boolean kq=false;
		try {
			this.con.setAutoCommit(false);
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, t.getTime());
			ps.setInt(2, t.getValue());
			ps.setString(3, t.getDescription());
			ps.setInt(4, t.getSource().getId());
			ps.setInt(5, t.getDestination().getId());
			ps.executeUpdate();
			
			sql= "update tblbankaccount set balances=? where id=?";
			ps= con.prepareStatement(sql);
			ps.setInt(1, t.getDestination().getBalances()+t.getValue());
			ps.setInt(2, t.getDestination().getId());
			ps.executeUpdate();
			
			sql= "update tblbankpassbook set issettlement=1 where id=?";
			ps= con.prepareStatement(sql);
			ps.setInt(1, t.getSource().getId());
			ps.executeUpdate();
					
					
			this.con.commit();
			kq=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				kq=false;
				
			}
			e.printStackTrace();
		}finally {
			try {
				this.con.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				kq=false;
			
			}
		}
		
		return kq;
	}
}
