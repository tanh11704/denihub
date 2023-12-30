package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.RoleDTO;
import com.tpanh.dinehub.entity.Role;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Role createRole(RoleDTO role);
    List<Role> getAllRoles();
    Role updateRole(Integer id, RoleDTO role);
    void deleteRole(Integer id);
}
