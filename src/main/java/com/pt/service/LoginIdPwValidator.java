package com.pt.service;

import com.pt.model.Users;
import com.pt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginIdPwValidator implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String insertedId) throws UsernameNotFoundException {
        Optional<Users> userInfo = userRepository.findByUsername(insertedId);
        if(userInfo.isPresent()){
            System.out.println(userInfo.get().getUsername());
        }
        return userInfo.orElse(null);
    }
}
