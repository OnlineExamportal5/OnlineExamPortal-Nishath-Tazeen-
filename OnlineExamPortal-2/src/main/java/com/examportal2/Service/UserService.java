package com.examportal2.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal2.Model.Users;
import com.examportal2.Repository.UserRepo;

@Service

@Transactional
public class UserService {

	@Autowired
	UserRepo repo;

	public Users addUsersDetails(Users u) {
		return repo.save(u);
	}

	public List<Users> findTestByUserIdAndPassword(int userId, String password) {
		return repo.findTestByUserIdAndPassword(userId, password);
	}

}
