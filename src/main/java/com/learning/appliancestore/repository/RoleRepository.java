package com.learning.appliancestore.repository;

import com.learning.appliancestore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ivanov on 24.3.2018 г..
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
