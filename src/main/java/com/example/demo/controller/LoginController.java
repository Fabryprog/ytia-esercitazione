/**
 * 
 */
package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginDAO;
import com.example.demo.model.LoginDTO;

/**
 * @author Fabrizio Spataro
 *
 */
@RestController
@RequestMapping("/api/v1")
public class LoginController {

	@Autowired
	private LoginDAO loginDao;
	
    @PostMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, String> body) {
    	final Map<String, Object> response = new HashMap<String, Object>();

    	response.put("username", body.get("username"));

    	boolean outcome = loginDao.exec(new LoginDTO(body.get("username"), body.get("password")));
    	
    	response.put("login", outcome);

		return response;
	}

}
