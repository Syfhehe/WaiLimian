package com.ibm.cam.spring.repository;

import com.ibm.cam.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>
{
}
