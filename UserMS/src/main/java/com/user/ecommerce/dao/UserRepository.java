package com.user.ecommerce.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.ecommerce.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
