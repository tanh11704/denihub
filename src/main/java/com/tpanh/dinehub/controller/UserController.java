package com.tpanh.dinehub.controller;

import com.tpanh.dinehub.dto.LoginDTO;
import com.tpanh.dinehub.dto.UserDTO;
import com.tpanh.dinehub.entity.User;
import com.tpanh.dinehub.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO user) throws Exception {
        if(!user.getPassword().equals(user.getPasswordConfirm())){
            return ResponseEntity.badRequest().body("Password does not match");
        }
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginDTO loginDTO) {
        String token = userService.login(loginDTO.getEmail(), loginDTO.getPassword());
        // Trả về token trong response
        return ResponseEntity.ok(token);
    }
}
