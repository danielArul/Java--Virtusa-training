package com.example.authServermysql.repository;

import com.example.authServermysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userDetailRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String name);
}
