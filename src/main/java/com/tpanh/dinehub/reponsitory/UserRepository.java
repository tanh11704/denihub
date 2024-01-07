package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    Optional<User> findById(Integer id);
}