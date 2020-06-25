package common;

import java.sql.*;
import java.util.*;

import javax.naming.NamingException;

import model.Authority;

public enum AuthorityDAO {
	INSTANCE;
	
	String authorityTableName = "db.Authority";
	
	public void createAuthority(String target, String action) {
		String query = "insert into " + authorityTableName + " (target, action) values (?, ?)";
		
		try (
				Connection conn = DataBase.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
				) {
			preparedStatement.setString(1, target);
			preparedStatement.setString(2, action);
			preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Authority> readAllAuthorities() {
		ArrayList<Authority> Authorities = new ArrayList<>();
		
		String query = "select * from " + authorityTableName;
		
		try (
				Connection conn = DataBase.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				) {
			
			
			try(ResultSet rs = preparedStatement.executeQuery()) {
				while(rs.next()) {
					Authorities.add(new Authority(
						rs.getInt("id"),
						rs.getString("target"), 
						rs.getString("action"))
					);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return Authorities;
	}
	
	public ArrayList<Authority> readSpecificAuthority(String tableName) {
		ArrayList<Authority> Authorities = new ArrayList<>();
		
		String query = "select * from " + authorityTableName + 
				"where target = '?'"; 
				
		try (
                Connection conn = DataBase.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
        ) {
            preparedStatement.setString(1, tableName);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                	Authorities.add(new Authority(
        					rs.getInt("id"),
        					rs.getString("target"), 
        					rs.getString("action"))
        				);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return Authorities;
	}
	
	public void updateAuthority(int id, String target, String action) {
		String query = "update " + authorityTableName + 
				"set target = '?' and action = '?'" + 
				"where id = '?'";
		
		try (
				Connection conn = DataBase.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
				) {
			preparedStatement.setString(1, target);
			preparedStatement.setString(2, action);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAuthority(int id) {
		String query = "delete from " + authorityTableName + 
				"where id = '?'";
		
		try (
				Connection conn = DataBase.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
				) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
