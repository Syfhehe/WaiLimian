package com.syf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syf.model.User;

public interface UserRepository extends JpaRepository<User, String>
{
}
