/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;

/**
 * @author fabrizio
 *
 */
public class UserDTO implements Serializable {

	private static final long serialVersionUID = -1881789677940368121L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Integer role;
	
	public UserDTO(Integer id, String firstName, String lastName, String username, String password, Integer role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
	
}
