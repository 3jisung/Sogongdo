package common;

import model.ReservationPayment;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RefundDAO {
    private DataSource ds;
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public RefundDAO() {
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

            if (rs.getRow() != 0)
                return true;
            else
                return false;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public Boolean searchRefund(String reservationID) {
        String sql = "SELECT * FROM db.ReservationPayment where Reservation_id=?";

        try {
            conn = ds.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, reservationID);
            rs = pst.executeQuery();

            rs.next();
            Object ob = rs.getTimestamp("cancelDate");
            if (ob != null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public int searchPayment(String reservationID) {
        String sql = "SELECT fee FROM db.ReservationPayment where Reservation_id=?";

        try {
            conn = ds.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, reservationID);
            rs = pst.executeQuery();
            rs.next();
            if (rs.getRow() != 0) {
                int fee = rs.getInt("fee");
                return fee;
            } else
                return -1;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }


    public void createRefund(String reservationID) {
        String sql = "update db.ReservationPayment set cancelDate = ? where Reservation_id = ?";

        try {
            conn = ds.getConnection();
            st = conn.createStatement();
            pst = conn.prepareStatement(sql);
            pst.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            pst.setString(2, reservationID);
            pst.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void updateRefund(String reservationID) {
        String sql = "update db.ReservationPayment set cancelDate = ? where Reservation_id = ?";
        try {
            conn = ds.getConnection();
            st = conn.createStatement();
            pst = conn.prepareStatement(sql);
            pst.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            pst.setString(2, reservationID);
            pst.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void deleteRefund(String reservationID) {
        String sql = "update db.ReservationPayment set cancelDate = ? where Reservation_id = ?";
        try {
            conn = ds.getConnection();
            st = conn.createStatement();
            pst = conn.prepareStatement(sql);
            pst.setTimestamp(1, null);
            pst.setString(2, reservationID);
            pst.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public ArrayList<ReservationPayment> readRefund() {
        ArrayList<ReservationPayment> list = new ArrayList<ReservationPayment>();
        String sql = "SELECT * FROM db.ReservationPayment where cancelDate is not null";

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
                reservationpayment.setCancelDate(rs.getTimestamp("cancelDate").toLocalDateTime());
                list.add(reservationpayment);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}
