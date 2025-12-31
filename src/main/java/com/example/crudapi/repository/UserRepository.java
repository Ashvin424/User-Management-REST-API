package com.example.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
