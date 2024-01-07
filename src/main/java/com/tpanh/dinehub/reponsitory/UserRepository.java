package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}