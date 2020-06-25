package common;

import model.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/db");
			conn = null;
			pstmt = null;
			rs = null;
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//회원정보등록
	public boolean createUser(User uDto) {
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO User VALUES (?, ?, ?, ?, ?, now(), ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, uDto.getId());
			pstmt.setString(2, uDto.getPassword());
			pstmt.setString(3, uDto.getName());
			pstmt.setString(4, uDto.getAddress());
			pstmt.setDate(5, Date.valueOf(uDto.getBirth()));
			pstmt.setString(6, uDto.getPhoneNumber());
			pstmt.setString(7, uDto.getEmail());
			
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return false;
	}
	
	//회원 정보 수정 전 id 확인
	public List<User> idCheck(String id) {
		List<User> updateList = new ArrayList<>();
		
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM User WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("id").equals(id)) {
					User readTarget = new User(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address"), rs.getDate("birth").toLocalDate(), rs.getTimestamp("registerDate").toLocalDateTime(), rs.getString("phoneNumber"), rs.getString("e_mail"));
					updateList.add(readTarget);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return updateList;
	}
	
	//회원정보수정
	public boolean updateUser(String id, String password, String address, String phone, String eMail) {
		try {
			conn = ds.getConnection();
			String sql = "UPDATE User SET password=?, address=?, phoneNumber=?, e_mail=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, password);
			pstmt.setString(2, address);
			pstmt.setString(3, phone);
			pstmt.setString(4, eMail);
			pstmt.setString(5, id);
			
			pstmt.executeUpdate();
			
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return false;
	}
	
	//회원정보삭제
	public boolean deleteUser(String id) {
		int result = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "DELETE FROM User WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return false;
	}
	
	//회원정보조회
	public List<User> readUser(String id) {
		List<User> readList = new ArrayList<>();
		
		if (id.equals("")) {
			try {
				conn = ds.getConnection();
				String sql = "SELECT * FROM User WHERE id LIKE \"%%\"";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					User readTarget = new User(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address"), rs.getDate("birth").toLocalDate(), rs.getTimestamp("registerDate").toLocalDateTime(), rs.getString("phoneNumber"), rs.getString("e_mail"));
					readList.add(readTarget);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				this.close(conn, pstmt, rs);
			}
		} else {
			try {
				conn = ds.getConnection();
				String sql = "SELECT * FROM User WHERE id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					User readTarget = new User(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address"), rs.getDate("birth").toLocalDate(), rs.getTimestamp("registerDate").toLocalDateTime(), rs.getString("phoneNumber"), rs.getString("e_mail"));
					readList.add(readTarget);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				this.close(conn, pstmt, rs);
			}
		}
		return readList;
	}
	
	//로그인
	public boolean logIn(String id, String pw) {
		try {
			conn = ds.getConnection();
			String sql = "SELECT password FROM User WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("password").equals(pw)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return false;
	}
	
	//connection, resultSet, preparedStatement close.
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
