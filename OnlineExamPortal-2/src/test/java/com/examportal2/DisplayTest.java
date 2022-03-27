package com.examportal2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.examportal2.Model.Address;
import com.examportal2.Model.Users;
import com.examportal2.Repository.UserRepo;
import com.examportal2.Service.UserService;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class DisplayTest {
	@MockBean
	private UserRepo repo;

	@Autowired
	private UserService service;

	@Test
	public void findTestByUserIdAndPassword() {
		int userId = 20;
		String password = "Neha123";
		when(repo.findTestByUserIdAndPassword(userId, password))
				.thenReturn(Stream.of(new Users(123, "Neha123")).collect(Collectors.toList()));
		assertEquals(1, service.findTestByUserIdAndPassword(userId, password).size());
	}

	@Test
	public void saveUser() {
		Address address = new Address(125, "Kerala", 570007, "India");
		Users user = new Users(12, "Sara", "Sara123@gmail.com", "Sara123", 916465212, address);
		when(repo.save(user)).thenReturn(user);
		assertEquals(user, service.addUsersDetails(user));
	}

}
