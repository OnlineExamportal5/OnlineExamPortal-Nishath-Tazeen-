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
import com.examportal2.Model.Tests;
import com.examportal2.Service.TestService;

@RestController
public class TestController {
	@Autowired
	TestService service;

	@PostMapping("/Test/addTestDetails")
	public ResponseEntity<Tests> addTestDetails(@Validated @RequestBody Tests test) {
		Tests t = service.addTestDetails(test);
		return new ResponseEntity<Tests>(t, HttpStatus.OK);
	}

	@GetMapping("/Test/ResultbyTestId")
	public ResponseEntity<List<Tests>> findResultBytestId(@RequestParam int testId) {

		String status = null;
		List<Tests> test = service.findResultBytestId(testId);
		if (!test.isEmpty()) {
			status = "Succesfully viewed the result page";
		} else {
			throw new ResourceNotFoundException("Given TestId is not available");
		}
		return new ResponseEntity<List<Tests>>(test, HttpStatus.OK);

	}
}
