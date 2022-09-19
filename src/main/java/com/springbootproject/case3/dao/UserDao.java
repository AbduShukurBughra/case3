package com.springbootproject.case3.dao;

import com.springbootproject.case3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);

    List<User> findAllByName(String name);

}
