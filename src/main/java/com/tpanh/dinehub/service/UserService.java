package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.UserDTO;
import com.tpanh.dinehub.entity.User;
import com.tpanh.dinehub.exception.DataNotFoundException;
import com.tpanh.dinehub.reponsitory.UserRepository;
import com.tpanh.dinehub.service.impl.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

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
        userRepository.save(user);

        return user;
    }

    @Override
    public String login(String phoneNumber, String password) {
        return null;
    }
}
