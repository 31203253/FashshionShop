package com.myclass.fashionshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.fashionshop.entity.Role;
import com.myclass.fashionshop.repository.RoleRepository;

@RestController
@RequestMapping("api/role")
public class RoleRestController {
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/getAll")
	public Object getAll() {
		List<Role> roles = roleRepository.findAll();
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public Object getById(@PathVariable Long id) {
		Role role = roleRepository.findById(id).get();
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}
	@PostMapping("/addRole")
	public Object add(@RequestBody Role role) {
		Role entity = roleRepository.save(role);
		return new ResponseEntity<Role>(entity, HttpStatus.CREATED);	
	}
	@PutMapping("/updateRole/{id}")
	public Object update(@PathVariable Long id, @RequestBody Role role ) {
		if(roleRepository.existsById(id)) {
			role.setId(id);
			Role entity = roleRepository.save(role);
			return new ResponseEntity<Role>(entity, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid Role ID!", HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/deleteRole/{id}")
	public Object delete(@PathVariable Long id) {
		if(roleRepository.existsById(id)) {
			roleRepository.deleteById(id);
			return new ResponseEntity<String>("Successfully deleted!", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Invalid Role ID!", HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
