package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import controller.readFacility;


public class FacilityDAO {
	private static FacilityDAO instance = new FacilityDAO();
	public String upid=null;
	public String wp=null;
	public String id=null;
	public String work=null;
	public String name=null;
	public static FacilityDAO getInstance(){
		return instance;
	}
	
	public void createFacility(FacilityDTO data) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://m72e.iptime.org:33061/db?serverTimezone=UTC";
		String DB_USER = "root";
		String DB_PASSWORD= "0OSE!";
		
		Connection conn=null;
		PreparedStatement ppst= null;
		ResultSet rs =null;
		String fID=data.getFacilityID();
		
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			if (upid==null) {
				String sql =  "select * from db.Facility where Facility.id='" + fID + "'";
				ppst = conn.prepareStatement(sql);
				
				rs = ppst.executeQuery();
				
				if (rs.next()) {
					System.out.println("중복된 데이터가 있습니다.");
				} else {
					ppst = conn.prepareStatement("insert into Facility(id, name, WorkPlace_name) values(?,?,?)");
					
					ppst.setString(1, data.getFacilityID());
					ppst.setString(2, data.getName());
					ppst.setString(3, data.getWorkplace());
					
					ppst.executeUpdate();
					
					System.out.println("등록 완료");
				}
			}
			
			else {
				ppst = conn.prepareStatement("update db.Facility set name=?, WorkPlace_name=? where id=?;");
				
				ppst.setString(3, upid);
				ppst.setString(1, data.getName());
				ppst.setString(2, data.getWorkplace());
				
				ppst.executeUpdate();
				
				System.out.println("수정 완료");
				
				upid=null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppst !=null) ppst.close();
				if (conn !=null) conn.close();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
	}
	
	public void deleteFacility(FacilityDTO data) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://m72e.iptime.org:33061/db?serverTimezone=UTC";
		String DB_USER = "root";
		String DB_PASSWORD= "0OSE!";
		
		Connection conn=null;
		PreparedStatement ppst= null;
		ResultSet rs =null;
		String fID=data.getFacilityID();
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			String sql =  "select * from Facility where Facility.id='" + fID + "'";
			ppst = conn.prepareStatement(sql);
			
			rs = ppst.executeQuery();
			
			if (rs.next()) {
				ppst = conn.prepareStatement("delete from db.Facility where id=?;");
				
				ppst.setString(1, fID);
						
				ppst.executeUpdate();
				
				System.out.println("삭제 완료");
			} else {
				System.out.println("일치하는 시설 번호가 없습니다.");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppst !=null) ppst.close();
				if (conn !=null) conn.close();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
	}
	
	public void updateFacility(FacilityDTO data) {
		upid = data.getFacilityID();
	}
	
	public void readFacility(FacilityDTO data) {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://m72e.iptime.org:33061/db?serverTimezone=UTC";
		String DB_USER = "root";
		String DB_PASSWORD= "0OSE!";
		
		Connection conn=null;
		PreparedStatement ppst= null;
		ResultSet rs =null;
		String sql=null;
		String fID=data.getFacilityID();
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			if (fID==null)
				sql =  "select * from db.Facility";
			else
				sql =  "select * from db.Facility where id='" + fID + "'";
			
			ppst = conn.prepareStatement(sql);
			
			rs = ppst.executeQuery();
			
			if (rs.next()) {
				data.setFacilityID(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setWorkplace(rs.getString("WorkPlace_name"));
				id=data.getFacilityID(); name=data.getName(); work=data.getWorkplace();
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppst !=null) ppst.close();
				if (conn !=null) conn.close();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
		
	}
	
	public List<FacilityDTO> readFacility(String id) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://m72e.iptime.org:33061/db?serverTimezone=UTC";
		String DB_USER = "root";
		String DB_PASSWORD= "0OSE!";
		
		Connection conn=null;
		PreparedStatement ppst= null;
		ResultSet rs =null;
		List<FacilityDTO> list = null;
		String sql=null;

		try {
			
			Class.forName(driver);
			if (id=="") {
				sql =  "select * from db.Facility ";
			}
			else {
				sql =  "select * from db.Facility where id='" + id + "'";
			}
			
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			ppst = conn.prepareStatement(sql);	
			
			rs = ppst.executeQuery();
			list = new ArrayList<>();
				
			if (rs.next()) {
				list = new ArrayList<>();
				
				do {
					FacilityDTO data = new FacilityDTO();
					
					data.setFacilityID(rs.getString("id"));
					data.setName(rs.getString("name"));
					data.setWorkplace(rs.getString("WorkPlace_name"));
					
					list.add(data);
				} while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppst !=null) ppst.close();
				if (conn !=null) conn.close();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
		
		return list;
	}
	
//속성	
	public void createFacilityAttributes(FacilityDTO data) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://m72e.iptime.org:33061/db?serverTimezone=UTC";
		String DB_USER = "root";
		String DB_PASSWORD= "0OSE!";
		
		Connection conn=null;
		PreparedStatement ppst= null;
		ResultSet rs =null;
		String fID=data.getFacilityID();
		
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql =  "select * from db.Facility where id='" + fID + "'";
			ppst = conn.prepareStatement(sql);
			rs = ppst.executeQuery();
			
			if (rs.next()) {
				
				if (upid==null) {
					if (rs.getString(5)!=null) {
						System.out.println("이미 등록되어 있습니다.");
					} else {
						ppst = conn.prepareStatement("update db.Facility set classification=?, state=?, admin_id=?, tel=?, cost=?, businessName=? where id=?;");
						
						ppst.setString(7, data.getFacilityID());
						ppst.setString(1, data.getClassification());
						ppst.setString(2, data.getState());
						ppst.setString(3, data.getManager_id());
						ppst.setString(4, data.getPhone());
						ppst.setInt(5, data.getCost());
						ppst.setString(6, data.getBusiness_name());
						ppst.executeUpdate();
						
						System.out.println("등록 완료");
					}
					
				}
				else {
					ppst = conn.prepareStatement("update db.Facility set classification=?, state=?, admin_id=?, tel=?, cost=?, businessName=? where id=?;");
					
					ppst.setString(7, upid);
					ppst.setString(1, data.getClassification());
					ppst.setString(2, data.getState());
					ppst.setString(3, data.getManager_id());
					ppst.setString(4, data.getPhone());
					ppst.setInt(5, data.getCost());
					ppst.setString(6, data.getBusiness_name());
					ppst.executeUpdate();
					
					System.out.println("수정 완료");
					
					upid=null;
				}
				
			} else{
				System.out.println("일치하는 시설번호가 없습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppst !=null) ppst.close();
				if (conn !=null) conn.close();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
	}
	
	public void updateFacilityAttributes(FacilityDTO data) {
		upid = data.getFacilityID();
	}
	
	public void deleteFacilityAttributes(FacilityDTO data) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://m72e.iptime.org:33061/db?serverTimezone=UTC";
		String DB_USER = "root";
		String DB_PASSWORD= "0OSE!";
		
		Connection conn=null;
		PreparedStatement ppst= null;
		ResultSet rs=null;
		String fID=data.getFacilityID();
		
		try { 
			Class.forName(driver);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			String sql =  "select * from db.Facility where id='" + fID + "'";
			ppst = conn.prepareStatement(sql);
			
			rs = ppst.executeQuery();
			
			if (rs.next()) {
				//ppst = conn.prepareStatement("update db.Facility set classification=null, state=null, admin_id=null, tel=null, cost=null, businessName=null where id=?;");
				ppst = conn.prepareStatement("update db.Facility set classification=null, state=null, tel=null, cost=null, businessName=null where id=?;");
				
				ppst.setString(1, fID);
						
				ppst.executeUpdate();
				
				System.out.println("삭제 완료");
			} else {
				System.out.println("일치하는 시설 번호가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppst !=null) ppst.close();
				if (conn !=null) conn.close();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
	}
	
	public List<FacilityDTO> readFacilityAttributes(String id) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://m72e.iptime.org:33061/db?serverTimezone=UTC";
		String DB_USER = "root";
		String DB_PASSWORD= "0OSE!";
		
		Connection conn=null;
		PreparedStatement ppst= null;
		ResultSet rs =null;
		List<FacilityDTO> list = null;
		String sql=null;
		
		try {
			
			Class.forName(driver);
			if (id=="")
				sql =  "select * from db.Facility ";
			else
				sql =  "select * from db.Facility where id='" + id + "'";
			
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			ppst = conn.prepareStatement(sql);	
			
			rs = ppst.executeQuery();
				
			if (rs.next()) {
				list = new ArrayList<>();
				
				do {
					FacilityDTO data = new FacilityDTO();
					
					if (rs.getString(1)==null)data.setFacilityID("-");
					else data.setFacilityID(rs.getString("id"));
					if (rs.getString(2)==null)data.setName(null);
					else data.setName(rs.getString("name"));
					if (rs.getString(3)==null)data.setWorkplace("-");
					else data.setWorkplace(rs.getString("WorkPlace_name"));
					if (rs.getString(4)==null)data.setClassification("-");
					else data.setClassification(rs.getString("classification"));
					if (rs.getString(5)==null)data.setState("-");
					else data.setState(rs.getString("state"));
					if (rs.getString(6)==null)data.setManager_id("-");
					else data.setManager_id(rs.getString("admin_id"));
					if (rs.getString(7)==null)data.setPhone("-");
					else data.setPhone(rs.getString("tel"));
					if (rs.getString(8)==null)data.setCost(0);
					else data.setCost(rs.getInt("cost"));
					if (rs.getString(9)==null)data.setBusiness_name("-");
					else data.setBusiness_name(rs.getString("businessName"));
					
					list.add(data);
					
					
				} while(rs.next());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppst !=null) ppst.close();
				if (conn !=null) conn.close();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
		
		return list;
	}


}
