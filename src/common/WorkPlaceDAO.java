package common;

import model.WorkPlaceDTO;

import java.sql.Connection;
import java.sql.DriverManager;
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

// 싱글톤 같은데 생성자를 public으로 두신 이유가 있나요? connection 획득은 DataBase.getConnection()으로 해주시면 감사하겠습니다. 그리고 테이블이나 컬럼 이름은 설계때 했던 이름대로 수정해주시기 바랍니다.
public class WorkPlaceDAO {
	private DataSource ds;
	private static WorkPlaceDAO dao = new WorkPlaceDAO();
	
	public static WorkPlaceDAO getInstance() {
		return dao;
	}

	public WorkPlaceDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void workplaceCreate(WorkPlaceDTO workplaceDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String preQuery = "INSERT INTO workplace(name)"+ "VALUES (?)";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, workplaceDto.getName());		
			pstmt.executeUpdate();
			pstmt=null;
			
		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public void workplaceUpdate(String name, String newname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String preQuery = "UPDATE workplace SET name=? WHERE name=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, newname);	
			pstmt.setString(2, name);		
			pstmt.executeUpdate();
			pstmt=null;
			
		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public void workplaceDelete(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String preQuery = "DELETE FROM workplace WHERE name=?"; 
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, name);		
			pstmt.executeUpdate();
			pstmt=null;
			
		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public WorkPlaceDTO workplaceRead(String name) {
		return null;
		
	}

	public ArrayList<WorkPlaceDTO> workplaceList() {
		ArrayList<WorkPlaceDTO> list = new ArrayList<WorkPlaceDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		WorkPlaceDTO workplace = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM workplace");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				workplace = new WorkPlaceDTO();
				String name = rs.getString("name");
				workplace= new WorkPlaceDTO(name);
				list.add(workplace);
			}

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}


	public void workplaceInfoCreate(WorkPlaceDTO workplaceDto) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String preQuery = "UPDATE workplace SET state=?, tel=? WHERE name=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, workplaceDto.getState());
			pstmt.setString(2, workplaceDto.getTel());	
			pstmt.setString(3, workplaceDto.getName());
			pstmt.executeUpdate();
			pstmt=null;
			
			String preQuery2 = "INSERT INTO workplace_has_user(admin_id, workPlace_name)"+ "VALUES (?,?)";
			pstmt = conn.prepareStatement(preQuery2); 
			pstmt.setString(1, workplaceDto.getAdmin());
			pstmt.setString(2, workplaceDto.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void workplaceInfoUpdate(WorkPlaceDTO workplace) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String preQuery = "UPDATE workplace SET state=?, tel=? WHERE name=?"; 
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, workplace.getState());	
			pstmt.setString(2, workplace.getTel());		
			pstmt.setString(3, workplace.getName());	
			pstmt.executeUpdate();
			pstmt=null;
			
			preQuery = "UPDATE workplace_has_user SET admin_id=? WHERE workPlace_name=?";
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, workplace.getAdmin());
			pstmt.setString(2, workplace.getName());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public void workplaceInfoDelete(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String preQuery = "UPDATE workplace SET state=null, tel=null WHERE name=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, name);		
			pstmt.executeUpdate();
			pstmt=null;
			
			preQuery = "DELETE FROM workplace_has_user WHERE workPlace_name=?";
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, name);		
			pstmt.executeUpdate();
			pstmt=null;
			
		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public void workplaceInfoRead(String name) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<WorkPlaceDTO> workplaceInfoList() {
		ArrayList<WorkPlaceDTO> list = new ArrayList<WorkPlaceDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		WorkPlaceDTO workplace = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM workplace, workplace_has_user WHERE workplace.name = workplace_has_user.workplace_name");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				workplace = new WorkPlaceDTO();
				String name = rs.getString("name");
				String state = rs.getString("state");
				String tel = rs.getString("tel");
	 			String admin_id = rs.getString("admin_id");
				workplace= new WorkPlaceDTO(name, state, tel, admin_id);
				list.add(workplace);
			}

		} catch (Exception ex) {
			System.out.println("오류 발생 : " + ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
}
