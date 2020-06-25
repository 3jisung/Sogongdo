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

public class WorkPlaceDAO {
	private DataSource DataBase;
	private static WorkPlaceDAO dao = new WorkPlaceDAO();
	
	public static WorkPlaceDAO getInstance() {
		return dao;
	}

	private WorkPlaceDAO() {
		try {
			Context context = new InitialContext();
			DataBase = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void workplaceCreate(WorkPlaceDTO workplaceDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String preQuery = "INSERT INTO WorkPlace(name)"+ "VALUES (?)";
		try {
			conn = DataBase.getConnection();
		} catch (SQLException e) {
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
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception ex) {
					System.out.println("close 오류 " + ex);
				}
			}
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
		
		String preQuery = "UPDATE WorkPlace SET name=? WHERE name=?";
		try {
			conn = DataBase.getConnection();
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
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception ex) {
					System.out.println("close 오류 " + ex);
				}
			}
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
		
		String preQuery = "DELETE FROM WorkPlace WHERE name=?";
		try {
			conn = DataBase.getConnection();
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
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception ex) {
					System.out.println("close 오류 " + ex);
				}
			}
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
			conn = DataBase.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM WorkPlace");
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
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception ex) {
					System.out.println("close 오류 " + ex);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception ex) {
					System.out.println("close 오류 " + ex);
				}
			}
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
		
		String preQuery = "UPDATE WorkPlace SET state=?, tel=? WHERE name=?";
		try {
			conn = DataBase.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, workplaceDto.getState());
			pstmt.setString(2, workplaceDto.getTel());	
			pstmt.setString(3, workplaceDto.getName());
			pstmt.executeUpdate();
			pstmt=null;
			
			String preQuery2 = "INSERT INTO WorkPlaceManager(admin_id, workPlace_name)"+ "VALUES (?,?)";
			pstmt = conn.prepareStatement(preQuery2); 
			pstmt.setString(1, workplaceDto.getAdmin());
			pstmt.setString(2, workplaceDto.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception ex) {
					System.out.println("close 오류 " + ex);
				}
			}
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
		
		String preQuery = "UPDATE WorkPlace SET state=?, tel=? WHERE name=?";
		try {
			conn = DataBase.getConnection();
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
			
			preQuery = "UPDATE WorkPlaceManager SET admin_id=? WHERE workPlace_name=?";
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, workplace.getAdmin());
			pstmt.setString(2, workplace.getName());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception ex) {
					System.out.println("close 오류 " + ex);
				}
			}
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
		
		String preQuery = "UPDATE WorkPlace SET state=null, tel=null WHERE name=?";
		try {
			conn = DataBase.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, name);		
			pstmt.executeUpdate();
			pstmt=null;
			
			preQuery = "DELETE FROM WorkPlaceManager WHERE workPlace_name=?";
			pstmt = conn.prepareStatement(preQuery); 
			pstmt.setString(1, name);		
			pstmt.executeUpdate();
			pstmt=null;
			
		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception ex) {
					System.out.println("close 오류 " + ex);
				}
			}
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
			conn = DataBase.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM WorkPlace, WorkPlaceManager WHERE WorkPlace.name = WorkPlaceManager.workplace_name");
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
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception ex) {
					System.out.println("close 오류 " + ex);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception ex) {
					System.out.println("close 오류 " + ex);
				}
			}
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
