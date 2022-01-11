package com.dailtcodebuffer.userservice.repository;

import com.dailtcodebuffer.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
     User findByUserId(Long userId);
}
