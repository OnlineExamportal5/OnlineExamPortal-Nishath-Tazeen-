package com.examportal2.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal2.Model.Result;
import com.examportal2.Repository.ResultRepo;

@Service

@Transactional
public class ResultService {
	@Autowired
	ResultRepo repo;

	public Result addResultDetails(Result r) {
		return repo.save(r);
	}

}
