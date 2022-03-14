package com.pt;

import com.pt.model.Users;
import com.pt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class PtApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	void jpaTest(){
		Users users = new Users();
		users.setUsername("test");

		Optional<Users> user = userRepository.findByUsername("test");
		if(user.isPresent()) {
			System.out.println("비밀번호 : " + user.get().getPassword());
		}
	}

}
