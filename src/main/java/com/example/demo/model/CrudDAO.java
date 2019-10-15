package com.example.demo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Fabrizio Spataro
 *
 */
public class CrudDAO implements Crud {
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.passwrd}")
	private String pwd;

	private final static String USER_GETALL = "select ID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD, `ROLE` FROM `USER` ";
	private final static String USER_GET = "select ID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD, `ROLE` FROM `USER` WHERE ID = ?";
	private final static String USER_CREATE = "INSERT INTO `USER` (ID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES (0, ?, ?, ?, PASSWORD(?))";
	private final static String USER_UPDATE = "UPDATE `USER` SET FIRSTNAME = ?, LASTNAME = ?, PASSWORD = PASSWORD(?) WHERE ID = ?";
	private final static String USER_DELETE = "DELETE `USER` WHERE ID = ?";
	
	private Connection jdbcConnection;

	@PostConstruct
	public void init() throws SQLException {
		this.jdbcConnection = DriverManager.getConnection(url, username, pwd);
	}

	@Override
	public List<Map<String, Object>> retrieveUsers() {
		List<Map<String, Object>> result = new LinkedList<Map<String,Object>>();
		
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			statement = jdbcConnection.prepareStatement(USER_GETALL);
         
	        rs = statement.executeQuery();
	         
	        while(rs.next()) {
	        	Map<String, Object> item = new HashMap<String, Object>();
	        	item.put("id", rs.getInt(1));
	        	item.put("firstname", rs.getString(2));
	        	item.put("lastname", rs.getString(3));
	        	item.put("username", rs.getString(4));
	        	item.put("role", rs.getInt(6));
	        	
	        	result.add(item);
	        }
	        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {rs.close();}catch (Exception e) {}
	        try {statement.close();}catch (Exception e) {}
        
		}
        return result;
	}

	@Override
	public Map<String, Object> retrieveUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> createUser(Map<String, String> body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> update(String id, Map<String, String> body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
