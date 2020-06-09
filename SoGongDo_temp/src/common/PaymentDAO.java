package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.*;

public class PaymentDAO {
	private DataSource ds;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public PaymentDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");		
			conn = null;
			st = null;
			pst = null;
			rs = null;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public Boolean searchReservation(String id) {
		String sql = "SELECT * FROM db.Reservation where id=?";
		
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			rs.last();
			
			if(rs.getRow() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public int searchPayment(String reservationID)
	{
		String sql = "SELECT fee FROM db.ReservationPayment where Reservation_id=?";
		
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, reservationID);
			rs = pst.executeQuery();
			
			rs.last();
			
			if(rs.getRow() != 0)
			{
				int fee = rs.getInt("fee");
				
				return fee;
			}
			else
				return -1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public void createPayment(String reservationID, int fee)
	{		
		String sql1 = "SELECT User_id FROM db.Reservation where id=?";
		String sql2 = "insert into db.ReservationPayment(User_id, saleDate, Reservation_id, fee) values (?,?,?,?)";

		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			pst = conn.prepareStatement(sql1);
			pst.setString(1, reservationID);
			rs = pst.executeQuery();
			
			rs.last();
			
			if(rs.getRow() != 0)
			{
				String User_id = rs.getString("User_id");
				
				pst = conn.prepareStatement(sql2);
				pst.setString(1, User_id);
				pst.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
				pst.setString(3, reservationID);
				pst.setInt(4, fee);
				pst.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	public void updatePayment(String reservationID, int fee)
	{
		String sql = "update db.ReservationPayment set fee = ? where Reservation_id = ?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st = conn.createStatement();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, fee);
			pst.setString(2, reservationID);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deletePayment(String reservationID)
	{
		String sql = "delete from db.ReservationPayment where Reservation_id = ?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st = conn.createStatement();
			pst = conn.prepareStatement(sql);
			pst.setString(1, reservationID);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<ReservationPayment> readPayment()
	{
		ArrayList<ReservationPayment> list = new ArrayList<ReservationPayment>();
		String sql = "SELECT * FROM db.ReservationPayment where cancelDate is null";
		
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				String userID = rs.getString("User_id");
				LocalDateTime saleDate = rs.getTimestamp("saleDate").toLocalDateTime();
				String reservationID = rs.getString("Reservation_id");
				int fee = rs.getInt("fee");
				ReservationPayment reservationpayment = new ReservationPayment(userID, saleDate, reservationID, fee);
				list.add(reservationpayment);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
