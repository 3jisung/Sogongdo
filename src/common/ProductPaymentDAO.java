package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ProductPayment;


public class ProductPaymentDAO {
	
	private DataSource ds;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ProductPaymentDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
			conn = null;
			st = null;
			rs = null;
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/*구매내역확인*/
	public ArrayList<ProductPayment> read() {
		String sql = "SELECT * FROM ProductPayment";
		ArrayList<ProductPayment> list = new ArrayList<ProductPayment>();
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String ProductPackage_name = rs.getString("ProductPackage_name");
				String User_id = rs.getString("User_id");
				Integer quantity = rs.getInt("quantity");
				LocalDateTime saleDate = rs.getTimestamp("saleDate").toLocalDateTime();
				 ProductPayment instance = new ProductPayment(ProductPackage_name, User_id, quantity, saleDate);
				list.add(instance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*상품구매*/
	public boolean createProductPayment(String ProductPackage_name, String User_id, int quantity) throws SQLException {
		String sql = "INSERT INTO ProductPayment VALUES (?,?,?,now())";
		if (findProductPackage(ProductPackage_name)==true) {
			try {
				conn = ds.getConnection();
				pst = conn.prepareStatement(sql);
				pst.setString(1, ProductPackage_name);
				pst.setString(2, User_id);
				pst.setInt(3, quantity);
				pst.executeUpdate();
				
			} catch (SQLException e) {e.printStackTrace();}
				return true;
		}
		else return false;
	}
	/*총 구매실적 불러오기*/
	public int total() {
		String sql = "SELECT SUM(quantity*(SELECT price FROM productpackage WHERE productpackage.name = productpayment.ProductPackage_name)) AS 총합계 FROM productpayment";
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.isBeforeFirst())
			{
				rs.next();
				int total = rs.getInt("총합계");
				return total;
			}
			
		} catch (SQLException e) {e.printStackTrace();}

		return -1;
	}

	/*상품패키지명 */
	public boolean findProductPackage(String name) throws SQLException {
		String sql="SELECT * FROM ProductPackage WHERE name = ?";
		conn = ds.getConnection();
		pst = conn.prepareStatement(sql);
		pst.setString(1,name);
		rs = pst.executeQuery();
		
		if (rs.isBeforeFirst()) return true;	//존재함		true 리턴
		else return false;						//존재않음 		false 리턴
	}
}
