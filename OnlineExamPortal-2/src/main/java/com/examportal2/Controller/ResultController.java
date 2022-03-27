package com.examportal2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal2.Model.Result;
import com.examportal2.Service.ResultService;

@RestController

@RequestMapping("/Result")
public class ResultController {
	@Autowired
	ResultService service;

	@PostMapping("/addResultDetails")
	public ResponseEntity<Result> addResultDetails(@Validated @RequestBody Result result) {
		Result r = service.addResultDetails(result);
		return new ResponseEntity<Result>(r, HttpStatus.OK);
	}

}
