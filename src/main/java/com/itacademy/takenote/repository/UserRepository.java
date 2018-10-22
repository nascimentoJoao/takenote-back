package com.itacademy.takenote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.takenote.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String name);

}
