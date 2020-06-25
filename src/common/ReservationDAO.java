package common;

import java.sql.*;
import java.util.ArrayList;

import model.Reservation;

import javax.naming.NamingException;

public class ReservationDAO {

	public ArrayList<Reservation> readReservation() {
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		String sql = "SELECT * FROM db.Reservation";
		try (
				Connection conn = DataBase.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
		)	{
			
			while (rs.next())
				list.add( new Reservation(
						rs.getString("Reservation_id"),
						rs.getString("User_id"),
						rs.getString("Facility_id"),
						rs.getString("Payment_id"),
						rs.getString("startDate"),
						rs.getString("endDate"),
						rs.getString("people"),
						rs.getString("registerDate"),
						rs.getString("cancelDate")));
			
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void createReservation(Reservation r) {
		String sql = "insert into db.Reservation values (?,?,?,?,?,?,?,?,?)";

		try (
				Connection conn = DataBase.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
		)	{
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

		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

	public void updateReservation(Reservation r) {
		String sql = "update db.Reservation set startDate = ?, endDate = ?, people = ?, registerDate = ? where Reservation_id = ?";
		try (
				Connection conn = DataBase.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
		)	{
			pst.setString(1, r.getStartDate());
			pst.setString(2, r.getEndDate());
			pst.setString(3, r.getPeople());
			pst.setString(4, r.getRegisterDate());
			pst.setInt(5, Integer.parseInt(r.getId()));
			pst.executeUpdate();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

	public void deleteReservation(String reservationID) {
		String sql = "delete from db.Reservation where Reservation_id = ?";
		try (
				Connection conn = DataBase.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
		)	{
			pst.setString(1, reservationID);
			pst.executeUpdate();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

	public void updateReservationCancel(String reservationID, String cancelDate) {
		String sql = "update db.Reservation set cancelDate = ? where Reservation_id = ?";
		try (
				Connection conn = DataBase.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
		)	{
			pst.setString(1, cancelDate);
			pst.setString(2, reservationID);
			pst.executeUpdate();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

	public void deleteReservationCancel(String reservationID) {
		updateReservationCancel(reservationID, "");
	}
}
