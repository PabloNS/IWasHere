package com.example.IWasHere.data.repository;

import com.example.IWasHere.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
