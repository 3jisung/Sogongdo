package common;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Reservation;

public class ReservationDAO {
	private DataSource ds;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ReservationDAO() {
	        try {
	            Context context = new InitialContext();
	            ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
	            conn = null;
	            st = null;
	            pst = null;
	            rs = null;
	        } catch (NamingException e) {
	            e.printStackTrace();
	        }
	    }

	public ArrayList<Reservation> readReservation() {
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		String sql = "SELECT * FROM db.Reservation";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String reservationID = rs.getString("Reservation_id");
				String userID = rs.getString("User_id");
				String facilityID = rs.getString("User_id");
				String paymentID = rs.getString("User_id");
				String startDate = rs.getString("User_id");
				String endDate = rs.getString("User_id");
				String people = rs.getString("User_id");
				String registerDate = rs.getString("User_id");
				String cancelDate = rs.getString("User_id");
				
				Reservation reservation = new Reservation(reservationID, userID, facilityID, paymentID,
						startDate, endDate, people, registerDate, cancelDate);
				list.add(reservation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void createReservation(Reservation r) {
		String sql = "insert into db.Reservation(Reservation_id, User_id, Facility_id, Payment_id,"
				+ " startDate, endDate, people, registerDate, cancelDate)"
				+ " values (?,?,?,?,?,?,?,?,?)";

		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			pst = conn.prepareStatement(sql);
			// auto increment
			pst.setInt(1, (Integer) null);
			pst.setString(2, r.getUserID());
			pst.setString(3, r.getFacilityID());
			pst.setString(4, r.getPaymentID());
			pst.setString(5, r.getStartDate());
			pst.setString(6, r.getEndDate());
			pst.setString(7, r.getPeople());
			pst.setString(8, r.getRegisterDate());
			pst.setString(9, r.getCancelDate());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateReservation(Reservation r) {
		String sql = "update db.ReservationPayment set startDate = ?, endDate = ?, people = ?, registerDate = ?, where Reservation_id = ?";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			pst = conn.prepareStatement(sql);
			pst.setString(1, r.getStartDate());
			pst.setString(2, r.getEndDate());
			pst.setString(3, r.getPeople());
			pst.setString(4, r.getRegisterDate());
			pst.setInt(5, Integer.parseInt(r.getId()));
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteReservation(String reservationID) {
		String sql = "delete from db.ReservationPayment where Reservation_id = ?";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			pst = conn.prepareStatement(sql);
			pst.setString(1, reservationID);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateReservationCancel(String reservationID, String cancelDate) {
		String sql = "update db.ReservationPayment set cancelDate = ? where Reservation_id = ?";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			pst = conn.prepareStatement(sql);
			pst.setString(1, cancelDate);
			pst.setString(2, reservationID);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteReservationCancel(String reservationID) {
		updateReservationCancel(reservationID, "");
	}
}
