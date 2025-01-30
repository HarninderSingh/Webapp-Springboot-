package com.harry.selfweb.repository;

import com.harry.selfweb.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Users findByEmail(String email);
}
