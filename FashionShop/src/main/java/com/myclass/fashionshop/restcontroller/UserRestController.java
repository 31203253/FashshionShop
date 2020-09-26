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
import com.myclass.fashionshop.entity.User;
import com.myclass.fashionshop.repository.UserRepository;
import com.myclass.fashionshop.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserRestController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	@GetMapping("/getAll")
	public Object getAll() {
		List<User> users = userRepository.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public Object getById(@PathVariable Long id) {
		User user = userRepository.findById(id).get();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/addUser")
	public Object add(@RequestBody User user) {
		User entity = userRepository.save(user);
		return new ResponseEntity<User>(entity, HttpStatus.CREATED);
	}

	@PutMapping("/updateUser/{id}")
	public Object update(@PathVariable Long id, @RequestBody User user) {
		if (userRepository.existsById(id)) {
			user.setId(id);
			User entity = userRepository.save(user);
			return new ResponseEntity<User>(entity, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid User ID!", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteUser/{id}")
	public Object delete(@PathVariable Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return new ResponseEntity<String>("Successfully deleted!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid User ID!", HttpStatus.BAD_REQUEST);
	}

}
