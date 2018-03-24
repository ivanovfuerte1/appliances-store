package com.learning.appliancestore.repository;

import com.learning.appliancestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ivanov on 24.3.2018 г..
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByEmail(String email);
}
