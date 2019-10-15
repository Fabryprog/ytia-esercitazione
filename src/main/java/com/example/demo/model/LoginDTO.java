/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;

/**
 * @author Fabrizio Spataro
 *
 */
public class LoginDTO implements Serializable {
	private static final long serialVersionUID = 4470875897796614478L;

	private String username;
	private String password;
	
	public LoginDTO(String username, String passwrd) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}



