package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.LoginDTO;
import com.tpanh.dinehub.dto.UserDTO;
import com.tpanh.dinehub.entity.Role;
import com.tpanh.dinehub.entity.User;
import com.tpanh.dinehub.exception.DataNotFoundException;
import com.tpanh.dinehub.reponsitory.RoleRepository;
import com.tpanh.dinehub.reponsitory.UserRepository;
import com.tpanh.dinehub.security.JwtTokenProvider;
import com.tpanh.dinehub.service.impl.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements IUserService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public User createUser(UserDTO userDTO) throws Exception {

        if(userRepository.existsByEmail(userDTO.getEmail())) {
            throw new DataIntegrityViolationException("Email already exists");
        }

        User user = new User()
                .builder()
                .email(userDTO.getEmail())
                .fullname(userDTO.getFullname())
                .password(userDTO.getPassword())
                .build();

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByRoleName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return user;
    }

    @Override
    public String login(LoginDTO loginDTO) throws Exception {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }
}
