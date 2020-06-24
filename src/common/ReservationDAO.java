package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Reservation;

public class ReservationDAO {
	private DataSource ds;
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;

	public ReservationDAO() {
		try {
//			Context context = new InitialContext();
//			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:375/sogongdo?useSSL=false", "admin", "test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Reservation> select() {
		ArrayList<Reservation> articles = new ArrayList<Reservation>();
		// sql �ڵ�
		
//		String sql = "SELECT * FROM reservation";
//		try {
//			conn = ds.getConnection();
//			rs = st.executeQuery(sql);
//			while (rs.next()) {
//				String id = rs.getString("id");
//				String userID = rs.getString("userID");
//				String workplaceID = rs.getString("workplaceID");
//				String facilityID = rs.getString("facilityID");
//				String date = rs.getString("date");
//				String people = rs.getString("people");
//				String payment = rs.getString("payment");
//				String cancelDate = rs.getString("cancelDate");
//				articles.add(new ReservationDTO(id, userID, facilityID, paymentID, date, people, payment, cancelDate));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		try {
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM reservation");
//		while(rs.next()) {
//			String id = rs.getString("id");
//			String userID = rs.getString("userID");
//			String workplaceID = rs.getString("workplaceID");
//			String facilityID = rs.getString("facilityID");
//			String date = rs.getString("date");
//			String people = rs.getString("people");
//			String payment = rs.getString("payment");
//			String cancelDate = rs.getString("cancelDate");
//			articles.add(new ReservationDTO(id, userID, workplaceID, facilityID, date, people, payment, cancelDate));
//		}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
		articles.add(new Reservation("1","2","3","4","2020-06-01","2020-06-03","7","2020-05-25", "2020-05-29"));
		return articles;
	}
}
