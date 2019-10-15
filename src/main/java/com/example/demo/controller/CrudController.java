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

/**
 * @author Fabrizio Spataro
 *
 */
public class CrudController {

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
	public Map<String, Object> createUser(@RequestBody Map<String, String> body) {
    	//TODO
    	return null;
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
