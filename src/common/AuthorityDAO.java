package common;

import java.sql.*;
import java.util.*;

import javax.naming.NamingException;

import model.Authority;

public enum AuthorityDAO {
	INSTANCE;
	
	String authorityTableName = "db.Authority";
	
	public void createAuthority(String target, String action) {
		String query = "insert ignore into db.Authority (target, action) values (?, ?)";
		
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

	public List<Authority> readAuthorities(String tableName) {
		List<Authority> Authorities = new ArrayList<>();

		String query = new String();
		boolean isEmpty = tableName.equals("");
		if(isEmpty)
			query = "select * from " + authorityTableName;
		else {
			query = "select * from " + authorityTableName +
					" where target = ?";
		}

		try (
				Connection conn = DataBase.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query)
		) {
			if(!isEmpty)
				preparedStatement.setString(1, tableName);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					Authorities.add(new Authority(
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
	
	public void updateAuthority(String originTarget, String originAction, String target, String action) {
		String query = "update " + authorityTableName + 
				" set target = ?, action = ? " +
				"where target = ? and action = ?";
		
		try (
				Connection conn = DataBase.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
				) {
			preparedStatement.setString(1, target);
			preparedStatement.setString(2, action);
			preparedStatement.setString(3, originTarget);
			preparedStatement.setString(4, originAction);
			preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAuthority(String target, String action) {
		String query = "delete from " + authorityTableName + 
				" where target = ? and action = ?";
		
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
}
