package com.examportal2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal2.Model.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {

}
