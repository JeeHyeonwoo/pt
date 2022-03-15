package com.pt;

import com.pt.model.Board;
import com.pt.model.Users;
import com.pt.repository.BoardRepository;
import com.pt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class PtApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BoardRepository boardRepository;

	@Test
	void test() {
		Board board = new Board();
		board.setTitle("테스트");
		board.setContents("테스트 컨텐츠");
		board.setUser(userRepository.findByUsername("test").orElse(null));
		board.setCreateDate(new Date());
		boardRepository.save(board);
	}



}
