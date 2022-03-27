package com.examportal2.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal2.Model.Tests;
import com.examportal2.Repository.TestRepo;

@Service

@Transactional
public class TestService {
	@Autowired
	TestRepo repo;

	public Tests addTestDetails(Tests t) {
		return repo.save(t);
	}

	public List<Tests> findResultBytestId(int testId) {

		return repo.findResultBytestId(testId);
	}

}
