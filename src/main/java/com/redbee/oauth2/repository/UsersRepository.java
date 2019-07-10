package com.redbee.oauth2.repository;

import com.redbee.oauth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User,Long> {


    Optional<User> findByName(String username);
}
