package com.examportal2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal2.Model.Tests;

@Repository
public interface TestRepo extends JpaRepository<Tests, Integer> {

	List<Tests> findResultBytestId(int testId);

}
