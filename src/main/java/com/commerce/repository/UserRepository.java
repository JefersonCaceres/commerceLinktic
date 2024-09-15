package com.commerce.repository;


import com.commerce.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {

    Users findByUsername(String username);
}
