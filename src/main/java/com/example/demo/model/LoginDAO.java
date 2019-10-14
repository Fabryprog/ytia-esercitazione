package com.example.demo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Fabrizio Spataro
 *
 */
@Component
public class LoginDAO implements Login {
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String pwd;

	private final static String LOGIN = "select U.ID, U.USERNAME FROM `USER` AS U JOIN `ROLE` AS R ON U.`ROLE` = R.ID WHERE USERNAME = ? AND PASSWORD = PASSWORD(?)";
	
	private Connection jdbcConnection;

	@PostConstruct
	public void init() throws SQLException {
		this.jdbcConnection = DriverManager.getConnection(url, username, pwd);
	}

	@Override
	public boolean exec(LoginDTO l) {
		
		boolean result = false;
		
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			statement = jdbcConnection.prepareStatement(LOGIN);
			statement.setString(1, l.getUsername());
			statement.setString(2, l.getPassword());
         
	        rs = statement.executeQuery();
	         
	        result = (rs.next());
	        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {rs.close();}catch (Exception e) {}
	        try {statement.close();}catch (Exception e) {}
        
		}
        return result;
	}

}
