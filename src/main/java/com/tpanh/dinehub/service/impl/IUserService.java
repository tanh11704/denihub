package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.dto.UserDTO;
import com.tpanh.dinehub.entity.User;
import com.tpanh.dinehub.exception.DataNotFoundException;

public interface IUserService {
    User createUser(UserDTO userDTO) throws Exception;
    String login(String phoneNumber, String password);
}
