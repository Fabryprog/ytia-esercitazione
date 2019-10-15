/**
 * 
 */
package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CrudDAO;
import com.example.demo.model.UserDTO;

/**
 * @author Fabrizio Spataro
 *
 */
@RestController
@RequestMapping("/api/v1")
public class CrudController {

	@Autowired
	private CrudDAO crudDao;
	
    @GetMapping("/user")
    public List<Map<String, Object>> retrieveUsers(){
    	return crudDao.retrieveUsers();
    }

    @GetMapping("/user/{id}")
    public Map<String, Object> retrieveUser(@PathVariable String id){
        int userId = Integer.parseInt(id);
        
        return null;
    }
    
    @PostMapping("/user")
	public Map<String, Object> createUser(@RequestBody Map<String, Object> body) {
    	UserDTO user = new UserDTO((Integer)body.get("id"), (String)body.get("firstname"), (String)body.get("lastname"), (String)body.get("username"), (String)body.get("password"), (Integer)body.get("role"));
    	
    	return crudDao.createUser(user);
    }
    
    @PutMapping("/user/{id}")
    public Map<String, Object> update(@PathVariable String id, @RequestBody Map<String, String> body){
        int userId = Integer.parseInt(id);
        //TODO
        return null;
    }

    @DeleteMapping("/user/{id}")
    public boolean delete(@PathVariable String id){
        int userId = Integer.parseInt(id);
        //TODO 
        return true;
    }

}
