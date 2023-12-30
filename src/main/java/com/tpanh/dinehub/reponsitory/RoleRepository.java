package com.tpanh.dinehub.reponsitory;

import com.tpanh.dinehub.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}