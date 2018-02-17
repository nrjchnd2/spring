package com.neeraj.springdbsecurity.SpringDBSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraj.springdbsecurity.SpringDBSecurity.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String first_name);

}
