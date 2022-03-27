package com.examportal2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examportal2.Exception.ResourceNotFoundException;
import com.examportal2.Model.Users;
import com.examportal2.Service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@PostMapping("/Users/addUserDetails")
	public ResponseEntity<Users> addUsersDetails(@Validated @RequestBody Users users) {
		Users u = service.addUsersDetails(users);
		return new ResponseEntity<Users>(u, HttpStatus.OK);
	}

	@GetMapping("/Users/TestbyUserIdAndPassword")
	public ResponseEntity<List<Users>> findTestByUserIdAndPassword(@RequestParam int userId,

			@RequestParam String password) {
		String status = null;
		List<Users> users = service.findTestByUserIdAndPassword(userId, password);

		if (!users.isEmpty()) {
			status = "Successfully Opened the test content page";
		} else {
			throw new ResourceNotFoundException("Given userId and Password is not available");
		}

		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}

}
