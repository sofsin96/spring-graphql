package com.example.springgraphql.service;

import com.example.springgraphql.model.Role;
import com.example.springgraphql.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role with id " + id + " not found."));
    }

    @Override
    public Role createRole(Role role) {
        if (roleRepository.existsRoleByName(role.getName())) {
            throw new RuntimeException("Role with name " + role.getName() + " already exists in the database.");
        }
        return roleRepository.save(role);
    }
}
