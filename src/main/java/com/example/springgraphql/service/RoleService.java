package com.example.springgraphql.service;

import com.example.springgraphql.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleById(Integer id);

    Role createRole(Role role);
}
