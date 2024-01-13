package com.example.springbootwithpostgresqldevelopment.repo;

import com.example.springbootwithpostgresqldevelopment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
