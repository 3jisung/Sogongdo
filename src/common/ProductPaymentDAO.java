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
			ds = (DataSource) context.lookup("java:comp/env/jdbc/db");
			conn = null;
			st = null;
			rs = null;
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/*구매내역확인*/
	public ArrayList<ProductPayment> read() {
		String sql = "SELECT * FROM db.PackagePayment";
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
		}finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
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
		return list;
	}
	
	/*상품구매*/
	public boolean createProductPayment(String ProductPackage_name, String User_id, int quantity) throws SQLException {
		String sql = "INSERT INTO db.PackagePayment VALUES (?,?,?,now())";
		boolean res = false;	
		
		try {
			if (findProductPackage(ProductPackage_name)==true) {
					conn = ds.getConnection();
					pst = conn.prepareStatement(sql);
					pst.setString(1, ProductPackage_name);
					pst.setString(2, User_id);
					pst.setInt(3, quantity);
					pst.executeUpdate();
					res = true;
			}
			else res= false;
			
		} catch (SQLException e) {e.printStackTrace();
		} finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
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
		return res;

	}
	/*총 구매실적 불러오기*/
	public int total() {
		String sql = "SELECT SUM(quantity*(SELECT price FROM db.ProductPackage WHERE ProductPackage.name = PackagePayment.ProductPackage_name)) AS 총합계 FROM db.PackagePayment";
		int res = -1;
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.isBeforeFirst())
			{
				rs.next();
				res = rs.getInt("총합계");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
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

		return res;
		
	}

	/*상품패키지명 */
	public boolean findProductPackage(String name){
		String sql="SELECT * FROM db.ProductPackage WHERE name = ?";
		boolean res = false;
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1,name);
			rs = pst.executeQuery();
		
		if (rs.isBeforeFirst()) res = true;	//존재함		true 리턴
		else res = false;						//존재않음 		false 리턴
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
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
		return res;
	}
}
