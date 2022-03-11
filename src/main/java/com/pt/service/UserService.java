package com.pt.service;

import com.pt.model.Role;
import com.pt.model.Users;
import com.pt.repository.RoleRepository;
import com.pt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoginIdPwValidator validator;

    public void save(Users user) throws Exception{
        if (validator.loadUserByUsername(user.getUsername()) != null) {
            throw new Exception();
        }else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            Set<Role> roles = new HashSet<>();

            // 나중에 변경
            Role role = new Role();
            role.setId(1L);
            role.setAuthority("ROLE_USER");

            roles.add(role);
            user.setAuthorities(roles);

            userRepository.save(user);
        }
    }
}
