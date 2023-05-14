package com.product.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.review.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}