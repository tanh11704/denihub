package com.tpanh.dinehub.controller;

import com.tpanh.dinehub.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> getUserById(@PathVariable Integer id) {
        return Optional.of(new UserDTO());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok("Delete user successfully");
    }
}
