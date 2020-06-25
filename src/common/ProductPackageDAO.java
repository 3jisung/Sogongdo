package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ProductPackage;

public class ProductPackageDAO {
	
	private DataSource ds;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ProductPackageDAO() {
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
	
	/*상품패키지 조회*/
	public ArrayList<ProductPackage> read() {
		String sql = "SELECT * FROM ProductPackage";
		ArrayList<ProductPackage> list = new ArrayList<ProductPackage>();
		
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				Integer price = rs.getInt("price");
				ProductPackage instance = new ProductPackage(name, price);
				list.add(instance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*상품패키지 등록*/
	public boolean createProductPackage(String name, int price) throws SQLException {
		String sql = "INSERT INTO ProductPackage VALUES (?,?)";
		if (findProductPackage(name)==false) {
		conn = ds.getConnection();
		pst = conn.prepareStatement(sql);
		pst.setString(1, name);
		pst.setInt(2, price);
		pst.executeUpdate();
		return true;
		}
		else return false;
	}
	
	/*상품패키지 수정*/
	public boolean updateProductPackage(String name, String newName, int newPrice) throws SQLException {
		String sql = "UPDATE ProductPackage SET name=?,price=? where name=?";
		if (findProductPackage(name)==true) {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, newName);
			pst.setInt(2, newPrice);
			pst.setString(3, name);
			pst.executeUpdate();
			return true;
		}
		else return false;
	}
	
	
	/*해당 상품패키지명 삭제 --> 이름 있으면 삭제하고 true리턴, 없으면 false*/
	public boolean deleteProductPackage(String name) throws SQLException {
		String sql = "DELETE FROM ProductPackage WHERE name=?";
		if (findProductPackage(name)==true) {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.executeUpdate();
			return true;
		}
		else return false;
	}
	
	/*해당 상품패키지명 존재?*/
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
