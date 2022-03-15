package com.pt.service;

import com.pt.model.Role;
import com.pt.model.Users;
import com.pt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LoginIdPwValidator implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String insertedId) throws UsernameNotFoundException {
        Optional<Users> userInfo = userRepository.findByUsername(insertedId);

        return userInfo.orElse(null);
    }
}
