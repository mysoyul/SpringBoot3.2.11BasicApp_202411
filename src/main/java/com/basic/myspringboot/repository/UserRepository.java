package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByName(String name);
    Optional<UserEntity> findByEmail(String email);
}