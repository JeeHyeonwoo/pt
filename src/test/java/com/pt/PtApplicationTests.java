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

    private String mHero;

    public synchronized void batman(){
        mHero = "batman";

        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
            if ("batman".equals(mHero) == false) {
                System.out.println("synchronization broken");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void superman() {
        mHero = "superman";
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
            if ("superman".equals(mHero) == false) {
                System.out.println("synchronization broken");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void main() throws InterruptedException {
        System.out.println("Test start!");
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                batman();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                superman();
            }
        }).start();
        System.out.println("Test end!");

    }

}
