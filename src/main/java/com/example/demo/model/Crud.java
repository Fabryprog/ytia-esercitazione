package com.example.demo.model;

import java.util.List;
import java.util.Map;

/**
 * @author Fabrizio Spataro
 *
 */
public interface Crud {

	public List<Map<String, Object>> retrieveUsers();

	public Map<String, Object> retrieveUser(String id);

	public Map<String, Object> createUser(UserDTO body);

	public Map<String, Object> update(String id, Map<String, String> body);

	public boolean delete(String id);
}
