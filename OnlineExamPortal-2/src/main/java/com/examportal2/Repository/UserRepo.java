package com.examportal2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal2.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	List<Users> findTestByUserIdAndPassword(int userId, String password);
}
