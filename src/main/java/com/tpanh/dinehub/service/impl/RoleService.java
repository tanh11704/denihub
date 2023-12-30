package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.dto.RoleDTO;
import com.tpanh.dinehub.entity.Role;
import com.tpanh.dinehub.reponsitory.RoleRepository;
import com.tpanh.dinehub.service.IRoleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role createRole(RoleDTO role) {
        Role newRole = new Role()
                .builder()
                .roleName(role.getRoleName())
                .build();
        return roleRepository.save(newRole);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Integer id, RoleDTO role) {
        return roleRepository.findById(id)
                .map(existingRole -> {
                    existingRole.setRoleName(role.getRoleName());
                    return roleRepository.save(existingRole);
                })
                .orElseThrow(() -> new EntityNotFoundException("Role with id " + id + " not found"));
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}
