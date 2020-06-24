package common;

import java.sql.*;
import java.util.ArrayList;

import model.Reservation;

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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Reservation searchReservation(String id) {
		Reservation r = null;
		String sql = "SELECT * FROM db.Reservation WHERE Reservation_id = '" + id + "'";
		try (
				Connection conn = DataBase.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
		)	{
			
			if (rs.next())
				r = new Reservation(
						rs.getString("Reservation_id"),
						rs.getString("User_id"),
						rs.getString("Facility_id"),
						rs.getString("Payment_id"),
						rs.getString("startDate"),
						rs.getString("endDate"),
						rs.getString("people"),
						rs.getString("registerDate"),
						rs.getString("cancelDate"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	public void createReservation(Reservation r) {
		String sql = "insert into db.Reservation values (?,?,?,?,?,?,?,?,?)";

		try (
				Connection conn = DataBase.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
		)	{
			// auto increment
			pst.setString(1, null);
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

	public void updateReservation(String id, String startDate, String endDate, String people, String registerDate) {
		String sql = "update db.Reservation set startDate = ?, endDate = ?, people = ?, registerDate = ? where Reservation_id = ?";
		try (
				Connection conn = DataBase.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
		)	{
			pst.setString(1, startDate);
			pst.setString(2, endDate);
			pst.setString(3, people);
			pst.setString(4, registerDate);
			pst.setInt(5, Integer.parseInt(id));
			pst.executeUpdate();
		} catch (SQLException e) {
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
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteReservationCancel(String reservationID) {
		updateReservationCancel(reservationID, "");
	}
}
